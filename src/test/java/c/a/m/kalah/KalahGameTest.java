package c.a.m.kalah;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;

/**
 * When internationalised this may check for message keys
 *
 */
public class KalahGameTest {
	private KalahGame game = new KalahGame();

	@Test
	public void testPlayer2Wins() {
		// Given
		KalahBoard board = new KalahBoard(6, 6);
		arrayToBoard(new int[] { 0, 0, 0, 0, 0, 1, 16, 0, 1, 1, 1, 1, 1, 16 }, board);

		// When
		game.go(board, 6);

		// Then
		assertEquals("Message", "Player 2 wins!", board.getMessages().get(0));
		assertArrayEquals("Result", new int[] { 0, 0, 0, 0, 0, 0, 17, 0, 0, 0, 0, 0, 0, 21 }, boardToArray(board));
	}

	@Test
	public void testPlayer1Wins() {
		KalahBoard board = new KalahBoard(6, 6);
		arrayToBoard(new int[] { 0, 0, 0, 0, 0, 1, 30, 0, 1, 1, 1, 1, 1, 16 }, board);

		game.go(board, 6);

		assertEquals("Message", "Player 1 wins!", board.getMessages().get(0));
		assertArrayEquals("Result", new int[] { 0, 0, 0, 0, 0, 0, 31, 0, 0, 0, 0, 0, 0, 21 }, boardToArray(board));
	}

	@Test
	public void testPlayer1AdditionalMove() {
		KalahBoard board = new KalahBoard(6, 6);
		arrayToBoard(new int[] { 0, 0, 1, 0, 0, 1, 16, 0, 1, 1, 1, 1, 1, 16 }, board);

		game.go(board, 6);

		assertEquals("Message", "Player 1 gets an additional move", board.getMessages().get(0));
		assertArrayEquals("Result", new int[] { 0, 0, 1, 0, 0, 0, 17, 0, 1, 1, 1, 1, 1, 16 }, boardToArray(board));
	}

	@Test
	public void testPlayer1CaptureSeeds() {

	}

	/**
	 * Convert the count of stones to an array, like on wikipedia, use to verify
	 * board state
	 * 
	 * *
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
	 * @return
	 */
	private int[] boardToArray(KalahBoard board) {
		int[] stonesArray = new int[board.getPits().size()];
		for (int i = 0; i < stonesArray.length; i++) {
			stonesArray[i] = board.getPits().get(i).getStones();
		}
		return stonesArray;
	}

	/**
	 * set the board state
	 * 
	 * *
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
	 * @param stones
	 */
	private void arrayToBoard(int[] stones, KalahBoard board) {
		Iterator<Pit> pits = board.getPits().iterator();
		for (int stone : stones) {
			pits.next().setStones(stone);
		}
	}
}
