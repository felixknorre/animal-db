import java.util.Comparator;

public class CompareWeight implements Comparator<Tier>{

	@Override
	public int compare(Tier o1, Tier o2) {
		return Integer.compare(o1.weight(), o2.weight());
	}

	
}
