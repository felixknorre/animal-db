
public interface DBIF {
	
	boolean isEmpty();
	int size();
	void appendLast(Igel a);
	Igel removeLast();
	Igel get(int a);
	void swap(int a, int b);

}
