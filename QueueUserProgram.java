package com.jaggu.LinearProgrammingAlgorithm;

class Node3 {
	Object ele;
	Node3 next;
	public Node3 (Object ele) {
		this.ele = ele;
	}
	public Node3(Object ele, Node3 next) {
		this.ele = ele;
		this.next = next;
	}
	
}

class Queue {
	Node head;
	Node tail;
	int count = 0;
	
	public void add(Object ele) {
		Node node = new Node(ele);
		if(head==null) {
			head = node;
			tail = head;
			count++;
			return;
		}
		tail.next = node;
		tail = tail.next;
		count++;
	}
	public int size() {
		return count;
	}
	public boolean isEmpty() {
		return count==0;
	}
	public Object peek() {
		if(isEmpty()) {
			System.out.println("Element is Not Found ");
			return null;
		}
		return head.ele;
	}
	public Object poll() {
		if(isEmpty()) {
			System.out.println("Element is Not Found ");
			return null;
		}
		Object ele = head.ele;
		head = head.next;
		count--;
		return ele;
	}
}

public class QueueUserProgram {

	public static void main(String[] args) {
		Queue q = new Queue();
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		
		System.out.println(q.size());
		System.out.println(q.peek());
		System.out.println(q.isEmpty());
		System.out.println(q.size());
		System.out.println(q.poll());
		System.out.println(q.size());
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		System.out.println(q.isEmpty());
	}

}
