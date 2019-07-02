import java.util.Comparator;

public class CompareSize implements Comparator<Tier> {

	@Override
	public int compare(Tier o1, Tier o2) {
		return Integer.compare(o1.size(), o2.size());
	}

}
