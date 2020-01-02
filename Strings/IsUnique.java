package crackingTheCodingInterview;
import java.util.HashSet;
public class IsUnique {
	// without using an additional data structure, time complexity O(n squared).
	static boolean isUniqueTwoForLoops(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<str.length();j++)
			{
				
				if(str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		return true;
	}
	// making use of an additional data structure, i.e. a hashset
	static boolean isUniqueWithHashSet(String str)
	{
		HashSet<Character> hs = new HashSet<>();
		for(int i=0;i<str.length();i++)
		{
			if(hs.contains(str.charAt(i)))
				return false;
			hs.add(str.charAt(i));

		}
		return true;
	}
	// making use of an additional array of length 26 to indicate characters from A-Z.
	public static boolean isUniqueWithArray(String str)
	{
		int charArray[] = new int[26];
		for(int i=0;i<str.length();i++)
		{
			if( charArray[str.charAt(i) - 'a'] == 1)
				return false;
			charArray[str.charAt(i)-'a'] = 1;
		}
		return true;
	}

	public static void main(String[] args) {
		
		String str = "kunal";
		System.out.println(isUniqueTwoForLoops(str));
		System.out.println(isUniqueWithHashSet(str));
		System.out.println(isUniqueWithArray(str));
	}

}
