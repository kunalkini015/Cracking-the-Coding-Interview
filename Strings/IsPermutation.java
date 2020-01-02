package crackingTheCodingInterview;

public class IsPermutation {
	static boolean isPermutationArray(String str1,String str2)
	{
		if(str1.length()!= str2.length()) return false;
		int charArray[] = new int[26];
		int sum = 0;
		for(int i=0;i<str1.length();i++)
		{
			charArray[str1.charAt(i)-'a']+=1;
		}
		for(int i=0;i<str2.length();i++)
		{
			charArray[str2.charAt(i)-'a']-=1;
		}
		
		for(int i=0;i<26;i++)
			if(charArray[i] != 0) return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "kunah";
		String str2 = "lanuk";
		System.out.println(isPermutationArray(str1,str2));

	}

}
