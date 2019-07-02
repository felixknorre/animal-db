import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DBTiereTest {
	
	//help method
	public static Igel genIgel() {
		Random ra = new Random();
		return new Igel(ra.nextInt(50), ra.nextInt(50));
	}
	public static Katze genKatze() {
		Random ra = new Random();
		return new Katze(ra.nextInt(60), ra.nextInt(60));
	}
	public static DBTiere<Tier> genTierDB(String typ, int s){
		
		DBTiere<Tier> data = new DBTiere<>(s);

		
		if(typ == "Igel") {
			for(int i = 0; i < s; i++) {
				data.appendLast(genIgel());
			}
		} else if(typ == "Katze") {
			for(int i = 0; i < s; i++) {
				data.appendLast(genKatze());
			}
		}
		return data;
	}
	

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
	@Test
	void maxWeightnonotTest() {
		Tier[] feld = new Tier[5];
		DBTiere<Tier> tierDB = new DBTiere<Tier>(feld);
		assertEquals(0, tierDB.totalWeight(), "method should give the total weight of all Tiere");
		Igel i1 = new Igel(6,1);
		Igel i2 = new Igel(6,20);
		Igel i3 = new Igel(6,7);
		tierDB.appendLast(i1);
		tierDB.appendLast(i2);
		tierDB.appendLast(i3);
		
		Tier maxWTier = tierDB.maxWeightnoint();
		//System.out.println(maxWTier.toString());
		assertEquals(i2, maxWTier, "the method should return the tier with the max weight");
		
	}
	
	@Test
	void maxWeightTest() {
		Tier[] feld = new Tier[5];
		DBTiere<Tier> tierDB = new DBTiere<Tier>(feld);
		assertEquals(0, tierDB.totalWeight(), "method should give the total weight of all Tiere");
		Igel i1 = new Igel(6,1);
		Igel i2 = new Igel(6,20);
		Igel i3 = new Igel(6,7);
		tierDB.appendLast(i1);
		tierDB.appendLast(i2);
		tierDB.appendLast(i3);
		
		Tier maxWTier = tierDB.maxWeightnoint();
		//System.out.println(maxWTier.toString());
		assertEquals(i2, maxWTier, "the method should return the tier with the max weight");
	}
	
	@Test
	void MinTest(){
		DBTiere<Tier> tierDB = new DBTiere<Tier>(2);
		Igel i1 = new Igel(2,100);
		Igel i2 = new Igel(6,20);
		tierDB.appendLast(i1);
		tierDB.appendLast(i2);
		//create Comparator for size
		CompareSize cs = new CompareSize();
		assertEquals(i1, tierDB.min(cs));
		//create comparator for weight 
		CompareWeight cw = new CompareWeight();
		assertEquals(i2, tierDB.min(cw));
	}
	
	@Test
	void removetest() {
		DBTiere<Tier> tierDB = new DBTiere<Tier>(4);
		Igel i1 = new Igel(10,100);
		Igel i2 = new Igel(20,200);
		Igel i3 = new Igel(30,300);
		Igel i4 = new Igel(40,400);
		tierDB.appendLast(i1);
		tierDB.appendLast(i2);
		tierDB.appendLast(i3);
		tierDB.appendLast(i4);
		System.out.println(tierDB.toString());
		System.out.println("Remove " + i2.toString());
		tierDB.remove(i2);
		System.out.println(tierDB.toString());
		System.out.println("Remove " + i1.toString());
		tierDB.remove(i1);
		System.out.println(tierDB.toString());
	}
	@Test
	void sortTest() {
		DBTiere<Tier> tierDB = new DBTiere<Tier>(4);
		Igel i1 = new Igel(10,100);
		Igel i2 = new Igel(20,200);
		Igel i3 = new Igel(30,300);
		Igel i4 = new Igel(40,400);
		tierDB.appendLast(i3);
		tierDB.appendLast(i4);
		tierDB.appendLast(i1);
		tierDB.appendLast(i2);
		System.out.println("Before SORT" + "\n" + tierDB.toString());
		tierDB.sort(new CompareSize());
		System.out.println("After SORT" + "\n" + tierDB.toString());
	}
	
	@Test
	void RandomSortTest() {
		DBTiere<Tier> datasize = genTierDB("Igel", 20);
		System.out.println("Before SORT" + "\n" +datasize.toString());
		datasize.sort(new CompareSize());
		System.out.println("After SORT SIZE" + "\n" + datasize.toString());
		DBTiere<Tier> dataweight = genTierDB("Igel", 20);
		System.out.println("Before SORT" + "\n" +dataweight.toString());
		dataweight.sort(new CompareWeight());
		System.out.println("After SORT WEIGHT" + "\n" + dataweight.toString());
	}
	
	

	

}
