import java.util.concurrent.ThreadLocalRandom;

public class Task2 {
	public static void main (String[] args) {
		final int Anzahl = 10_000_000;
		DB DBIgels = new DBFeldFix(Anzahl);
		int size, weight;
		Igel igel1;
		
		final long startTime = System.currentTimeMillis();
		
		//create+append 10_000_000 igels
		for(int i = 0; i < Anzahl; i++) {
			size = ThreadLocalRandom.current().nextInt(10, 45);
			weight = ThreadLocalRandom.current().nextInt(20, 20000);
			igel1 = new Igel(size, weight);
			DBIgels.appendLast(igel1);
		}
		//remove igels
		for(int i = 0; i < Anzahl; i++) {
			DBIgels.removeLast();
		}
		
		final long endTime = System.currentTimeMillis();
		System.out.println("Laufzeit: " + (endTime - startTime) + "ms");
	}
}
