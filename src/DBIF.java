
public interface DBIF<T> {
	
	boolean isEmpty();
	int size();
	void appendLast(T t);
	T removeLast();
	T get(int a);
	void swap(int a, int b);

}
