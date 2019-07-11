import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DBStackTest {
	
	DBStack<Igel> dbs;
	DBIF<Igel> dbi;
	Igel i1;
	Igel i2;
	Igel i3;
	
	@BeforeEach
	void init() {
		dbs = new DBStack<>();
		dbi = new DBStack<>();
		i1 = new Igel(1,2);
		i2 = new Igel(3,4);
		i3 = new Igel(5,6);
	}
	
	@Test
	@DisplayName("Empty-Test")
	void emptyTest() {
		assertTrue(dbs.isEmpty());
		dbs.appendLast(i1);
		assertFalse(dbs.isEmpty());
	}
	
	@Test
	@DisplayName("Size-Test")
	void sizeTest() {
		assertEquals(0, dbs.size(), "method should return the size of the stack");
		dbs.appendLast(i1);
		assertEquals(1, dbs.size(), "method should return the size of the stack");
	}
	
	@Test
	@DisplayName("Append-Test")
	void appendTest() {
		//check if stack is emty
		assertTrue(dbs.isEmpty());
		dbs.appendLast(i1);
		assertEquals(1, dbs.size());
		assertEquals(i1, dbs.get(1));
	}
	
	@Test
	@DisplayName("Remove-Test")
	void removeTest() {
		dbs.appendLast(i1);
		dbs.appendLast(i2);
		dbs.appendLast(i3);
		assertEquals(3, dbs.size());
		//remove one element & check size
		assertEquals(i3, dbs.removeLast());
		assertEquals(2, dbs.size());
		//remove one element & check size
		assertEquals(i2, dbs.removeLast());
		assertEquals(1, dbs.size());
		//remove one element & check size
		assertEquals(i1, dbs.removeLast());
		assertEquals(0, dbs.size());
	}
	
	@Test
	@DisplayName("Get-Test")
	void getTest() {
		dbs.appendLast(i1);
		dbs.appendLast(i2);
		dbs.appendLast(i3);
		assertEquals(i1, dbs.get(1));
		assertEquals(i2, dbs.get(2));
		assertEquals(i3, dbs.get(3));
	}
	
	@Test
	@DisplayName("Swap-Test")
	void swapTest() {
		dbs.appendLast(i1);
		dbs.appendLast(i2);
		assertEquals(i1, dbs.get(1));
		assertEquals(i2, dbs.get(2));
		dbs.swap(1,2);
		assertEquals(i2, dbs.get(1));
		assertEquals(i1, dbs.get(2));
	}
	@Test
	@DisplayName("DBStack vs DBIF")
	void StackIfTest() {
		dbs.add(i1);
		dbs.appendLast(i2);
		//it makes no sense to extends stack, because you have two arrays/stacks, but it is so in the task
		dbi.appendLast(i1);
		//if it is declared as DBIF you can only use the DBStack methods and use only one stack
	}

}
