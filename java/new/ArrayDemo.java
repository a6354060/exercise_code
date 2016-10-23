package org.ace;
import java.util.*;
public class ArrayDemo{
	public static void main(String args[]){
		int[] temp ={1,8,5,45,6,7,8,51,32};
          Arrays.sort(temp);
          System.out.println("≈≈–Ú∫Û"+Arrays.toString(temp));
         int a=Arrays.binarySearch(temp,4,9,51);
          Arrays.fill(temp,3,7,4);
		 System.out.println(Arrays.toString(temp));
		 int[] newArray=Arrays.copyOf(temp,15);
         System.out.println(Arrays.toString(newArray));
		 int[] n=Arrays.copyOfRange(temp,3,7);
		 System.out.println(Arrays.toString(n));
          System.out.println(Arrays.equals(n,n));

	}
}