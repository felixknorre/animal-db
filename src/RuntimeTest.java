import java.util.Random;

public class RuntimeTest {

	public static void main(String[] args) {
		System.out.println("Start");
		final int DBSIZE = 10_000_000;
		genDBFeldFix(DBSIZE);
		genDBFeldDyn(DBSIZE);
		genDBStack(DBSIZE);

	}
	
	//help method
	public static Igel genIgel() {
		Random ra = new Random();
		return new Igel(ra.nextInt(50), ra.nextInt(50));
	}
	public static Katze genKatze() {
		Random ra = new Random();
		return new Katze(ra.nextInt(60), ra.nextInt(60));
	}
	//gen a DBFeldFix
	public static void genDBFeldFix(int size){
		long startTime = System.currentTimeMillis();
		DBFeldFix<Tier> fixdb = new DBFeldFix<>(size);
		
		for(int i = 0; i < size; i++) {
			fixdb.appendLast(genKatze());
		}
		for(int i = 0; i < size; i++) {
			fixdb.removeLast();
		}
		
		long finishTime = System.currentTimeMillis();
		System.out.println("Time to generate a DBFeldFix: " + (finishTime - startTime) + "ms," + " Size: " + fixdb.size());
	}
	//gen a DBFeldDyn
	public static void genDBFeldDyn(int size) {
		long startTime = System.currentTimeMillis();
		DBFeldDyn<Tier> dyndb = new DBFeldDyn<>();
		
		for(int i = 0; i < size; i++) {
			dyndb.appendLast(genKatze());
		}
		for(int i = 0; i < size; i++) {
			dyndb.removeLast();
		}
		
		long finishTime = System.currentTimeMillis();
		System.out.println("Time to generate a DBFeldDyn: " + (finishTime - startTime) + "ms," + " Size: " + dyndb.size());
	}
	//gen a DBStack
	public static void genDBStack(int size) {
		long startTime = System.currentTimeMillis();
		DBStack<Tier> stackdb = new DBStack<>();
		
		for(int i = 0; i < size; i++) {
			stackdb.appendLast(genKatze());
		}
		for(int i = 0; i < size; i++) {
			stackdb.removeLast();
		}
		
		long finishTime = System.currentTimeMillis();
		System.out.println("Time to generate a DBStack: " + (finishTime - startTime) + "ms," + " Size: " + stackdb.size());
	}

}
