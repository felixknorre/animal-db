import java.util.Stack;

public class DBStack<T> extends Stack<T> implements DBIF<T>{
	
	private static final long serialVersionUID = 1L;
	private Stack<T> db;
	
	public DBStack() {
		this.db = new Stack<T>();
	}
	
	public boolean isEmpty() {
		return this.db.empty();
	}
	
	public int size() {
		return this.db.size();
	}
	@Override
	public void appendLast(T i) {
		try {
			db.push(i);
			
		} catch (Exception e) {
			System.out.println("Element konnte nicht angehänggt werden.");
		}
	}

	@Override
	public T removeLast() {
		return db.pop();
	}
	
	public T get(int i) {
		return this.db.get(i - 1);
	}

	@Override
	public void swap(int x, int y) {
		int csize = this.size();
		if(x > csize || y > csize) {
			System.out.println("Einer dex Indexe ist größer als die Stackgröße.");
			return;
		}
		
		T tmpe1 = this.db.get(x - 1);
		T tmpe2 = this.db.get(y - 1);
		
		this.db.add(x - 1, tmpe2);
		this.db.add(y - 1, tmpe1);
	}
	
	public String toString() {
		String out = "Groeße des Stacks: " + this.size() + "\n";
		
		for(T e : this.db) {
			out += e + "\n";
		}
		
		return out;
	}

}
