
public class DBFeldFixTest {

	public static void main(String[] args) {
		//create an Igel array wiht a size of 10
		DBFeldFix test = new DBFeldFix(10);
		//create 4 Igel
		Igel I1 = new Igel(5, 3, 2);
		Igel I2 = new Igel(10, 5, 12);
		Igel I3 = new Igel(25, 34, 212);
		Igel I4 = new Igel(67, 54, 69);
		//add the 4 Igel to the DB
		test.appendLast(I1);
		test.appendLast(I2);
		test.appendLast(I3);
		test.appendLast(I4);
		//print the last Igel, remove the last and print the last again
		System.out.println("Letzter Igel: " + test.get(test.size - 1).toString());
		System.out.println(test.removeLast());
		System.out.println("Letzter Igel: " + test.get(test.size - 1).toString());
		//test the swap methode
		System.out.println("Pos. 3: " + test.get(2));
		System.out.println("Pos. 1: " + test.get(1));
		test.swap(2, 1);
		System.out.println("Pos. 3: " + test.get(2));
		System.out.println("Pos. 1: " + test.get(1));
		

	}

}
