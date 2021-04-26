package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.Serializable;


public class ClassA 
	implements Serializable {
	
	int field1;						// 직렬화에 포함됨
	
	ClassB field2 = new ClassB();	// 직렬화에 포함됨
	
	static int field3;				// 직렬화에 포함안됨***
	
	transient int field4;			// 직렬화에 포함안됨***
	
	
} // end class
