package crackingTheCodingInterview;

public class QueueImplementation {
	static class QueueNode{
		int data;
		QueueNode next;
		QueueNode(int d){
			this.data = d;
			this.next = null;
		}
	}
	QueueNode rear = null, front = null;
	void enqueue(int element) {
		if(rear == null) {
			rear = new QueueNode(element);
			front = rear;
			return;
		}
		rear.next = new QueueNode(element);
		rear = rear.next;
	}
	int dequeue() {
		if(front == null) {
			System.out.println("The Queue is empty");
			return Integer.MIN_VALUE;
		}
		int element = front.data;
		front = front.next;
		return element;
	}
	
	
	int peek() {
		if(rear == null)
			return Integer.MIN_VALUE;
		return rear.data;
	}
	
	void display() {
		if(front == null) {
			System.out.println("Queue is empty");
			return;
		}
		QueueNode temp = front;
		while(temp != rear) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println(rear.data);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueImplementation queue = new QueueImplementation();
		queue.enqueue(10);
		queue.display();
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.display();
		queue.dequeue();
		queue.display();
		queue.dequeue();
		queue.display();
		
	}

}
