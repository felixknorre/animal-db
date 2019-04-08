
public class Goldfisch extends Tier {
	
	public Goldfisch(int a, int b) {
		super(a, b);
	}
	public String toString() {
		return "Der Goldfisch ist " + super.size() + " groß, " + super.weight() + " schwer.";
	}

}
