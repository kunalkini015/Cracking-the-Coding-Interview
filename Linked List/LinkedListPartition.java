package crackingTheCodingInterview;

import crackingTheCodingInterview.LinkedListKthFromLast.Node;

public class LinkedListPartition {

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
	
	static Node partition(Node head,int value)
	{
		Node lesserStart = null,lesserEnd = null, higherStart = null,higherEnd = null;
		while(head != null)
		{
			if(head.data < value) {
				if(lesserStart == null)
				{
					lesserStart = head;
					lesserEnd = head;
				}
				else {
					lesserEnd.next = head;
					lesserEnd = head;
				}
			}
			else {
				if(higherStart == null)
				{
					higherStart = head;
					higherEnd = head;
				}
				else {
					higherEnd.next = head;
					higherEnd = head;
				}
			}
			head = head.next;
		}
		if(lesserStart == null)
			return higherStart;
		lesserEnd.next = higherStart;
		return lesserStart;
	}
	
	static Node partitionWithTwoLists(Node head,int value) {
		Node temp=head,lesserNode = null,higherNode = null;
		while(temp != null) {
			if(temp.data < value) {
				lesserNode = insert(lesserNode,temp.data);
			}
			else {
				higherNode = insert(higherNode,temp.data);
			}
			temp =temp.next;
		}
		temp = lesserNode;
		while(temp.next != null)
			temp = temp.next;
		temp.next = higherNode;
		return lesserNode;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListPartition li = new LinkedListPartition();
		li.head = li.insert(li.head, 3);
		li.head = li.insert(li.head, 5);
		li.head = li.insert(li.head, 8);
		li.head = li.insert(li.head, 5);
		li.head = li.insert(li.head, 10);
		li.head = li.insert(li.head, 2);
		li.head = li.insert(li.head, 1);
		printList(li.head);
//		li.head = partitionWithTwoLists(li.head,5);
//		System.out.println();
//		printList(li.head);
		li.head = partition(li.head,5);
		System.out.println();
		printList(li.head);
		System.out.println();
	}

}
