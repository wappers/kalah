package c.a.m.kalah;

public class Pit {
	private Pit oppositeHouse;
	private final Player player;
	private int stones;

	public Pit(Player player, int configStones) {
		this.player = player;
		this.stones = configStones;
	}

	public int getStones() {
		return stones;
	}

	public int takeStones() {
		int currentStones = stones;
		stones = 0;
		return currentStones;
	}

	public void setStones(int stones) {
		this.stones = stones;
	}

	public Pit getOppositeHouse() {
		return oppositeHouse;
	}

	public void setOppositeHouse(Pit opposite) {
		this.oppositeHouse = opposite;
	}

	public Player getPlayer() {
		return player;
	}

	public void addStone() {
		stones++;
	}

	public void addStones(int newStones) {
		stones += newStones;
	}

	public boolean isEmpty() {
		return stones == 0;
	}
}
