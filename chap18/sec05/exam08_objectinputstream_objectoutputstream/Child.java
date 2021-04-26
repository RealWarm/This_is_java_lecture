package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Child 
	extends Parent 
	implements Serializable {
	
	public String field2;
	
	
	private void writeObject(ObjectOutputStream out) 
		throws IOException {
		System.out.println(
				"- Child::writeObject(out) invoked");
		
	   out.writeUTF(field1);
	   
	   out.defaultWriteObject();	/*******/
	} // writeObject

	private void readObject(ObjectInputStream in) 
		throws IOException, ClassNotFoundException {
		System.out.println(
				"- Child::readObject(in) invoked");
		
	   field1 = in.readUTF();
	   
	   in.defaultReadObject();	/*******/
	} // readObject
	
} // end class
