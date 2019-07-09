import java.util.Comparator;
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
	
	public Tier min(Comparator<Tier> comp) {
		Iterator<Tier> it = (Iterator<Tier>) this.iterator();
		Tier minTier = it.next();
		Tier currentTier;
		while(it.hasNext()) {
			currentTier = it.next();
			if((comp.compare(minTier, currentTier)) > 0) {
				minTier = currentTier;
			}
		}
		return minTier;
	}
	
	@SuppressWarnings("unchecked")
	public int remove(Tier t) {
		Tier currentTier;
		int feldsize = this.size();
		DBTiere<Tier> tmpDB = new DBTiere<Tier>(feldsize);
		
		for(int i = 0; i < feldsize; i++) {
			currentTier = this.removeLast();
//			System.out.println("Gesuchtes Tier " + t);
//			System.out.println("Akt Tier: " + currentTier);
			if(currentTier.equals(t) == 0) {
//				System.out.println("Gefunden " + this.toString());
//				System.out.println(tmpDB.toString());
				int tmpsize = tmpDB.size();
				for(int j = 0; j < tmpsize; j++) {
					this.appendLast((T)tmpDB.removeLast());
				}
				return 0;
				
			} else {
				tmpDB.appendLast(currentTier);
//				System.out.println("Tmp beim anhängen"+"\n" + tmpDB.toString());
//				System.out.println("Normales nach entfernen"+"\n" + this.toString());
			}
			
		}
		return 1;
	}
	
	@Override
	void sort(Comparator<?> comp) {
		int feldsize = this.size();
		DBTiere<Tier> DB = new DBTiere<Tier>(feldsize);
		for(int i = 0; i < feldsize; i++ ) {
			Tier minTier = this.min((Comparator<Tier>) comp);
			DB.appendLast(minTier);
			this.remove(minTier);
		}
		for(Tier e : DB) {
			this.appendLast((T)e);
		}
	}
	
	public String toString() {
		String out = "";
		for(int i = 1; i <= this.size(); i++) {
			out += i + ": " + this.get(i).toString() + "\n";
		}
		return out;
	}

}
