package org.ace;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.Arrays;
// 下面四种是元注解
  @Inherited // 继承性
  @Documented //文档性
  @Retention(RetentionPolicy.RUNTIME) // 保留范围 RetentionPolicy 是枚举类型的
  @Target(ElementType.TYPE) // 作用范围  ElementType 也是枚举类型的
  @interface MyAnnotation{
    public String value();
	public String[] key();
     public String def() default "123";
  }

@MyAnnotation(value="jie",key={"1","2"})
public class AnnotationDemo {
	
	public static void main(String args[])throws Exception{ // 抛出所有的异常
           Class<?> c =null;
		   c=Class.forName("org.ace.AnnotationDemo"); // 获取类的实例
		 MyAnnotation a = c.getAnnotation(MyAnnotation.class);  // 得到特定的注解
		       if(a!=null){
				   String st = a.def();
				   String str = a.value();
			       String[] str1 = a.key();				   
				   System.out.println(Arrays.toString(str1)+" "+str+" "+st);
			   }
	}
}
