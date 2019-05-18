import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DBFeldFixTest {
	//task 3 to 6
	//task3
	@Test
	void appendLastTest() {
		DB db = new DBFeldFix(10);
		Igel i1 = new Igel(2,3);
		Igel i2 = new Igel(21,7);
		Igel i3 = new Igel(8,23);
		
		db.appendLast(i1);
		db.appendLast(i2);
		db.appendLast(i3);
		
		//test if the igls are placed in the right order
		assertEquals(i1, db.get(1));
		assertEquals(i2, db.get(2));
		assertEquals(i3, db.get(3));

	}
	@Test 
	void maxIdtest() {
		//test the maxId
		Igel j = new Igel(2,3);
		Igel k = new Igel(4,5);
		assertEquals(5, j.getMaxId(), "j.maxid nicht 2");
		assertEquals(5, k.getMaxId(), "k.maxid nicht 2");
	}
	@Test 
	void sizetest() {
		DB db = new DBFeldFix(10);
		Igel i1 = new Igel(2,3);
		Igel i2 = new Igel(21,7);
		Igel i3 = new Igel(8,23);
		
		db.appendLast(i1);
		db.appendLast(i2);
		db.appendLast(i3);
		
		//test if the size is the same as the number of appended igels
		assertEquals(3, db.size(), "size is not the same");
	}
	
	//task 4
	@Test
	void removeLastTest() {
		//removes in the right order
		DB db = new DBFeldFix(10);
		Igel i1 = new Igel(2,3);
		Igel i2 = new Igel(21,7);
		Igel i3 = new Igel(8,23);
		
		db.appendLast(i1);
		db.appendLast(i2);
		db.appendLast(i3);
		
		assertEquals(i3, db.removeLast(), "does not remove the last");
		assertEquals(i2, db.removeLast(), "does not remove the last");
		assertEquals(i1, db.removeLast(), "does not remove the last");
	}
	@Test
	void increasesize() {
		DB db = new DBFeldFix(10);
		Igel i1 = new Igel(2,3);
		Igel i2 = new Igel(21,7);
		Igel i3 = new Igel(8,23);
		
		db.appendLast(i1);
		db.appendLast(i2);
		db.appendLast(i3);
		
		assertEquals(3, db.size(), "the size is not correct");
		db.removeLast();
		assertEquals(2, db.size(), "the size was not reduced");
		db.removeLast();
		assertEquals(1, db.size(), "the size was not reduced");
		db.removeLast();
		assertEquals(0, db.size(), "the size was not reduced");	
	}

}
