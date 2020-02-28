package crackingTheCodingInterview;

public class Heap {
	int numbers[];
	int currentSize;
	int capacity;
	Heap(int cap){
		this.capacity = cap;
		this.numbers = new int[cap];
		this.currentSize = 0;
	}
	
	void insert(int num) {
		if(currentSize == capacity) {
			System.out.println("Heap is full");
			return;
		}
		int index = currentSize;
		numbers[index] = num;
		bubbleUp(index);
		currentSize++;

	}
	void bubbleUp(int index) {
		int currentIndex= index;
		int parentIndex = (index-1)/2;
		while(currentIndex>0 && numbers[currentIndex] < numbers[parentIndex]) {
			swap(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = (parentIndex-1)/2;
		}
		
	}
	void swap(int firstIndex, int secondIndex) {
		int temp = numbers[firstIndex];
		numbers[firstIndex] = numbers[secondIndex];
		numbers[secondIndex] = temp;
	}
	void display() {
		for(int i=0;i<currentSize;i++)
			System.out.print(numbers[i]+" ");
		System.out.println();
	}
	
	int extractMin() {
		int minimum = numbers[0];
		numbers[0] = numbers[currentSize-1];
		numbers[currentSize] = 0;
		sinkDown(0);
		currentSize--;
		return minimum;
	}
	void sinkDown(int index) {
		int smallest = index;
		int leftChild = 2 * smallest + 1;
		int rightChild = 2 * smallest + 2;
		
		if(leftChild < currentSize && numbers[leftChild] < numbers[smallest])
			smallest = leftChild;
		if(rightChild < currentSize && numbers[rightChild] < numbers[smallest])
			smallest = rightChild;
		
		if(smallest != index) {
			swap(smallest, index);
			sinkDown(smallest);
		}
		
		
	}

	public static void main(String[] args) {
		Heap minHeap = new Heap(10);
		int arrA [] = {3,2,1,7,8,4,10,16,12};
		
		for(int i=0;i<arrA.length;i++)
			minHeap.insert(arrA[i]);
		minHeap.display();
		System.out.println("Minimum Element"+minHeap.extractMin());
		minHeap.display();


		
		
		

	}

}
