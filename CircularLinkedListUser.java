package com.jaggu.LinearProgrammingAlgorithm;
class Node1 {
	Object ele;
	Node1 next;
	Node1 prev;
	
	public Node1 (Object ele) {
		this.ele = ele;
	}
	public Node1(Object ele, Node1 next) {
		this.ele = ele;
		this.next = next;
	}	
}
class CircularLinkedList {
	Node1 head;
	Node1 tail;
	 int count=0;
	
	
	public void add(Object ele) {
		  Node1 node = new Node1(ele);
		  if (head == null) {
		    head = node;
		    tail = node;
		    node.next = head;
		    count++;
		  } else {
		    Node1 temp = head;
		    node.next = temp;
		    head = node;
		    tail.next = head;
		    count++;
		  }
		}
	public int size() {
		return count;
	}
	
	 public void addAt(Object ele, int index) {
		    Node1 node = new Node1(ele);
		    Node1 temp = head;
		    count++;
		    if (temp == null || size() < index) throw new IndexOutOfBoundsException();
		      
		      node.ele = ele;
		      for (int i = 1; i < index - 1; i++) {
		        temp = temp.next;
		      }
		      node.next = temp.next;
		      temp.next = node;
		    }
	 
	 public void addLast(Object ele) {
		  Node1 node = new Node1(ele);
		  if (head == null) {
		    head = node;
		    tail = node;
		    node.next = head;
		  } else { 
			  tail.next = node;
			  tail = node;
			  tail.next = head;
		  }
		}
	 public void display() {
		  Node1 temp = head;
		  while(temp!=null) {
				System.out.println(temp.ele);
				temp  =temp.next;
			} 
		  }
}

public class CircularLinkedListUser {

	public static void main(String[] args) {
		CircularLinkedList cl = new CircularLinkedList();
		cl.add(10);
		cl.add(20);
		cl.addAt(12, 1);
		cl.addAt(22, 2);
		cl.addLast(25);
		cl.display();
		System.out.println(cl.size());
	}

}
