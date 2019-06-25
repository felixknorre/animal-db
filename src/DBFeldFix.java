
public class DBFeldFix<T> extends DB<T> {
	
	private T[] db;
	
	public DBFeldFix(T[] i) {
		db = i;
		this.size = 0;
	}
	
	public void appendLast(T i) {
		try {
			db[size++] = i;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Fehler: Kann nicht eingefüght werden!" + e.getMessage());
		}
		
	}
	public T removeLast() {
		try {
			T tmT = db[--size];
			return tmT;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Fehler: Kann nicht entfernt werden" + e.getMessage());
		}
		return null;
	}
	public T get(int i) {
		return db[i - 1];
	}
	public void swap(int x, int y) {
		T tmT = this.db[x - 1];
		this.db[x - 1] = this.db[y - 1];
		this.db[y - 1] = tmT;
	}
	public String toString() {
		String out = "";
		for(int i = 0; i < this.size(); i++) {
			out += i + ": " + db[i] + "\n";
		}
		return out;
	}

}
