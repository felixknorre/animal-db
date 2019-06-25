public class DBTiere<T extends Tier> extends DBFeldFix<T> {
	
	public DBTiere(T[] feld) {
		super(feld);
	}
	
	public int totalWeight() {
		int dbWeight = 0;
		
		for(int i = 1; i <= this.size(); i++) {
			dbWeight += this.get(i).weight();
		}
		return dbWeight;
	}
	

}
