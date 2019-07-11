import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DBFeldDynTest {
	
	DBFeldDyn<Igel> dbdyn;
	Igel i1;
	Igel i2;
	Igel i3;
	
	@BeforeEach
	@Test
	void init() {
		dbdyn = new DBFeldDyn<>();
		i1 = new Igel(1,2);
		i2 = new Igel(3,4);
		i3 = new Igel(5,6);
	}
	
	@Test
	@DisplayName("grow array test")
	void test() {
		assertEquals(0, dbdyn.size());
		assertEquals(1, dbdyn.getLength());
		dbdyn.appendLast(i1);
		assertEquals(1, dbdyn.size());
		assertEquals(1, dbdyn.getLength());
		dbdyn.appendLast(i2);
		assertEquals(2, dbdyn.size());
		assertEquals(2, dbdyn.getLength());
		dbdyn.appendLast(i3);
		assertEquals(3, dbdyn.size());
		assertEquals(4, dbdyn.getLength());
		dbdyn.appendLast(i3);
		assertEquals(4, dbdyn.size());
		assertEquals(4, dbdyn.getLength());
		dbdyn.appendLast(i3);
		assertEquals(5, dbdyn.size());
		assertEquals(8, dbdyn.getLength());
		dbdyn.appendLast(i3);
		assertEquals(6, dbdyn.size());
		assertEquals(8, dbdyn.getLength());
		dbdyn.appendLast(i3);
		assertEquals(7, dbdyn.size());
		assertEquals(8, dbdyn.getLength());
//		System.out.println(dbdyn.toString());
	}
	
	@Test
	@DisplayName("Downsize Test")
	void downsizeTest() {
		dbdyn.appendLast(i1);
		dbdyn.appendLast(i1);
		dbdyn.appendLast(i1);
		dbdyn.appendLast(i1);
		dbdyn.appendLast(i1);
		assertEquals(5, dbdyn.size());
		assertEquals(8, dbdyn.getLength());
		dbdyn.removeLast();
		dbdyn.removeLast();
		dbdyn.removeLast();
		assertEquals(2, dbdyn.size());
		assertEquals(4, dbdyn.getLength());
		dbdyn.removeLast();
		assertEquals(1, dbdyn.size());
		assertEquals(2, dbdyn.getLength());
		
	}

}
