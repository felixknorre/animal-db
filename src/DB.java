
public abstract class DB implements DBIF{
	
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
