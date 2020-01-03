package crackingTheCodingInterview;
/*  Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 *  A palindrome is a word or phrase that is the same forwards and backwards.
 *  A permutation is a rearrangement of letters.
 *  The palindrome does not need to be limited to just dictionary words.
 *  EXAMPLE 
 *  Input: Tact Coa 
 *  Output: True 
 */




public class PalindromePermutation {
	static int length = 0;// length is used to find the number of valid characters in the string, i.e. between a-z
	static int[] getCounts(String str) // getcounts method is used to get the count of occurence of each character a-z, while ignoring other chars.
	{
		int charArray[] = new int[26];
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i) >= 97 && str.charAt(i) <= 122)
				{
				charArray[str.charAt(i) - 'a']++;
				length++;
				}
		}
		return charArray;
	}
	
	static String getAnswer(int []array,boolean isOdd) // getAnswer method is used get the final answer based on the length of valid characters.
	{
		boolean isPalindrome = true;
		if(isOdd)
		{
			boolean onlyOne = false;
			for(int i=0;i<array.length;i++)
			{
				if(array[i] % 2 == 1)
				{
					if(onlyOne == false)
						onlyOne = true;
					else
					{
						isPalindrome = false;
						break;
					}
				}	
			}
		}
		else
		{
			for(int i=0;i<array.length;i++)
			{
				if(array[i] % 2 == 1)
				{
					isPalindrome = false;
					break;
				}
			}
		}

		return Boolean.toString(isPalindrome);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Tact Coa";
		int array[] = getCounts(str.toLowerCase());
		if(length % 2 == 0)// string length is even
		{
			System.out.println(getAnswer(array,false));
		}
		else // string length is odd
		{
			System.out.println(getAnswer(array,true));	
		}
		
		
		
		
		
		

	}

}
