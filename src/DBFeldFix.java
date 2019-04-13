public class DBFeldFix extends DB {

	private Igel[] db;

	public DBFeldFix(int s) {
		db = new Igel[s + 1];
	}

	public void appendLast(Igel a) {
		if (db.length > size) {
			db[size++] = a;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public Igel removeLast() {
		Igel tmIgel = db[size() - 1];
		db[size() - 1] = null;
		size--;
		return tmIgel;
	}

	public Igel get(int a) {
		return db[a];
	}

	public void swap(int a, int b) {
		Igel tmpIgel = db[a];
		db[a] = db[b];
		db[b] = tmpIgel;
	}
}
