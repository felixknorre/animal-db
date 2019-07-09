import java.util.Iterator;

public class DBUtil {
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> T min(DB<? extends T> db) {
		Iterator<?> it = db.iterator();
		T min = (T)it.next(); // first element 
		T a; // current element
		int comp;
		
		while(it.hasNext()) {
			a = (T) it.next();
			comp = min.compareTo(a);
			if(comp > 0) {
				min = a;
			} 
		}
		return min;
	}
}
