package org.ace;
import java.math.*;
import java.util.*;
public class BigDecimalAndBigInteger{

	public static void main(String args[]){
           BigInteger bi=new BigInteger("123456789123456789");
		   BigInteger bi1=new BigInteger("987654321321456789");
		    System.out.println("�ӷ���"+bi1.add(bi));
            System.out.println("�˷���"+bi1.multiply(bi));   
            System.out.println("������"+bi1.subtract(bi));
		    System.out.println("������"+bi1.divide(bi));
            System.out.println("������"+Arrays.toString(bi1.divideAndRemainder(bi))); 
	       
			MathContext mc = new MathContext(2);                               
           	BigDecimal bd =new BigDecimal("45.365",mc);
			BigDecimal b =new BigDecimal("63.12345",mc);
			
			 System.out.println("�ӷ���"+b.add(bd));
            System.out.println("�˷���"+b.multiply(bd));   
            System.out.println("������"+b.subtract(bd));
		    System.out.println("������"+b.divide(bd));
	}
}