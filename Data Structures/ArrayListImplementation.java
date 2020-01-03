package crackingTheCodingInterview;

public class ArrayListImplementation {
	int array[] = new int[5]; // initial array with the capacity of 5
	int index = 0;
	void add(int element)
	{
		if(this.index == this.array.length)
			array = extendSizeOfTheArray();
		this.array[this.index] = element;
		this.index++;
		
	}
	int get(int index) {
		try {
			return array[index];
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
	int size()
	{
		return this.index;
	}
	int[] extendSizeOfTheArray()
	{
		int []newArray = new int[(array.length)*2];
		for(int i=0;i<array.length;i++)
			newArray[i] = array[i];
		return newArray;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListImplementation arl = new ArrayListImplementation();
		System.out.println(arl.size());
		arl.add(10);
		arl.add(20);
		arl.add(30);
		arl.add(10);
		arl.add(20);
		arl.add(30);
		System.out.println(arl.size());
		System.out.println(arl.get(2));
		
		System.out.println(arl.get(100));

	}

}
