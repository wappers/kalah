package c.a.m.kalah;

import java.util.List;
import java.util.ListIterator;

/**
 * Utility for looping through a list in a forwards direction
 *
 * @param <T>
 */
public class CircularCursor<T> {

	private List<T> list;
	private int currentIndex;

	private ListIterator<T> listIterator;
	private T currentElement;

	public CircularCursor(List<T> list, int index) {
		this.list = list;
		this.listIterator = list.listIterator(index);
		this.currentElement = next();
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public T getCurrentElement() {
		return currentElement;
	}

	public T next() {
		if (listIterator.hasNext()) {
			currentIndex = listIterator.nextIndex();
			currentElement = listIterator.next();
			return currentElement;
		}
		listIterator = list.listIterator();
		return next();
	}

}
