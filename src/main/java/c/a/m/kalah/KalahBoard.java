package c.a.m.kalah;

import java.util.ArrayList;
import java.util.List;

/**
 * The model of the Kalah Game
 * 
 * <PRE>
 *        <--- Player 1
 ------------------------    
  6   5   4   3   2   1     
                             
  7                  14    
                            
  8   9  10  11  12  13      
 ------------------------     
         Player 2 --->
 * </PRE>
 * 
 *
 */
public class KalahBoard {
	public final int configHouses;
	public final int configStones;
	private Player currentPlayer;
	private final List<String> messages = new ArrayList<String>();
	private final List<Pit> pits = new ArrayList<Pit>();
	private Player player1;
	private Player player2;

	public KalahBoard(int configStones, int configHouses) {
		this.configStones = configStones;
		this.configHouses = configHouses;
		initKalahBoard();
	}

	public void addMessage(String message) {
		messages.add(message);
	}

	public void changePlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
	}

	public void clearMessages() {
		messages.clear();
	}

	public int getConfigHouses() {
		return configHouses;
	}

	public int getConfigStones() {
		return configStones;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public CircularCursor<Pit> getHouseCursor(int index) {
		return new CircularCursor<Pit>(pits, index);
	}

	public List<String> getMessages() {
		return messages;
	}

	public List<Pit> getPits() {
		return pits;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	private void initKalahBoard() {
		// Configure Blank Board
		player1 = new Player("Player 1");
		for (int i = 0; i < configHouses; i++) {
			player1.getHouses().add(new House(player1, configStones));
		}
		player1.setStore(new Store(player1, 0));
		pits.addAll(player1.getHouses());
		pits.add(player1.getStore());

		player2 = new Player("Player 2");
		for (int i = 0; i < configHouses; i++) {
			House newHouse = new House(player2, configStones);
			House oppositeHouse = player1.getHouses().get(configHouses - i - 1);
			newHouse.setOppositeHouse(oppositeHouse);
			oppositeHouse.setOppositeHouse(newHouse);
			player2.getHouses().add(newHouse);
		}
		player2.setStore(new Store(player2, 0));
		pits.addAll(player2.getHouses());
		pits.add(player2.getStore());

		messages.add("New Board");
		changePlayer();
	}

}
