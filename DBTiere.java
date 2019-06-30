import java.util.Iterator;

public class DBTiere<T extends Tier> extends DBFeldFix<T> {
	
	public DBTiere(T[] feld) {
		super(feld);
	}
	public DBTiere(int size) {
		super(size);
	}
	
	public int totalWeight() {
		int dbWeight = 0;
		
		for(int i = 1; i <= this.size(); i++) {
			dbWeight += this.get(i).weight();
		}
		return dbWeight;
	}
	
	public T maxWeightnoint() {
		T maxT = null;
		int  maxweight = 0;
		T tmpT;
		DBTiere<T> tmpArray = new DBTiere<T>(this.size);
		
		while(this.size() > 0) {
			tmpT = this.removeLast();
			tmpArray.appendLast(tmpT);
			if(tmpT.weight() > maxweight) {
				maxT = tmpT;
				maxweight = tmpT.weight();
			}
		}
		
		return maxT;
	}
	public T maxWeight() {
		T maxT = null;
		int maxWeight = 0;
		
		//extern iterator
		Iterator<T> it = this.iterator();
		
		while(it.hasNext()) {
			T nt = it.next();
			if(nt.weight() > maxWeight) {
				maxT = nt;
				maxWeight = nt.weight();
			}
		}
		
		//for each loop
//		for(T e : this) {
//			if(e.weight() > maxWeight) {
//				maxT = e;
//				maxWeight = e.weight();
//			}
//		}
		return maxT;
	}
	
	public String toString() {
		String out = "";
		for(int i = 1; i <= this.size(); i++) {
			out += i + ": " + this.get(i).toString() + "\n";
		}
		return out;
	}

}
