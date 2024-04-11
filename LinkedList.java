package com.jaggu.LinearProgrammingAlgorithm;

class Node {
	Object ele;
	Node next;
	
	public Node(Object ele) {
		this.ele = ele;
	}
	public Node(Object obj, Node next) {
		super();
		this.ele = obj;
		this.next = next;
	}	
}

/*
class Test {
	public static void main(String[] args) {
		Node node =new Node(10,null);
		Node head =node;
		head.next = new Node(20,null);
		head.next.next = new Node(30,null);
		head.next.next.next = new Node(40,null);
		
		Node curr = head;
		while(curr!=null) {
			System.out.println(curr.ele);
			curr = curr.next;
		}
	}
}
*/

class LinkedListImplements {
	private Node head = null;
	private int count=0;
	
	public void add(Object e) {
		if(head==null) {
			head = new Node(e);
			count++;
			return;
		}
		Node curr = head;
		while(curr.next!=null) {
			curr = curr.next;
		}
		curr.next = new Node(e);
		count++;
	}
	
	public int size() {
		return count;
	}
	
	public void add(int index,Object e) {
		if(index<=-1 || index>=size()) throw new IndexOutOfBoundsException();
		if(index==0) {
			head = new Node(e,head);
			count++;
			return;
		}
		Node curr = head;
		for(int i=1;i<index;i++) {
			curr = curr.next;
		}
		curr.next = new Node(e,curr.next);
		count++;
	}
	public Object get(int index) {
		if(index<=-1||index>=size()) throw new IndexOutOfBoundsException();
		Node curr = head;
		for(int i=1;i<=index;i++) {
			curr = curr.next;
		}
		return curr.ele;
	}
	public void remove(int index) {
		if(index<=-1||index>=size()) throw new IndexOutOfBoundsException();
		if(index==0) {
			head = head.next;
			count--;
			return;
		}
		Node curr = head;
		for(int i=1;i<index;i++) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
		count--;
	}
	
	public void reverse() {
		Node prev= null,curr= null,next = null;
		curr = head;
		
		while(curr!=null) {
			next = curr.next;
			curr.next= prev;
			prev =curr;
			curr = next;
		}
		head = prev;
	}
}

public class LinkedList {
	public static void main(String[] args) {
		LinkedListImplements l = new LinkedListImplements();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(40);
		l.add(50);
		l.add(60);
		
		System.out.println(l.size());
		l.add(5,70);
		System.out.println(l.size());
		
		for(int i=0;i<l.size();i++) {
			int dis = (Integer) l.get(i);
			System.out.println(dis);
		}
		System.out.println("-------------------------------------");
		l.remove(6);
		for(int i=0;i<l.size();i++) {
			System.out.println(l.get(i));
		}
		System.out.println("------------------------------------------");
		l.reverse();
		for(int i=1;i<l.size();i++) {
			System.out.println(l.get(i));
		}
	}
}
