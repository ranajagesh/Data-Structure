package com.jaggu.NonLinearProgrammingAlgorithm;

class Noded {
	Object ele;
	Noded next;
	
	public Noded(Object ele, Noded next) {

		this.ele = ele;
		this.next = next;
	}

	Noded(Object ele) {
		this.ele = ele;
	}
}

public class HashSet {

	Noded []a = new Noded[10];
	int count = 0;
	
	public int size() {
		return count;
	}
	public boolean add (Object key) {
		//Hashing
		
		int index = key.hashCode()%a.length;
		index = Math.abs(index);
		if(a[index]==null) {
			a[index] = new Noded(key);
			count++;
			return true;
		}
		Noded temp = null;
		Noded curr = a[index];
		while(curr!=null) {
			if(curr.ele.equals(key)) return false;
			temp = curr;
			curr = curr.next;
		}
		temp.next = new Noded(key);
		count++;
		return true;
	}
	
	public void display() {
		for(int i=0;i<a.length;i++) {
			Noded curr = a[i];
			while(curr!=null) {
				System.out.println(curr.ele);
				curr = curr.next;
			}
		}
	}
	
	public boolean contains(Object key) {
		int index = key.hashCode()%a.length;
		index = Math.abs(index);
		Noded curr = a[index];
		while(curr!=null) {
			if(curr.ele.equals(key)) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}
	
	public boolean remove(Object key) {
		int index = key.hashCode()%a.length;
		index = Math.abs(index);
		Noded prev = null;
		Noded curr = a[index];
		
		while(curr!=null) {
			if(curr.ele.equals(key)) {
				if(prev==null) {
					a[index] = a[index].next;
					count--;
					return true;
				}
				prev.next = prev.next.next;
				count--;
				return true;
			}
			prev = curr;
			curr = curr.next;
		}
		return false;
	}
	
	public static void main(String[] args) {
		HashSet s = new HashSet();
		s.add(10);
		s.add(20);
		s.add(30);
		s.add(45);
		s.add(50);
		s.add(95);
		System.out.println(s.remove(20));
		System.out.println(s.size());
		System.out.println(s.contains(958));
	}

}
