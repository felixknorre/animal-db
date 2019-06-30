public interface DBIF<T> extends Iterable<T>{
	
	public boolean isEmpty();
	public int size();
	public void appendLast(T i);
	public T removeLast();
	public T get(int i);
	public void swap(int x, int y);
}
