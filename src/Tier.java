public class Tier extends Lebewesen {

	private int size;
	private int weight;
	
	public Tier(int s, int w) {
		super();
		this.size = s;
		this.weight = w;
	}
	
	public int size() {
		return this.size;
	}
	
	public int weight() {
		return this.weight;
	}
	
	public String toString() {
		return "Tier " + this.getid() + " Groeße: " + this.size + " Gewicht: " + this.weight; 
	}
	
	public static <T extends Tier> T getLarger(T t1, T t2) {
		return (t1.size() > t2.size()) ? t1 : t2;
	}
}
