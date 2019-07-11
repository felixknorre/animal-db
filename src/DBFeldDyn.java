import java.util.Comparator;
import java.util.Iterator;

public class DBFeldDyn<T> extends DB<T> {
	
	T[] db; // data array
	int s;  // size of the sequence
	
	@SuppressWarnings("unchecked")
	public DBFeldDyn() {
		db = (T[])new Object[1];
	}
	
	@SuppressWarnings("unchecked")
	public void grow() {
		int newSize = this.db.length * 2;
		Object[] tmpDB = new Object[newSize];
		
		for(int i = 0; i < this.size(); i++) {
			tmpDB[i] = this.db[i];
		}
		this.db = (T[])tmpDB;
	}
	
	public void appendLast(T i) {
		if(this.db.length == this.size()) {
			this.grow();
			this.db[size++] = i;
		} else {
			this.db[size++] = i;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void downsize() {
		int newSize = this.db.length / 2;
		Object[] tmpDB = new Object[newSize];
		
		for(int i = 0; i < this.size(); i++) {
			tmpDB[i] = this.db[i];
		}
		this.db = (T[])tmpDB;
		
	}

	@Override
	public T removeLast() {
			T tmT = db[--size];
			int tmpsize = this.size();
			int tmplength = this.getLength();
			double factor = ((double)tmpsize / (double)tmplength);
			if(factor <= (0.25)) {
				this.downsize();
			}
			return tmT;
	}

	@Override
	public T get(int i) {
		return db[i - 1];
	}

	@Override
	public void swap(int x, int y) {
		T tmT = this.db[x - 1];
		this.db[x - 1] = this.db[y - 1];
		this.db[y - 1] = tmT;
	}
	
private class DBFeldDynIterator implements Iterator<T>  {
		
		int lpointer;
		int rpointer;
		char direction = 'l'; // l = left to right, r = right to left
		
		public DBFeldDynIterator() {
			this.lpointer = 0;
			this.rpointer = size;
			
		}
		
		public DBFeldDynIterator(int x) {
			this.lpointer = x;
			this.rpointer = size;
		}
		
		public DBFeldDynIterator(int x, int y) {
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
	

	@Override
	public Iterator<T> iterator() {
		return new DBFeldDynIterator();
	}
	
	public Iterator<T> iterator(int x) {
		return new DBFeldDynIterator(x);
	}
	
	public Iterator<T> iterator(int x, int y) {
		return new DBFeldDynIterator(x, y);
	}
	
	public int getLength() {
		return this.db.length;
	}

	@Override
	void sort(Comparator<?> comp) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		String out = "";
		for(int i = 1; i <= this.size(); i++) {
			out += i + ": " + this.get(i).toString() + "\n";
		}
		return out;
	}

}
