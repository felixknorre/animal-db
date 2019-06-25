import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DBTiereTest {

	@Test
	void totalWeighttest() {
		Tier[] feld = new Tier[5];
		DBTiere<Tier> tierDB = new DBTiere<Tier>(feld);
		assertEquals(0, tierDB.totalWeight(), "method should give the total weight of all Tiere");
		Igel i1 = new Igel(6,1);
		Igel i2 = new Igel(6,2);
		Igel i3 = new Igel(6,7);
		tierDB.appendLast(i1);
		tierDB.appendLast(i2);
		tierDB.appendLast(i3);
		assertEquals(10, tierDB.totalWeight(), "method should give the total weight of all Tiere");
		
	}

}
