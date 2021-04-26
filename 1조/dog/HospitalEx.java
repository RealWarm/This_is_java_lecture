package j;

import java.util.Arrays;


public class HospitalEx {
	
	                 //모든 종류의 강아지
	public static void allDog (PetHospital<?> hsp) {    
           System.out.println(hsp.getName()
             + Arrays.toString(hsp.getGod()));
           System.out.println("--------------------------"
           		+ "--------------------------");
	}
	
	                //진찰 가능한 강아지                             (Coca,Beagle,Schnauzer)
	public static void permission (PetHospital <? extends gDog> hsp) {
	       System.out.println(hsp.getName()
	          + Arrays.toString(hsp.getGod()));
	       System.out.println("--------------------"
	       		+ "-----------------------------");	
	}
	
	              //진찰 거절된 강아지                                  (Chihuahua,poodle)
	public static void rejectDog (PetHospital <? extends NgDog> hsp) {
	       System.out.println(hsp.getName()
		    + Arrays.toString(hsp.getGod()));
		   System.out.println("----------------------"
		   		+ "-----------------");	
	}
	
	

             
	public static void main(String[] args) {
		     
		          //모든 강아지
		 PetHospital<Dog> all = new PetHospital<Dog>("모든 강아지",5);
		 all.add(new Coca("Coca")); 
		 all.add(new Beagle("Beagle"));  
		 all.add(new Schnauzer("Schnauzer"));  
		 all.add(new Chihuahua("Chihuahua"));  
		 all.add(new poodle("poodle"));  

                
		          //gDog 종류
		 PetHospital<gDog> gAll = new PetHospital<gDog>("진찰 가능한 강아지 --> ",3);
		 gAll.add(new Coca("Coca"));  
		 gAll.add(new Schnauzer("Beagle"));  
		 gAll.add(new Schnauzer("Schnauzer"));  
		
		          //gDog 자식 객체
		 PetHospital<Coca> dogCoca = new PetHospital <Coca>("진찰된 강아지-->",1);
		 dogCoca.add(new Coca("Coca"));
		 
		 PetHospital<Beagle> dogBeagle = new PetHospital <Beagle>("진찰된 강아지-->",1);
		 dogBeagle.add(new Beagle("Beagle"));
		 
		 PetHospital<Schnauzer> dogSchnauzer = new PetHospital <Schnauzer>("진찰된 강아지-->",1);
		 dogSchnauzer.add(new Schnauzer("Schnauzer"));
		 
		 
  //-----------------------------------------------------//
		 	
                  //NgDog 종류
		 PetHospital<NgDog> ngAll = new PetHospital<NgDog>("진찰 거절된 강아지 -->",2);
		 ngAll.add(new Chihuahua("Chihuahua"));  
		 ngAll.add(new poodle("poodle"));  
	
		 
		 
		 allDog(all);        //모든강아지
		 System.out.println("");
		 
		 permission(gAll);   //진찰 가능 강아지
		 System.out.println("");
		
		 System.out.println("\t ***진찰 완료 된 강아지*** ");
		 permission(dogCoca);
		 permission(dogBeagle);
		 permission(dogSchnauzer);
		 System.out.println();
		 
		 		 
		 rejectDog(ngAll);    //진찰 거절된 강아지
		 System.out.println("");
		
		 
		 
		 

	} //main

} //end class
