package c.a.m.kalah;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KalahBoardTest {
	@Test
	public void housesCountFor6x6is72() {
		KalahBoard board = new KalahBoard(6, 6);
		int sum = board.getPits().stream().mapToInt((h) -> h.getStones()).sum();
		assertEquals("total stones", 72, sum);
	}

	@Test
	public void housesCountFor4x6is48() {
		KalahBoard board = new KalahBoard(4, 6);
		int sum = board.getPits().stream().mapToInt((h) -> h.getStones()).sum();
		assertEquals("total stones", 48, sum);
	}
}
