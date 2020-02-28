package crackingTheCodingInterview;

public class StackImplementation {
	int top=-1, stack_size = 10, min = Integer.MAX_VALUE;
	int []stack = new int[stack_size];
	
	void push(int element) {
		this.stack[++top] = element;
		if(element <min) min = element;
	}
	int pop() {
		return this.stack[top--];
	}
	int peek() {
		return this.stack[top];
	}
	void display() {
		for(int i=top;i>=0;i--)
			System.out.print(this.stack[i]+" ");
		System.out.println();
	}
	int min() {
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackImplementation stack = new StackImplementation();
		stack.push(1);
		stack.display();
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.display();
		stack.pop();
		stack.display();
		stack.peek();
		
		stack.pop();
		stack.display();
		
	}

}
