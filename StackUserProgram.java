package com.jaggu.LinearProgrammingAlgorithm;

class Node2 {
	Object ele;
	Node2 next;
	
	public Node2(Object ele) {
		this.ele = ele;
	}
	public Node2(Object ele, Node2 next) {
		this.ele = ele;
		this.next = next;
	}
}

class Stack {
	Node2 first;
	int count  =0;
	
	public void push(Object ele) {
		if(first==null) {
			Node2 n = new Node2(ele);
			first = n;
			count++;
			return;
		}
		first = new Node2(ele,first);
		count++;
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return count ==0;
	}
	public Object peek() {
		if(isEmpty()) {
			System.out.println("No Element is added ");
			return null;
		}
		Object ele = first.ele;
		first = first.next;
//		count--;
		return ele;
	}
	
	public Object pop() {
		if(isEmpty()) {
			System.out.println("Element is not added");
			return null;		
		}
		Object ele = first.ele;
		first = first.next;
		count--;
		return ele;
	}
	
}

public class StackUserProgram {

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		
		System.out.println(s.size());
		System.out.println(s.isEmpty());
//		System.out.println(s.peek());
		System.out.println("Deleted items "+s.pop());
		System.out.println(s.size());
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
		System.out.println(s.isEmpty());
		
	}

}
