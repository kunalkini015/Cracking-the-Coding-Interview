package crackingTheCodingInterview;

import crackingTheCodingInterview.LinkedListSum.Node;

public class LinkedListFindLoop {
	static class Node{
		int data;
		Node next;
		Node(int d)
		{
			this.data =d;
			this.next = null;
		}
	}
	
	static class Result{
		Node loopNode;
		boolean isLoop;
		Result(Node node, boolean value)
		{
			loopNode = node;
			isLoop = value;
		}
	}
	Node head = null;
	static void printList(Node head)
	{
		if(head == null)
			return;
		System.out.print(head.data+" ");
		printList(head.next);
	}
	
	static Node insert(Node head,int data)
	{
		if(head == null)
		{
			head = new Node(data);
			return head;
		}
		Node temp = head;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		temp.next = new Node(data);
		return head;	
	}
	static Result detectLoop(Node head) {
		Node slow = head, fast=head;
		while(fast != null && slow != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast)
				break;
		}
		if(fast == null || fast.next == null)
			return new Result(null, false);
		slow = head;
		while( slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		return new Result(fast, true);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListFindLoop li = new LinkedListFindLoop();
		li.head = li.insert(li.head, 10);
		li.head = li.insert(li.head, 20);
		li.head = li.insert(li.head, 30);
		li.head = li.insert(li.head, 40);
		li.head = li.insert(li.head, 50);
		Node temp = li.head;
		while(temp.next != null)
			temp = temp.next;
		temp.next = li.head.next;
		
		System.out.println(detectLoop(li.head).loopNode.data);
		

	}

}
