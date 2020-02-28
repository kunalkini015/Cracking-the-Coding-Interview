package crackingTheCodingInterview;
import java.util.Stack;
public class StackReverse {
	public static void display(Stack<Integer> stack) {
		while(!stack.isEmpty())
			System.out.print((Integer)stack.pop() + " ");
		System.out.println("Stack");
	}
	public static void insert_at_bottom(Stack<Integer> stack, int number)
	{
		if(stack.isEmpty())
			stack.push(number);
		else {
			int newNum = stack.pop();
			insert_at_bottom(stack, number);
			
			stack.push(newNum);
			
		}
	}
	public static void reverse(Stack<Integer> stack) {
		if(!stack.isEmpty())
		{
			int number = stack.pop();
			
			reverse(stack);
			insert_at_bottom(stack, number);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack();
		stack.push(10);
		stack.push(3);
		stack.push(20);
		display(stack);
		reverse(stack);
		//display(stack);
		

	}

}
