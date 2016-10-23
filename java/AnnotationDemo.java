package org.ace;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Arrays;
// ����������Ԫע��
  @Inherited // �̳���
  @Documented //�ĵ���
  @Retention(RetentionPolicy.RUNTIME) // ������Χ RetentionPolicy ��ö�����͵�
  @Target(ElementType.TYPE) // ���÷�Χ  ElementType Ҳ��ö�����͵�
  @interface MyAnnotation{
    public String value();
	public String[] key();
     public String def() default "123";
  }

@MyAnnotation(value="jie",key={"1","2"})
public class AnnotationDemo {
	
	public static void main(String args[])throws Exception{ // �׳����е��쳣
           Class<?> c =null;
		   c=Class.forName("org.ace.AnnotationDemo"); // ��ȡ���ʵ��
		 MyAnnotation a = c.getAnnotation(MyAnnotation.class);  // �õ��ض���ע��
		       if(a!=null){
				   String st = a.def();
				   String str = a.value();
			       String[] str1 = a.key();				   
				   System.out.println(Arrays.toString(str1)+" "+str+" "+st);
			   }
	}
}