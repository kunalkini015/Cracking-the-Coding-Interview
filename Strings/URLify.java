package crackingTheCodingInterview;

/*
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: If implementing in Java, please use a character array so that you can perform this operation in place.) 
 * EXAMPLE 
 * Input: "Mr John Smith"
 * Output: "Mr%20John%20Smith" 
 */
public class URLify {
	static String urlify(String str)
	{
		char ch[] = new char[50];
		int i=0,j=0;
		for(i=0,j=0;i<str.length() && j < ch.length;i++,j++)
		{
			if(str.charAt(i) != ' ')
				ch[j] = str.charAt(i);
			else
			{
				ch[j] = '%';
				ch[j+1] = '2';
				ch[j+2] = '0';
				j = j+2;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(i=0;i<j;i++)
			sb.append(ch[i]);
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Mr John Smith";
		System.out.println(urlify(str));
		
		// Output :
		// Mr%20John%20Smith

	}

}
