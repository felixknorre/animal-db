import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Test;

class Task3 {

	@Test
	void testtask3() {
		int dbsize = 1_000_000;
		int size, weight;
		Igel igel;
		int pos = 1;
		int expactedMaxId = 0;
		DB db = new DBFeldFix(dbsize);
		
		while(pos < dbsize) {
			size = ThreadLocalRandom.current().nextInt(10,45);
			weight = ThreadLocalRandom.current().nextInt(10,20000);
			igel = new Igel(size, weight);
			expactedMaxId++;
			//test the append method
			assertEquals(igel.id, expactedMaxId);
			db.appendLast(igel);
			//test igel at position
			assertEquals(igel, db.get(pos));
			pos++;
		}
		//are the number of element equal the size of the db ?
		assertEquals(dbsize, db.size());
		//is the expactedMaxID equal the actual maxID ?
		assertEquals(expactedMaxId, Lebewesen.maxId);
	}

}
