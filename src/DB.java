public abstract class DB implements DBIF{

	int size;
	
	public boolean isEmpty() {
		return size == 0?true:false; //size==0 
	}
	public int size() {
		return this.size;
	}
	
}