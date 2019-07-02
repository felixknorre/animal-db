import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TierTest {
	//task 10 & 11
		@Test
		void getLargertest() {
			Igel i1 = new Igel(1,2);
			Igel i2 = new Igel(3,4);
			Katze k1 = new Katze(5,6);
			String str = new String("String");
			int int1 = 1;
			Igel i3 = Tier.getLarger(i1, i2); //  Igel & Igel -> getLarger returns a Igel
			Tier t1 = Tier.getLarger(i1, k1); // Igel & Katze -> returns a Tier
			Tier t2 = Tier.getLarger(k1, i1); // Katze & Igel -> returns a Tier
			//Object o = Tier.getLarger(str, int1); // String & Integer -> Object
			//System.out.println(i3.toString() + "\n" + t1.toString()  + "\n" + t2.toString());
			
		}
		
		@Test
		void compareToTest() {
			Igel i1 = new Igel(1,2);
			Igel i2 = new Igel(3,4);
			assertEquals(-1, i1.compareTo(i2), "method should return the animal with the bigger size");
		}
		@Test
		void equalsTest() {
			Igel i1 = new Igel(1,2);
			assertEquals(0, i1.equals(i1));
		}

}
