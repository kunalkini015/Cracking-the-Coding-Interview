package crackingTheCodingInterview;

import crackingTheCodingInterview.LinkedList.Node;

public class LinkedListKthFromLast {

	static class Node{
		int data;
		Node next;
		Node(int d)
		{
			this.data =d;
			this.next = null;
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
	static void printKthFromLast(Node head,int k) {
		
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		Node p1 = head,p2 = head;
		while(k-- > 0) {
			p1 = p1.next;
			if(p1 == null && k != 0) {
				System.out.println("Please choose k lesser than the length of the list");
				return;
			}
		}
		while(p1 != null)
		{
			p1 = p1.next;
			p2 = p2.next;
		}
		System.out.println("Kth Node from the tail is "+p2.data);
		
			
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListKthFromLast li = new LinkedListKthFromLast();
		li.head = li.insert(li.head, 10);
		li.head =li.insert(li.head, 20);
		li.head =li.insert(li.head, 30);
		li.head =li.insert(li.head, 40);
		li.head =li.insert(li.head, 50);
		li.head =li.insert(li.head, 60);
		li.head =li.insert(li.head, 70);
		printList(li.head);
		System.out.println();
		printKthFromLast(li.head,8);
		

	}

}
