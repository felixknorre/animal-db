
public abstract class DB<T> implements DBIF<T>{
	
	public int size;
	
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public int size() {
		return size;
	}
}
