package crackingTheCodingInterview;
import java.util.Stack;
public class QueueUsingStacks {
	
	static class Queue{
		static Stack<Integer> stackOne = new Stack();
		static Stack<Integer> stackTwo = new Stack();
		
		// Making enque time complexity O(n)
		static void enqueueApproachOne(int data) {
			while(!stackOne.isEmpty())
				stackTwo.push(stackOne.pop());
			stackOne.push(data);
			
			while(!stackTwo.isEmpty())
				stackOne.push(stackTwo.pop());
		}
		
		static int dequeueApproachOne() {
			if(stackOne.isEmpty())
				{
				System.out.println("Stack is empty");
				return -1;
				}
			else return stackOne.pop();
			
		}
		
		static void enqueueApproachTwo(int data) {
			stackOne.push(data);
		}
		
		static int dequeueApproachTwo() {
			if(stackOne.isEmpty() && stackTwo.isEmpty())
			{
				System.out.println("Queue is empty");
				return -1;
			}
			else if(stackTwo.isEmpty()) {
				while(!stackOne.isEmpty())
					stackTwo.push(stackOne.pop());
				return stackTwo.pop();
			}
			else return stackTwo.pop();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue queue = new Queue();
		queue.enqueueApproachTwo(10);
		queue.enqueueApproachTwo(20);
		queue.enqueueApproachTwo(30);
		
		System.out.println(queue.dequeueApproachTwo());
		System.out.println(queue.dequeueApproachTwo());
		System.out.println(queue.dequeueApproachTwo());

	}

}
