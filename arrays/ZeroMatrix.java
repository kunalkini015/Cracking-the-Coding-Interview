package crackingTheCodingInterview;

/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0. 
 */

public class ZeroMatrix {
	
	
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
	static void setToZeros(int array[][],int n,int row,int column)
	{
		for(int i=0;i<n;i++)
		{
			array[i][column] = 0;
			array[row][i] = 0;
		}
	}
	static void zeroMatrix(int array[][],int n)
	{
		boolean flag[][] = new boolean[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(array[i][j] == 0 && !(flag[i][j]))
				{
					flag[i][j] = true;
					setToZeros(array,n,i,j);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[][] = {
				{1,2,3},
				{4,5,6},
				{7,8,0}
				};
		System.out.println("Original Array");
		printArray(array);
		System.out.println("Array After Conversion");
		zeroMatrix(array,array.length);
		printArray(array);
		
		
		// -------- output -------
		/*
		Original Array
		1 2 3 
		4 5 6 
		7 8 0 
		Array After Conversion
		1 2 0 
		4 5 0 
		0 0 0 
		*/
		

	}

}
