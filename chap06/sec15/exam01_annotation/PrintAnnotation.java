package sec15.exam01_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({
	ElementType.TYPE, 
	ElementType.FIELD, 
	ElementType.METHOD,
	ElementType.PARAMETER, 
	ElementType.CONSTRUCTOR, 
	ElementType.LOCAL_VARIABLE, 
	ElementType.ANNOTATION_TYPE, 
	ElementType.PACKAGE, 
	ElementType.TYPE_PARAMETER, 
	ElementType.TYPE_USE, 
})
@Retention(RetentionPolicy.RUNTIME)
@PrintAnnotation
public @interface PrintAnnotation {
	String value() default "-";
	int number() default 15;
	
} // end @interface










