package crackingTheCodingInterview;

import java.util.*;
public class LinkedListDeleteDuplicates {
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
	
	static void removeDuplicatesWithExtraBuffer(Node head)
	{
		HashSet<Integer> hs = new HashSet<>();
		Node curr = head,prev = null;
		while(curr != null)
		{
			if(hs.contains(curr.data))
			{
				prev.next = curr.next;
			}
			else {
			hs.add(curr.data);
			prev = curr;
			
			}
			curr = curr.next;
		}
	}
	static void removeDuplicatesWithoutExtraBuffer(Node head)
	{
		Node p1 = head,p2;
		while(p1!=null)
		{
			p2 = p1;
			while(p2!=null)
			{
				if(p2.next!=null && p2.next.data == p1.data)
				{
					p2.next = p2.next.next;
				}
				else
				p2 = p2.next;
			}
			
			p1 = p1.next;
		}
	}
	static void printList(Node head)
	{
		Node temp = head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListDeleteDuplicates li = new LinkedListDeleteDuplicates();
		li.head = new Node(1);
		li.head.next = new Node(2);
		li.head.next.next = new Node(1);
		li.head.next.next.next = new Node(2);
		li.head.next.next.next.next = new Node(3);
		printList(li.head);
		removeDuplicatesWithoutExtraBuffer(li.head);
		printList(li.head);
		
		

	}

}
