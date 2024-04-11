package com.jaggu.LinearProgrammingAlgorithm;

class Noded {
	Object ele;
	Noded next;
	Noded prev;
	
	public Noded (Object ele) {
		this.ele = ele;
	}
	public Noded(Object ele, Noded next, Noded prev) {
		this.ele = ele;
		this.next = next;
		this.prev = prev;
	}	
}

class DoublyLinkedListImple {
	Noded head ;
	Noded tail;
	int count = 0;
	Noded last;
	
	public void add(Object ele) {
		if(head==null) {
			addFirst(ele);
			return;
		}
		Noded curr = head;
		while(curr.next!=null) {
			curr = curr.next;
		}
		curr.next = new Noded(ele,last,null); 
		last = curr.next;
		tail = last;
		count++;
	}
	
	public void addFirst(Object ele) {
		Noded n = new Noded(ele);
		n.next = head;
		if(head!=null) head.prev = n;
		head = n;
		last =head;
		count++;
	}
	
	public int size() {
		return count;
	}
	
	public Object get (int index) {
		if(index<0 || index>=size()) throw new IndexOutOfBoundsException();
		Noded curr = head;
		for(int i=0;i<index;i++) {
			curr = curr.next;
		}
		return curr.ele;
	}
	
	public void addIndex(Object ele,int index) {
		if(index==0) {
			addFirst(ele);
			return;
		}
		Noded n = new Noded(ele);
		Noded curr = head;
		for(int i=1;i<index;i++) {
			curr = curr.next;
		}
		n.next = curr.next;
		n.next.prev = n;
		curr.next = n;
		n.prev = curr;
		count++;
	}
	
	public Object removeFirstEle() {
		if(head.next ==null) {
			Object e = head.ele;
			head = null;
			tail = null;
			count--;
			return e;
		}
		Object ele = head.ele;
		head = head.next;
		head.prev = null;
		count--;
		return ele;
	}
	
	public void display() {
		Noded curr = head;
		while(curr!=null) {
			System.out.println(curr.ele);
			curr  =curr.next;
		}
	}
	public void reverse() {
		Noded curr = tail;
		while(curr!=null) {
			System.out.println(curr.ele);
			curr = curr.prev;
		}
	}
	
	public Object removeLastEle() {
		if(head.next==null) {
			Object e = head.ele;
			head = null;
			tail = null;
			count--;
			return e;
		}
		Object ele = tail.ele;
		tail = tail.prev;
		tail.next = null;
		count--;
		return ele;
	}
	
	public Object remove(int index) {
		if(index == 0) return removeFirstEle();
		if(index==size()-1) return removeLastEle();
		
		Noded curr = head;
		for(int i=1;i<index;i++) {
			curr = curr.next;
		}
		Object ele  = curr.next.ele;
		curr.next = curr.next.next;
		curr.next.prev = curr;
		count--;
		return ele;
	}
}

public class DoublyLinkedListUser {

	public static void main(String[] args) {
		DoublyLinkedListImple d = new DoublyLinkedListImple();
		d.add(10);
		d.add(20);
		d.add(30);
		d.add(40);
		d.add(50);
		d.add(60);
		d.add(70);
		d.add(80);
		d.add(90);
		System.out.println(d.size());
		d.addFirst(5);
		d.addIndex(15, 0);
		d.addIndex(25, 8);
		d.display();
		System.out.println(d.size());
		System.out.println(d.get(5));
		for(int i=0;i<d.size();i++) {
			System.out.println(d.get(i));
		}
	}

}
