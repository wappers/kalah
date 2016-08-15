package c.a.m.kalah;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int stones;
	private List<House> houses = new ArrayList<House>();
	private Store store;
	private String name;

	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getStones() {
		return stones;
	}

	public void setStones(int stones) {
		this.stones = stones;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}

	public List<House> getHouses() {
		return houses;
	}

	@Override
	public String toString() {
		return name;
	}

	public int countStones() {
		return houses.stream().mapToInt((h) -> h.getStones()).sum();
	}

}
