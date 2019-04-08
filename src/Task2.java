import java.util.concurrent.ThreadLocalRandom;

public class Task2 {

	public static void main(String[] args) {
		final int ANZAHL = 10_000_000;
		DBFeldFix dbFeldFix = new DBFeldFix(ANZAHL);
		
		int i = ANZAHL;
		int size, weight;
		Igel igel;
		
		final long timeStart = System.currentTimeMillis();

		while(i-- > 0) {
			size = ThreadLocalRandom.current().nextInt(10,45+1);
			weight = ThreadLocalRandom.current().nextInt(20,2000+1);
			igel = new Igel(size, weight);
			dbFeldFix.appendLast(igel);
		}
		
		while(dbFeldFix.size > 0) {
			dbFeldFix.removeLast();
		}
		
		final long timeEnd = System.currentTimeMillis();
		System.out.println("Laufzeit: " + (timeEnd - timeStart) + "ms");

	}

}
