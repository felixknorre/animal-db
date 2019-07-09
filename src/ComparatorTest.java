import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComparatorTest {

	@Test
	void CoparatorWeightTest() {
		Igel i1 = new Igel(2,3);
		Igel i2 = new Igel(60,50);
		CompareWeight cw = new CompareWeight();
		assertEquals(-1, cw.compare(i1, i2));
		assertEquals(0, cw.compare(i1, i1));
		assertEquals(1, cw.compare(i2, i1));
	}
	@Test
	void ComparatorSizeTest() {
		Igel i1 = new Igel(2,3);
		Igel i2 = new Igel(60,50);
		CompareSize cs = new CompareSize();
		assertEquals(-1, cs.compare(i1, i2));
		assertEquals(0, cs.compare(i1, i1));
		assertEquals(1, cs.compare(i2, i1));
		
	}

}
