package org.ace;
 import java.util.regex.*;
 import java.util.Arrays;
 public class MatcherDemo{
	 public static void main(String args[]){
           String str ="20151228";
		   String regex="[0-9]+";
	       Pattern p =Pattern.compile(regex);
		   Matcher m =p.matcher(str);
		   System.out.println(str.matches(regex));
		   System.out.println(str.replaceAll(regex,"-"));
	           
	 }
 }