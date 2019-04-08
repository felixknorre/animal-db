
public class Igel extends Tier {
 
	
	public Igel(int a, int b) {
		super(a, b);
	}

	public String toString() {
		return "Der Igel ist " + super.size() + " groß, " + super.weight() + " schwer.";
	}
}
