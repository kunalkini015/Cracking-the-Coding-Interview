package crackingTheCodingInterview;

/*
 * String Compression: Implement a method to perform basic string compression using the counts of repeated characters. 
 * For example, the string aabcccccaaa would become a2blc5a3. 
 * If the "compressed" string would not become smaller than the original string, your method should return the original string. 
 * You can assume the string has only uppercase and lowercase letters (a -z). 
 * 
 */
public class StringCompression {
	static String compressString(String str)
	{
		
		if(str.length() == 0)
			return str;
		StringBuilder sb = new StringBuilder();
		char currentChar = str.charAt(0); // initializing current character to space, because the string contains only a-z, A-Z.
		int currentCount = 1;
		sb.append(currentChar);
		for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i) != currentChar)
			{
				sb.append(Integer.toString(currentCount));
				currentChar = str.charAt(i);
				sb.append(Character.toString(currentChar));
				currentCount = 1;
			}
			else
			{
				currentCount++;
			}
		}
		sb.append(currentCount);
		
	String compressedString = new String(sb);
	return str.length()>compressedString.length()?compressedString:str; // To satisfy the condition that the compressed string should have lesser length.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaabcccccaa";
		System.out.println(compressString(str));

	}

}
