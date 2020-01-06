package crackingTheCodingInterview;

import crackingTheCodingInterview.LinkedListDeleteDuplicates.Node;

public class LinkedList {

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
	
	static Node delete(Node head,int data)
	{
		if(head.data == data)
		{
			head = head.next;
			return head;
		}
		
		Node prev = null;
		Node curr = head;
		while(curr != null && curr.data != data)
		{
			prev = curr;
			curr = curr.next;
		}
		if(curr!=null)
		{
			prev.next = curr.next;
		}
		
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList li = new LinkedList();
		li.head = insert(li.head,10);
		li.head = insert(li.head,20);
		li.head = insert(li.head,30);
		li.head = insert(li.head,40);
		
		
		
		printList(li.head);
		System.out.println();
		
		li.head = delete(li.head,30);
		printList(li.head);
		System.out.println();
		
		

	}

}
