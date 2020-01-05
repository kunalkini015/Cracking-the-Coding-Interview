package crackingTheCodingInterview;

/*
 *  Given an image represented by an NxN matrix, 
 *  where each pixel in the image is 4 bytes,
 *  write a method to rotate the image by 90 degrees. 
 *  Can you do this in place? 
 */
public class RotateMatrix {
	static void printArray(int array[][])
	{
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array.length;j++)
			{
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void rotateArray(int array[][])
	{
		int n = array.length;
		for(int i=0;i<n/2;i++)
		{
			for(int j=i;j<n-1-i;j++)
			{
				int temp = array[i][j];
				array[i][j] = array[j][n-1-i];
				array[j][n-1-i] = array[n-1-i][n-1-j];
				array[n-1-i][n-1-j] = array[n-1-j][i];
				array[n-1-j][i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int array[][] = { 
	            {1, 2, 3, 4}, 
	            {5, 6, 7, 8}, 
	            {9, 10, 11, 12}, 
	            {13, 14, 15, 16} 
	        }; 
		System.out.println("Original Matrix");
		printArray(array);
		rotateArray(array);
		System.out.println("Rotated Matrix");
		printArray(array);
		
		
		// -------- output--------
				/*
				Original Matrix
				1 2 3 4 
				5 6 7 8 
				9 10 11 12 
				13 14 15 16 
				Rotated Matrix
				4 8 12 16 
				3 7 11 15 
				2 6 10 14 
				1 5 9 13
				*/
		//-----------------------

	}

}
