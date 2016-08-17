package c.a.m.kalah;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private final List<House> houses = new ArrayList<House>();
	private final String name;
	private int stones;
	private Store store;

	public Player(String name) {
		this.name = name;
	}

	/**
	 * Count of all stones in houses
	 */
	public int countStones() {
		return houses.stream().mapToInt((h) -> h.getStones()).sum();
	}

	public List<House> getHouses() {
		return houses;
	}

	public String getName() {
		return name;
	}

	public int getStones() {
		return stones;
	}

	public Store getStore() {
		return store;
	}

	public void setStones(int stones) {
		this.stones = stones;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public String toString() {
		return name;
	}

}
