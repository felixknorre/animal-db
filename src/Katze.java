
public class Katze extends Tier {
	
	public Katze(int a, int b) {
		super(a, b);
	}
	public String toString() {
		return "Die Katze ist " + super.size() + " groß, " + super.weight() + " schwer.";
	}

}
