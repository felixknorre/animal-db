import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DBFeldFixTest {
	

	@Test
	void testRemoveLast() {
		//create new db
		DBFeldFix dbFeldFix = new DBFeldFix(10);
		//create new igel
		Igel igel0 = new Igel(1, 2, 3);
		Igel igel1 = new Igel(4, 5, 7);
		Igel igel2 = new Igel(8, 9, 10);
		Igel igel3 = new Igel(11, 12, 13);
		//append igels
		dbFeldFix.appendLast(igel0);
		dbFeldFix.appendLast(igel1);
		dbFeldFix.appendLast(igel2);
		dbFeldFix.appendLast(igel3);
		//def. the expected outcome
		int[] expected = {igel3.weight(), igel3.size(), igel3.getStacheln()};
		//def. actual outcome
		Igel actualIgel = dbFeldFix.removeLast();
		int[] actual = {actualIgel.weight(), actualIgel.size(), actualIgel.getStacheln()};
		//compare
		assertArrayEquals(expected, actual, "The method should remove and return the last item");
	}
	
	@Test
	void testGet() {
		//create new db
		DBFeldFix dbFeldFix = new DBFeldFix(10);
		//create new igel
		Igel igel0 = new Igel(1, 2, 3);
		Igel igel1 = new Igel(4, 5, 7);
		Igel igel2 = new Igel(8, 9, 10);
		Igel igel3 = new Igel(11, 12, 13);
		//append igels
		dbFeldFix.appendLast(igel0);
		dbFeldFix.appendLast(igel1);
		dbFeldFix.appendLast(igel2);
		dbFeldFix.appendLast(igel3);
		//def. the expected outcome
		int[] expected = {igel0.weight(), igel0.size(), igel0.getStacheln()};
		//def. actual outcome
		int[] actual = {dbFeldFix.get(0).weight(), dbFeldFix.get(0).size(), dbFeldFix.get(0).getStacheln()};
		//compare
		assertArrayEquals(expected, actual, "The method should get the item at the position x");
	}
	
	@Test
	void testAppendLast() {
		//create new db
		DBFeldFix dbFeldFix = new DBFeldFix(10);
		//create new igel
		Igel igel0 = new Igel(1, 2, 3);
		Igel igel1 = new Igel(4, 5, 7);
		Igel igel2 = new Igel(8, 9, 10);
		Igel igel3 = new Igel(11, 12, 13);
		//append igels
		dbFeldFix.appendLast(igel0);
		dbFeldFix.appendLast(igel1);
		dbFeldFix.appendLast(igel2);
		dbFeldFix.appendLast(igel3);
		//def. expected outcome
		Igel[] expectedIgels = {igel0, igel1, igel2, igel3, null, null, null, null, null, null};
		//compare
		for (int i = 0; i < dbFeldFix.size; i++) {
			int[] expected = {expectedIgels[i].weight(), expectedIgels[i].size(), expectedIgels[i].getStacheln()};
			int[] actual = {dbFeldFix.get(i).weight(), dbFeldFix.get(i).size(), dbFeldFix.get(i).getStacheln()};
			assertArrayEquals(expected, actual, "The method should append a item to the db");
			
		}
	}
	
	@Test
	void testSwap() {
		//create new db
		DBFeldFix dbFeldFix = new DBFeldFix(10);
		//create new igel
		Igel igel0 = new Igel(1, 2, 3);
		Igel igel1 = new Igel(4, 5, 7);
		Igel igel2 = new Igel(8, 9, 10);
		Igel igel3 = new Igel(11, 12, 13);
		//append igels
		dbFeldFix.appendLast(igel0);
		dbFeldFix.appendLast(igel1);
		dbFeldFix.appendLast(igel2);
		dbFeldFix.appendLast(igel3);
		//def. expected items in position x
		int[] expectedpos1 = {igel3.weight(), igel3.size(), igel3.getStacheln()};
		int[] expectedpos3 = {igel1.weight(), igel1.size(), igel1.getStacheln()};
		//swap item 1 and item 3
		dbFeldFix.swap(1, 3);
		//get actual items in position x
		int[] actualpos1 = {dbFeldFix.get(1).weight(), dbFeldFix.get(1).size(), dbFeldFix.get(1).getStacheln()};
		int[] actualpos3 = {dbFeldFix.get(3).weight(), dbFeldFix.get(3).size(), dbFeldFix.get(3).getStacheln()};
		//compare
		assertArrayEquals(expectedpos1, actualpos1, "The method should swap two items in the db");
		assertArrayEquals(expectedpos3, actualpos3, "The method should swap two items in the db");
		
	}

}