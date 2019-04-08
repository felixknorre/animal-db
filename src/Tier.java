
public class Tier extends Lebewesen {
	private int size;
	private int weight;
	
	public Tier(int a, int b) {	
		++maxId;
		id = maxId;
		size = a;
		weight = b;
		
	}
	public int size() {
		return size;
	}
	public int weight() {
		return weight;
	}
}
