
public class DBFeldFix extends DB {
	
	private Igel[] db;
	
	public DBFeldFix(int i) {
		db = new Igel[i];
		this.size = 0;
	}
	
	public void appendLast(Igel i) {
		try {
			db[size++] = i;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Fehler: Igel kann nicht eingefüght werden!" + e.getMessage());
		}
		
	}
	public Igel removeLast() {
		try {
			Igel tmIgel = db[--size];
			return tmIgel;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Fehler: Igel kann nicht entfernt werden" + e.getMessage());
		}
		return null;
	}
	public Igel get(int i) {
		return db[i - 1];
	}
	public void swap(int x, int y) {
		Igel tmIgel = this.db[x - 1];
		this.db[x - 1] = this.db[y - 1];
		this.db[y - 1] = tmIgel;
	}
	public String toString() {
		String out = "";
		for(int i = 0; i < this.size(); i++) {
			out += i + ": " + db[i] + "\n";
		}
		return out;
	}

}
