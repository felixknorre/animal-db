abstract class Tier extends Lebewesen implements Comparable<Tier> {

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

	@Override
	public int compareTo(Tier o) {
		return Integer.compare(this.size, o.size);
	}
	public int equals(Tier o) {
		if((this.size == o.size) & (this.weight == o.weight) & (this.getid() == o.getid())) {
			return 0;
		}
		return 1;
	}
}
