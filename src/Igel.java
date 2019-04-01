
public class Igel extends Tier {
 
	private int stacheln;
	public Igel(int a, int b, int c) {
		super(a, b);
		stacheln = c;
	}
	public int getStacheln() {
		return stacheln;
	}
	public String toString() {
		return "Der Igel ist " + super.size() + " groß, " + super.weight() + " schwer und hat " + getStacheln() + " Stacheln";
	}
}
