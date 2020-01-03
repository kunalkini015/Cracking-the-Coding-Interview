package crackingTheCodingInterview;

/*
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. 
 * Given two strings, write a function to check if they are one edit (or zero edits) away. 
 * EXAMPLE 
 * pale, ple -> true 
 * pales, pale -> true
 */

import java.util.*;
public class OneAway {
	
	static boolean isOneAway(String str1,String str2)
	{
		HashMap<Character,Integer> hm = new HashMap<>();
		for(int i=0;i<str1.length();i++)
		{
			if(hm.containsKey(str1.charAt(i))) 
				hm.put(str1.charAt(i), hm.get(str1.charAt(i))+1);
			else
				hm.put(str1.charAt(i), 1);
		}
		int distCount = 0;
		for(int i=0;i<str2.length();i++)
		{
			if(!(hm.containsKey(str2.charAt(i))))
				distCount++;
			else if(hm.get(str2.charAt(i)) == 0)
				distCount++;
			else
				hm.put(str2.charAt(i), hm.get(str2.charAt(i))-1);
		}
		
		// Iterating through HashMap
		for(Map.Entry<Character,Integer> entry:hm.entrySet())
		{
			distCount+= (int)entry.getValue();
		}
		
		
		return distCount == 1 || distCount == 0; // one edit or zero edit
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "pale";
		String str2 = "pal";
		if(str1.length() < str2.length()) // This swapping will make highest length string to be str1
		{
			String temp =str1;str1=str2;str2=temp;
		}
		System.out.println(isOneAway(str1,str2));
		

	}

}
