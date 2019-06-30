public abstract class Lebewesen {
	private static int maxId;
	private int id;
	
	public Lebewesen() {
		maxId++;
		this.id = maxId;
	}
	
	abstract int size();
	abstract int weight();
	
	public int getid() {
		return this.id;
	}
	public int getMaxId() {
		return this.maxId;
	}
}
