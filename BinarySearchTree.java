package com.jaggu.NonLinearProgrammingAlgorithm;

import java.util.ArrayDeque;
import java.util.Queue;

class Node {
	int key;
	Node left;
	Node right;
	public Node (int key) {
		this.key = key;
	}
	
	public Node(int key, Node left, Node right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}	
}

public class BinarySearchTree {
	
	Node root;
	boolean flag;
	int count = 0;
	public int size() {
		return count;
	}
	public boolean isEmpty() {
		return count==0;
	}
	public boolean add(int ele) {
		root = add(root,ele);
		return flag;
	}
	public void add(int a[]) {
		for(int i=0;i<a.length;i++) {
			add(a[i]);
		}
	}
	public Node add(Node n,int ele ) {
		if(n==null) {
			n=new Node(ele);
			count++;
			return n;
		}
		if(ele<n.key) {
			n.left = add(n.left,ele);
		}
		else if(ele>n.key) {
			n.right = add(n.right,ele);
		}else {
			flag = false;
		}
		return n;
	}
	
	public void levelOrderTravarsal() {
		Queue q = new ArrayDeque(); //collection framwork, Queue is a interface
		q.add(root);
		while(!q.isEmpty()) {
			Node n = (Node)q.poll();
			System.out.print(n.key+" ");
			if(n.left!=null) {
				q.add(n.left);
			}
			if(n.right!=null) {
				q.add(n.right);
			}
		}
	}
	
	public void preOrder(Node n) {
		if(n==null) {
			return ;
		}
		System.out.print(n.key+" ");
		preOrder(n.left);
		preOrder(n.right);
	}
	
	public void inOrder(Node n) {
		if(n==null) {
			return ;
		}
		inOrder(n.left);
		System.out.print(n.key+" ");
		inOrder(n.right);
	}
	
	public void postOrder(Node n) {
		if(n==null) return;
		postOrder(n.left);
		postOrder(n.right);
		System.out.print(n.key+" ");
	}
	
	public void display() {
		//preOrder(root);
		//postOrder(root);
		inOrder(root);
		//levelOrderTravarsal();
	}
	
	public void atractivedisplay(Node n,int level) {
		if(n==null) return;
		
		atractivedisplay(n.right, level+1);
		if(level!=0) {
			for(int i=0;i<level-1;i++) {
				System.out.print("|\t");
			}
			
			System.out.println("|---------------> " +n.key);
		}
		else {
			System.out.println(n.key);
		}
		atractivedisplay(n.left, level+1);
	}
	
	public void remove(int key) {
		remove(root,key);
	}
	
	public Node remove(Node n ,int key) {
		if(n==null) return null;
		if(key<n.key) {
			n.left = remove(n.left,key);
		} else if (key>n.key) {
			n.right = remove(n.right,key);
		} else {
			if(n.left==null) {
				return n.right;
			} else if (n.right==null) {
				return n.left;
			}
			n.key = minValue(n.right);
			n.right = remove(n.right,n.key);
		}
		return n;
	}
	
	public int minValue(Node n) {
		int min = n.key;
		while(n.left != null) {
			min = n.left.key;
			n = n.left;
		}
		return min;
		
	}

	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();
		int []a = {40,25,31,75,96,12,32,15,19,41,76};
		b.add(a);
		b.remove(30);
		b.remove(31);
		b.display();
		//b.atractivedisplay(b.root, 0);
		//b.levelOrderTravarsal();
		
	}

}
