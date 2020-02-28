package crackingTheCodingInterview;

import java.util.*;
public class Tree {
	static class Node{
		int data;
		Node left, right;
		Node(int d){
			data=d;
			left=right=null;
		}
	}
	
	static Node root = null;
	
	static void insert(int d) {
		root = insert_utility(root, d);
	}
	static Node insert_utility(Node root, int data) {
		if(root == null) {
			root = new Node(data);
			return root;
		}
		else if(data > root.data)
			root.right = insert_utility(root.right, data);
		else if(data < root.data)
			root.left = insert_utility(root.left, data);
		
		return root;
	}
	
	static void inorder(Node root) {
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.data+"\t");
		inorder(root.right);
	}
	
	static void inorderWithoutRecursion(Node root) {
		Stack<Node> treeStack = new Stack();
		Node current = root;
		while(root != null) {
			while(current != null) {
				treeStack.push(current);
				current = current.left;
			}
			if(!treeStack.isEmpty())
			{
				Node poppedElement = treeStack.pop();
			
			System.out.print(poppedElement.data+"\t");
			current = poppedElement.right;
			}
			else break;
		}
	}
	
	static void preorder(Node root) {
		if(root!=null) {
			System.out.print(root.data+"\t");
			preorder(root.left);
			preorder(root.right);
		}
	}
	static void preorderWithoutRecursion(Node root) {
		Stack<Node> preOrderStack = new Stack<>();
		preOrderStack.push(root);
		while(!preOrderStack.isEmpty()) {
			root = preOrderStack.pop();
			System.out.print(root.data+"\t");
			if(root.right!=null)
			preOrderStack.push(root.right);
			if(root.left!=null)
			preOrderStack.push(root.left);
		}
		
	}

	
	
	static void postorder(Node root) {
		if(root!=null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+"\t");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = new Tree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
//		System.out.println("In Order");
//		inorder(tree.root);
//		System.out.println();
//		inorderWithoutRecursion(tree.root);
//		System.out.println();
//		System.out.println("Pre Order");
//		preorder(tree.root);
//		System.out.println();
//		preorderWithoutRecursion(tree.root);
//		System.out.println();
//		System.out.println("Post Order");
//		postorder(tree.root);

	}

}
