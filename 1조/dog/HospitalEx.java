package j;

import java.util.Arrays;


public class HospitalEx {
	
	                 //��� ������ ������
	public static void allDog (PetHospital<?> hsp) {    
           System.out.println(hsp.getName()
             + Arrays.toString(hsp.getGod()));
           System.out.println("--------------------------"
           		+ "--------------------------");
	}
	
	                //���� ������ ������                             (Coca,Beagle,Schnauzer)
	public static void permission (PetHospital <? extends gDog> hsp) {
	       System.out.println(hsp.getName()
	          + Arrays.toString(hsp.getGod()));
	       System.out.println("--------------------"
	       		+ "-----------------------------");	
	}
	
	              //���� ������ ������                                  (Chihuahua,poodle)
	public static void rejectDog (PetHospital <? extends NgDog> hsp) {
	       System.out.println(hsp.getName()
		    + Arrays.toString(hsp.getGod()));
		   System.out.println("----------------------"
		   		+ "-----------------");	
	}
	
	

             
	public static void main(String[] args) {
		     
		          //��� ������
		 PetHospital<Dog> all = new PetHospital<Dog>("��� ������",5);
		 all.add(new Coca("Coca")); 
		 all.add(new Beagle("Beagle"));  
		 all.add(new Schnauzer("Schnauzer"));  
		 all.add(new Chihuahua("Chihuahua"));  
		 all.add(new poodle("poodle"));  

                
		          //gDog ����
		 PetHospital<gDog> gAll = new PetHospital<gDog>("���� ������ ������ --> ",3);
		 gAll.add(new Coca("Coca"));  
		 gAll.add(new Schnauzer("Beagle"));  
		 gAll.add(new Schnauzer("Schnauzer"));  
		
		          //gDog �ڽ� ��ü
		 PetHospital<Coca> dogCoca = new PetHospital <Coca>("������ ������-->",1);
		 dogCoca.add(new Coca("Coca"));
		 
		 PetHospital<Beagle> dogBeagle = new PetHospital <Beagle>("������ ������-->",1);
		 dogBeagle.add(new Beagle("Beagle"));
		 
		 PetHospital<Schnauzer> dogSchnauzer = new PetHospital <Schnauzer>("������ ������-->",1);
		 dogSchnauzer.add(new Schnauzer("Schnauzer"));
		 
		 
  //-----------------------------------------------------//
		 	
                  //NgDog ����
		 PetHospital<NgDog> ngAll = new PetHospital<NgDog>("���� ������ ������ -->",2);
		 ngAll.add(new Chihuahua("Chihuahua"));  
		 ngAll.add(new poodle("poodle"));  
	
		 
		 
		 allDog(all);        //��簭����
		 System.out.println("");
		 
		 permission(gAll);   //���� ���� ������
		 System.out.println("");
		
		 System.out.println("\t ***���� �Ϸ� �� ������*** ");
		 permission(dogCoca);
		 permission(dogBeagle);
		 permission(dogSchnauzer);
		 System.out.println();
		 
		 		 
		 rejectDog(ngAll);    //���� ������ ������
		 System.out.println("");
		
		 
		 
		 

	} //main

} //end class
