public interface DBIF {
	
	public boolean isEmpty();
	public int size();
	public void appendLast(Igel i);
	public Igel removeLast();
	public Igel get(int i);
	public void swap(int x, int y);
}
