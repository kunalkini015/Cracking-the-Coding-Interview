package crackingTheCodingInterview;

import crackingTheCodingInterview.LinkedListPartition.Node;

public class LinkedListSum {
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
	static Node sumTwoLists(Node headOne,Node headTwo, Node answerHead) {
		int digit,carry = 0;
		Node answerNode = null;
		while(headOne != null && headTwo != null) {
			
			digit = (headOne.data + headTwo.data) % 10;
			if(answerHead == null)
			{
				answerHead = new Node(digit + carry);
				answerNode = answerHead;
				
			}
			else {
				answerNode.next = new Node(digit+carry);
				answerNode = answerNode.next;
			}
			
			carry = (headOne.data + headTwo.data) / 10;
			headOne = headOne.next;
			headTwo = headTwo.next;
			
		}
		while(headOne != null) {
			digit = (headOne.data) % 10;
			if(answerHead == null)
			{
				answerHead = new Node(digit + carry);
				answerNode = answerHead;
				
			}
			else {
				answerNode.next = new Node(digit+carry);
				answerNode = answerNode.next;
			}
			carry = headOne.data / 10;
			headOne = headOne.next;
		}
		while(headTwo != null) {
			digit = (headTwo.data) % 10;
			if(answerHead == null)
			{
				answerHead = new Node(digit + carry);
				answerNode = answerHead;
				
			}
			else {
				answerNode.next = new Node(digit+carry);
				answerNode = answerNode.next;
			}
			carry = headTwo.data / 10;
			headTwo = headTwo.next;
		}
		if(carry == 1)
		{
			answerNode.next = new Node(1);
		}
		
		
		return answerHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListSum listOne = new LinkedListSum();
		LinkedListSum listTwo = new LinkedListSum();
		
		listOne.head = listOne.insert(listOne.head, 7);
		listOne.head = listOne.insert(listOne.head, 1);
		listOne.head = listOne.insert(listOne.head, 6);
		listOne.head = listOne.insert(listOne.head, 2);
		
		listTwo.head = listTwo.insert(listTwo.head, 5);
		listTwo.head = listTwo.insert(listTwo.head, 9);
		listTwo.head = listTwo.insert(listTwo.head, 5);
		
		LinkedListSum answer = new LinkedListSum();
		printList(listOne.head);
		System.out.println();
		printList(listTwo.head);
		System.out.println();
		answer.head = sumTwoLists(listOne.head,listTwo.head,answer.head);
		printList(answer.head);
		
		
		
		

	}

}
