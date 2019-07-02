import java.util.Comparator;

public abstract class DB<T> implements DBIF<T>{

	int size;
	
	public boolean isEmpty() {
		return size == 0?true:false; //size==0 
	}
	public int size() {
		return this.size;
	}
	abstract void sort(Comparator<?> comp);
	
}
