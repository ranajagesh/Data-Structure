package com.jaggu.LinearProgrammingAlgorithm;

class Implementation {
	private Object[]a = new Object[5];
	private int p =0;
	
	public void add(Object ele) {
		if(p>=a.length) increasedArraySize();
		a[p++] = ele;
	}
	private void increasedArraySize() {
		Object [] temp = new Object[a.length+3];
		System.arraycopy(a, 0, temp, 0, p);
		a = temp;
	}
	public int size() {
		return p;
	}
	public Object get(int index) {
		if(index<0 || index>size()) throw new IndexOutOfBoundsException();
		else return a[index];
	}
	public void set(Object ele,int index) {
		if(index<0 || index>size()-1) throw new IndexOutOfBoundsException();
		else 
			a[index]  = ele;
	}
	public void addPos(Object ele,int index) {
		if(index<0|| index>=size())
			throw new IndexOutOfBoundsException();			
			if(p == a.length-1) increasedArraySize();
			
			for(int i=size();i>=index;i--) {
				a[i+1] = a[i];
			}
			a[index] = ele;
			p++;
			
		}
	
	public Object remove(int index) {
		if(index<0||index>size()) throw new IndexOutOfBoundsException();
		Object ele  = a[index];
		for(int i=index+1;i<size();i++) {
			a[i-1] = a[i];
		}
		p--;
		return ele;
	}
}

public class ArrayList {
	public static void main(String[] args) {
		Implementation i = new Implementation();
		i.add(10);
		i.add(20);
		i.add(30);
		i.add(40);
		i.add(50);
		i.add(60);
		i.add(70);
		
		i.set(5, 5);
		i.addPos(100, 5);
		i.remove(4);
		
		for(int j=0;j<i.size();j++) {
			System.out.println(i.get(j));
		}
	}
	
}
