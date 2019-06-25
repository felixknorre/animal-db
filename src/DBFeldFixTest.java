import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DBFeldFixTest {
	//task 3 to 6
	//task3
	
	@Test 
	void maxIdtest() {
		//test the maxId
		//can chance when the test order chances
		Igel j = new Igel(2,3);
		Igel k = new Igel(4,5);
		assertEquals(8, j.getMaxId(), "j.maxid nicht 2");
		assertEquals(8, k.getMaxId(), "k.maxid nicht 2");
	}
	
	@Test
	void appendLastTest() {
		Igel[] igelFeld = new Igel[5];
		DB<Igel> db = new DBFeldFix<>(igelFeld);
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
	void sizetest() {
		Igel[] igelFeld = new Igel[10];
		DB<Igel> db = new DBFeldFix<>(igelFeld);
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
		Igel[] igelFeld = new Igel[10];
		DB<Igel> db = new DBFeldFix<>(igelFeld);
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
		Igel[] igelFeld = new Igel[10];
		DB<Igel> db = new DBFeldFix<>(igelFeld);
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
	//task 7
	//insert  amselFeld into a DB<Tier> + append an Igel
	
	@Test
	void insertIntoTierDb() {
		Amsel[] amselFeld = new Amsel[5];
		DB<Tier> tierDB = new DBFeldFix<>(amselFeld);
		Amsel a1 = new Amsel(1,2);
		Amsel a2 = new Amsel(3,4);
		Igel i1 = new Igel(2,3);
		tierDB.appendLast(a1);
		tierDB.appendLast(a2);
		//tierDB.appendLast(i1); -> ArrayStoreExeption 
	}
	//task 8
	@Test
	void generictest() {
		//8.2
		//insert a cat in an Igel DB
		Igel[] igelFeld = new Igel[10];
		DB<Igel> db = new DBFeldFix<>(igelFeld);
		Igel i1 = new Igel(1,2);
		db.appendLast(i1);
		Katze k1 = new Katze(9,8);
		//db.appendLast(k1); doesnt work
		//8.3
		//insert a cat in an animal DB
		Tier[] tierFeld = new Tier[10];
		DB<Tier> dbTier = new DBFeldFix<>(tierFeld);
		assertTrue(dbTier.isEmpty()); // is db empty ?
		dbTier.appendLast(k1);
		assertEquals(1, dbTier.size()); // has the db now the size of 1 ? 
		assertEquals(k1, dbTier.get(1)); // is the cat in the db ?
		k1 = (Katze)dbTier.get(1); // you have to cast when you withdraw the object
		//8.4
		//insert cats an blackbird in an animal DB
		Katze k2 = new Katze(565,65);
		Katze k3 = new Katze(34,23);
		Amsel a1 = new Amsel(23,23);
		Amsel a2 = new Amsel(2,26);
		Amsel a3 = new Amsel(13,73);
		//insert animals
		dbTier.appendLast(k2);
		dbTier.appendLast(k3);
		dbTier.appendLast(a1);
		dbTier.appendLast(a2);
		dbTier.appendLast(a3);
		assertEquals(6, dbTier.size()); // all animal in the db ?
		assertEquals(a1, dbTier.get(4)); // you don't have to cast at that point
		Amsel a4 = (Amsel)dbTier.get(4); // you have to cast hier
		Tier t1 = dbTier.get(1);
		Tier t2 = dbTier.get(4);	
	}
}
