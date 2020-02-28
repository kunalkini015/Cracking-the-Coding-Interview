package crackingTheCodingInterview;

/*
 * Stack Min: How would you design a stack which, 
 * in addition to push and pop, has a function min which returns the minimum element? 
 * Push, pop and min should all operate in 0(1) time. 
 */
public class StackImplementationLinkedList {
	
	static class Node{
		int data, min;
		Node next;
		Node(int data, int min){
			this.data = data;
			this.next = null;
			this.min = Math.min(this.data, min);
		}
	}
	static Node top = null;
	static Node bottom = null;
	
	
	static void push(int data) {
		if(bottom == null)
		{
			top = new Node(data, data);
			bottom = top;
		}
		else {
			top.next = new Node(data, top.data);
			top = top.next;
		}
		
	}
	
	static void display() {
		Node temp =bottom;
		while(temp != top)
			{
			System.out.println(temp.data+ " " + temp.min);
			temp = temp.next;
			}
		
		System.out.println(top.data+" "+top.min);
	}
	
	static int pop() {
		Node temp = bottom;
		while(temp.next.next != null) temp = temp.next;
		int poppedItem = temp.next.data;
		temp.next = null;
		top = temp;
		return poppedItem;
	
	}
	
	static int min() {
		return top.min;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackImplementationLinkedList stack = new StackImplementationLinkedList();
		stack.push(10);
		stack.push(3);
		stack.push(30);
		stack.push(2);
		stack.push(10);
		
		stack.display();
		
		System.out.println(stack.min());
		System.out.println(stack.pop());
		
		
		System.out.println(stack.min());
		System.out.println(stack.pop());
		
		
		

	}

}
