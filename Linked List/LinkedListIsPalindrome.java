package crackingTheCodingInterview;


import java.util.*;
public class LinkedListIsPalindrome {
	static class Node{
		int data;
		Node next;
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	static class Result{
		Node node;
		boolean result;
		Result(Node node, boolean value){
			this.node = node;
			this.result = value;
		}
	}
		Node head = null;
		
		static Node insert(Node head, int data) {
			if(head == null) {
				head = new Node(data);
				return head;
			}
			else {
				Node temp = head;
				while(temp.next != null) {
					temp = temp.next;
				}
				temp.next = new Node(data);
				return head;
			}
		}
		
		static void printList(Node head) {
			Node temp = head;
			while(temp!=null) {
				System.out.print(temp.data);
				temp = temp.next;
			}
			System.out.println();
		}
		static Node findMiddleNode(Node head) {
			Node p1 = head, p2=head;
			while(p2.next != null && p2.next.next != null) {
				p1 = p1.next;
				p2 = p2.next.next;
			}
			return p1;
		}
		static int findListLength(Node head) {
			int length = 0;
			Node temp = head;
			while( temp != null ) {
				length++;
				temp = temp.next;
			}
			return length;
		}
		static Result isPalindromeRecursive(Node head, int length) {
			if(head == null || length <=0)
				return new Result(head, true);
			else if(length == 1)
				return new Result(head.next, true);
			Result res = isPalindromeRecursive(head.next, length-2);
			
			if( !res.result || res.node == null)
				return res;
			res.result = (head.data == res.node.data);
			res.node = res.node.next;
			
			return res;
		}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListIsPalindrome li = new LinkedListIsPalindrome();
		
		li.head = li.insert(li.head, 1);
		li.head = li.insert(li.head, 2);
		li.head = li.insert(li.head, 3);
		li.head = li.insert(li.head, 4);
		li.head = li.insert(li.head, 2);
		li.head = li.insert(li.head, 1);
		int length = findListLength(li.head);
		System.out.println(isPalindromeRecursive(li.head, length).result);

	}

}
