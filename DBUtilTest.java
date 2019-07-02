import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class DBUtilTest {
	
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
	void genDBTest() {
		//genarate a TiereDB and testing the DBUtil.min method
		DBTiere<Tier> data = genTierDB("Igel", 20);
		System.out.println(data.size());
		System.out.println(data.toString() + "\n");
		System.out.println(DBUtil.min(data));
	}

	@Test
	void minTest() {
		Igel i1 = new Igel(500,2);
		Igel i2 = new Igel(300,5);
		Igel i3 = new Igel(300,29);
		Igel i4 = new Igel(250,1);
		Igel i5 = new Igel(60,29);
		Igel i6 = new Igel(6,1);
		DB<Igel> DB = new DBTiere<>(6);
		DB.appendLast(i1);
		DB.appendLast(i2);
		DB.appendLast(i3);
		DB.appendLast(i4);
		DB.appendLast(i5);
		DB.appendLast(i6);
		
		assertEquals(i6,DBUtil.min(DB));
		//System.out.println(DBUtil.min(DB));
	}

}
