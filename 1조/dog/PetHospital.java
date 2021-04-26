package j;

public class PetHospital<T> {

	
	private String name;
	private T[] dogs;
	
	
	
	public PetHospital(String name,int capacity) {
		  this.name = name;
		  dogs = (T[])(new Object[capacity]);
	}
	
	public String getName() {return name;}
	public T[] getGod() {return dogs; }
    public void add(T t) {
    	for(int i=0; i<dogs.length; i++) {
    	   if(dogs[i]==null) {
    		 	dogs[i]=t;
    	        break;
    	     } //if
          
    	}//for
   
    } //add

} //end 
	
	
	
	
	

