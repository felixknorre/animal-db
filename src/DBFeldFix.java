public class DBFeldFix<T> extends DB<T> {

	private T[] db;

	public DBFeldFix(int s) {
		db = (T[]) (new Object[s]);
	}
	
	public void appendLast(T t) {
		if (db.length > size) {
			db[size++] = t;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	

	public T removeLast() {
		T tmItem = db[size() -1];
		db[size() - 1] = null;
		size--;
		return tmItem;
	}

	public T get(int a) {
		return db[a];
	}

	public void swap(int a, int b) {
		T tmpItem = db[a];
		db[a] = db[b];
		db[b] = tmpItem;
	}
}
