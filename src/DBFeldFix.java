import java.util.Iterator;

public class DBFeldFix<T> extends DB<T> {
	
	private T[] db;
	
	public DBFeldFix(T[] i) {
		this.db = i;
		this.size = 0;
	}
	@SuppressWarnings("unchecked")
	public DBFeldFix(int size) {
		this.db = (T[])new Object[size];
		this.size = 0;
	}
	
	private class DBFeldFixIterator implements Iterator<T>  {
		
		int lpointer;
		int rpointer;
		char direction = 'l'; // l = left to right, r = right to left
		
		public DBFeldFixIterator() {
			this.lpointer = 0;
			this.rpointer = size;
			
		}
		
		public DBFeldFixIterator(int x) {
			this.lpointer = x;
			this.rpointer = size;
		}
		
		public DBFeldFixIterator(int x, int y) {
			if(x > y) {
				this.direction = 'r';
				this.lpointer = y - 1;
				this.rpointer = x - 1;
			} else {
				this.lpointer = x;
				this.rpointer = y;
			}

		}

		@Override
		public boolean hasNext() {
			return (this.lpointer) < this.rpointer;
		}

		@Override
		public T next() {
			
			if(this.direction == 'r') {
				try {
					T tmp = db[rpointer];
					rpointer--;
					return tmp;
					
				} catch (Exception e) {
					throw new java.util.NoSuchElementException();
				}
			} else {
				
				try {
					T tmp = db[lpointer];
					lpointer++;
					return tmp;
					
				} catch (Exception e) {
					throw new java.util.NoSuchElementException();
				}
				
			}
			
		}
	}
	
	//all elements
	public Iterator<T> iterator(){
		return new DBFeldFixIterator();
	}
	
	//from element x to the last
	public Iterator<T> iterator(int x){
		return new DBFeldFixIterator(x);
	}
	
	//from element x to element y
	public Iterator<T> iterator(int x, int y){
		return new DBFeldFixIterator(x, y);
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
		for(int i = 1; i <= this.size(); i++) {
			out += i + ": " + this.get(i).toString() + "\n";
		}
		return out;
	}
}
