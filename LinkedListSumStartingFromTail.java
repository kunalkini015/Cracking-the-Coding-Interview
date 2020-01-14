package crackingTheCodingInterview;

import java.util.*;

import crackingTheCodingInterview.LinkedListSum.Node;
public class LinkedListSumStartingFromTail {
	static class Node{
		int data;
		Node next;
		static HashMap<Node,Node> hm = new HashMap<>();
		Node(int d){
			data = d;
			next = null;
		}
		
		static void findPrevious(Node head) {
			Node curr = head,prev = null;
			while(curr != null) {
				hm.put(curr,prev);
				prev = curr;
				curr = curr.next;
			}
		}
		static Node getPrevious(Node head) {
			return hm.get(head);
		}
		static void printPrevious(Node head) {
			findPrevious(head);
			Node temp = head;
			while(temp != null) {
				if(getPrevious(temp) == null)
					System.out.println(temp.data +" "+null);
			else
				System.out.println(temp.data +" " + getPrevious(temp).data);
				
				temp = temp.next;
			}
		}
		
	}
	Node head = null;
	static void printList(Node head)
	{
		if(head == null)
			{
			System.out.println();
			return;
			}
		
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
	
	static Node sumTwoLists(Node head1,Node head2,Node answerHead) {
		Node.findPrevious(head1);
		
		Node.findPrevious(head2);
		while(head1.next != null) { 
			head1 = head1.next;
		}
		while(head2.next != null) {head2 = head2.next;}
		
		int carry=0, dig;
		while(head1 != null && head2 != null) {
			dig = (head1.data + head2.data) % 10;
			if(answerHead == null)
			{
				answerHead = new Node(dig+carry);
			}
			else {
				Node temp = new Node(dig+carry);
				temp.next = answerHead;
				answerHead = temp;
			}
			carry = (head1.data + head2.data) / 10;
			head1 = Node.getPrevious(head1);
			head2 = Node.getPrevious(head2);
		}
		while(head1 != null) {
			dig = (head1.data) % 10;
			if(answerHead == null)
			{
				answerHead = new Node(dig+carry);
			}
			else {
				Node temp = new Node(dig+carry);
				temp.next = answerHead;
				answerHead = temp;
			}
			carry = (head1.data) / 10;
			head1 = Node.getPrevious(head1);
		}
		while(head2 != null) {
			dig = (head2.data) % 10;
			if(answerHead == null)
			{
				answerHead = new Node(dig+carry);
			}
			else {
				Node temp = new Node(dig+carry);
				temp.next = answerHead;
				answerHead = temp;
			}
			carry = (head2.data) / 10;
			head2 = Node.getPrevious(head2);
		}
		
		
		// to handle the carry over the Most significant digit.
		if(carry == 1) {
			Node temp = new Node(carry);
			temp.next = answerHead;
			return temp;
		}
		return answerHead;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListSumStartingFromTail listOne = new LinkedListSumStartingFromTail();
		LinkedListSumStartingFromTail listTwo = new LinkedListSumStartingFromTail();
		
		listOne.head = listOne.insert(listOne.head, 7);
		listOne.head = listOne.insert(listOne.head, 1);
		listOne.head = listOne.insert(listOne.head, 6);
		
		
		listTwo.head = listTwo.insert(listTwo.head, 5);
		listTwo.head = listTwo.insert(listTwo.head, 9);
		listTwo.head = listTwo.insert(listTwo.head, 5);
		
		LinkedListSumStartingFromTail answer = new LinkedListSumStartingFromTail();
		
		printList(listOne.head);
		printList(listTwo.head);
		
		answer.head = sumTwoLists(listOne.head,listTwo.head,answer.head);
		
		printList(answer.head);

	}

}
