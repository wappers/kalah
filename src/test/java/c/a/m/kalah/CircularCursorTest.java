package c.a.m.kalah;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CircularCursorTest {
	@Test
	public void loopAround() {
		List<String> items = new ArrayList<String>();
		items.add("one");
		items.add("two");
		items.add("three");
		items.add("four");
		items.add("five");
		items.add("six");
		items.add("seven");
		items.add("eight");
		items.add("nine");
		items.add("ten");
		items.add("eleven");

		CircularCursor<String> cursor = new CircularCursor<String>(items, 0);
		Assert.assertEquals("currentElement", "one", cursor.getCurrentElement());
		Assert.assertEquals("currentElement", 0, cursor.getCurrentIndex());

		Assert.assertEquals("currentElement", "two", cursor.next());
		Assert.assertEquals("currentElement", 1, cursor.getCurrentIndex());

		// Loop around once
		for (int i = 0; i < 12; i++) {
			cursor.next();
		}

		Assert.assertEquals("currentElement", "three", cursor.getCurrentElement());
		Assert.assertEquals("currentElement", 2, cursor.getCurrentIndex());
	}
}
