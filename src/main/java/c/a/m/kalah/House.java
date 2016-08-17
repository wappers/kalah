package c.a.m.kalah;

public class House extends Pit {
	private House oppositeHouse;

	public House(Player player, int configStones) {
		super(player, configStones);
	}

	public House getOppositeHouse() {
		return oppositeHouse;
	}

	public void setOppositeHouse(House opposite) {
		this.oppositeHouse = opposite;
	}
}
