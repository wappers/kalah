package c.a.m.kalah;

/**
 * Stateless Logic for the Game of Kalah is as follows:
 * <OL>
 * <LI>The game provides a Kalah board and a number of seeds or counters. The
 * board has 12 small pits, called pits, on each side; and a big pit, called an
 * end zone, at each end. The object of the game is to capture more seeds than
 * one's opponent.
 * <LI>At the beginning of the game, four seeds are placed in each house. This
 * is the traditional method.
 * <LI>Each player controls the six pits and their seeds on the player's side of
 * the board. The player's score is the number of seeds in the store to their
 * right.
 * <LI>Players take turns sowing their seeds. On a turn, the player removes all
 * seeds from one of the pits under their control. Moving counter-clockwise, the
 * player drops one seed in each house in turn, including the player's own store
 * but not their opponent's.
 * <LI>If the last sown seed lands in an empty house owned by the player, and
 * the opposite house contains seeds, both the last seed and the opposite seeds
 * are captured and placed into the player's store.
 * <LI>If the last sown seed lands in the player's store, the player gets an
 * additional move. There is no limit on the number of moves a player can make
 * in their turn.
 * <LI>When one player no longer has any seeds in any of their pits, the game
 * ends. The other player moves all remaining seeds to their store, and the
 * player with the most seeds in their store wins.
 * </OL>
 * It is possible for the game to end in a draw.
 * 
 *
 */
public class KalahGame {

	private Player checkForWinner(KalahBoard board) {
		if (board.getPlayer1().getStore().getStones() > board.getPlayer2().getStore().getStones()) {
			board.addMessage("Player 1 wins!");
			return board.getPlayer1();
		} else if (board.getPlayer1().getStore().getStones() < board.getPlayer2().getStore().getStones()) {
			board.addMessage("Player 2 wins!");
			return board.getPlayer2();
		} else {
			// Draw
			board.addMessage("Its a draw!");
			return null;
		}
	}

	public void go(KalahBoard board, int houseNumber) {
		CircularCursor<Pit> cursor = board.getHouseCursor(houseNumber - 1);

		/**
		 * Players take turns sowing their seeds. On a turn, the player removes
		 * all seeds from one of the houses under their control. Moving
		 * counter-clockwise, the player drops one seed in each house in turn, .
		 */
		Pit pit = board.getPits().get(houseNumber - 1);
		if (pit.getPlayer() != board.getCurrentPlayer()) {
			board.addMessage("Wrong player");
			return;
		}
		board.clearMessages();

		int stones = pit.takeStones();
		for (int i = stones; i > 0; i--) {
			pit = cursor.next();
			if (pit instanceof Store && pit.getPlayer() != board.getCurrentPlayer()) {
				/**
				 * including the player's own store but not their opponent's
				 */
				pit = cursor.next();
			}
			/**
			 * If the last sown seed lands in an empty house owned by the
			 * player, and the opposite house contains seeds,
			 */
			if (pit instanceof House && i == 1 && pit.isEmpty() && pit.getPlayer() == board.getCurrentPlayer()
					&& !((House) pit).getOppositeHouse().isEmpty()) {
				/**
				 * both the last seed and the opposite seeds are captured and
				 * placed into the player's store.
				 */
				board.addMessage(board.getCurrentPlayer() + " captures " + ((House) pit).getOppositeHouse().getStones()
						+ " stones");
				board.getCurrentPlayer().getStore().addStones(1 + ((House) pit).getOppositeHouse().takeStones());

			} else {
				pit.addStone();
			}
		}

		/**
		 * <LI>
		 * <LI>If the last sown seed
		 * <LI>When one player no longer has any seeds in any of their houses,
		 * the game ends. The other player moves all remaining seeds to their
		 * store, and the player with the most seeds in their store wins.
		 * </OL>
		 **/
		int player1Stones = board.getPlayer1().countStones();
		int player2Stones = board.getPlayer2().countStones();
		if (player1Stones == 0) {
			board.getPlayer2().getStore().addStones(player2Stones);
			board.getPlayer2().getHouses().forEach((player2house) -> {
				player2house.setStones(0);
			});

			checkForWinner(board);
		}
		if (player2Stones == 0) {
			board.getPlayer1().getStore().addStones(player1Stones);
			board.getPlayer2().getHouses().forEach((player1house) -> {
				player1house.setStones(0);
			});
			checkForWinner(board);
		}

		/**
		 * If the last sown seed lands in the player's store, the player gets an
		 * additional move. There is no limit on the number of moves a player
		 * can make in their turn.
		 */
		if (cursor.getCurrentElement() == board.getCurrentPlayer().getStore()) {
			board.addMessage(board.getCurrentPlayer() + " gets an additional move");
		} else {
			board.changePlayer();
		}
	}

}
