package crackingTheCodingInterview;

public class StringRotation {
	
	static boolean isRotation(String str,String rot)
	{
		if(str.length()!= rot.length()) return false;//if length differ, then strings can't be the rotation of one other
		int originalIndex = 0,rotationIndex=-1;
		for(int i=0;i<rot.length();i++)
		{
			if(rot.charAt(i) == str.charAt(0))
			{
				rotationIndex = i;
				break;
			}
		}
		if(rotationIndex == -1) return false; // if the rot doesn't contain the starting letter of original string
		int i=1,j=(rotationIndex+1) % rot.length() ;
		while(j != rotationIndex) {
			if(rot.charAt(j) != str.charAt(i))
				return false;
			i++;
			j = (j+1)%rot.length();
			if(j==rot.length())
				j=0;
		}
		return true;
	}
	// Text book solution using substring method
	static boolean isRotationBookSolution(String s1,String s2)
	{
		if(s1.length() == s2.length())
		{
			s1 = s1 + s1;
			return isSubstring(s1,s2);
		}
		return false;
	}
	
	static boolean isSubstring(String s1,String s2)
	{
		int originalIndex = 0,rotationIndex=-1;
		for(int i=0;i<s1.length();i++)
		{
			if(s1.charAt(i) == s2.charAt(0))
			{
				rotationIndex = i;
				break;
			}
		}
		if(rotationIndex == -1) return false;
		
		int i=1,j=rotationIndex+1;
		while(i < s2.length())
		{
			if(s1.charAt(j) != s2.charAt(i))
				return false;
			i++;
			j++;
			if(j == s1.length())
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "unalk";
		String  rotation = "kunal";
		System.out.println(isRotation(str,rotation));
		System.out.println(isRotationBookSolution(str,rotation));

	}

}
