package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.Serializable;


public class ClassA 
	implements Serializable {
	
	int field1;						// ����ȭ�� ���Ե�
	
	ClassB field2 = new ClassB();	// ����ȭ�� ���Ե�
	
	static int field3;				// ����ȭ�� ���Ծȵ�***
	
	transient int field4;			// ����ȭ�� ���Ծȵ�***
	
	
} // end class
