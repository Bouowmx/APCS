import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size = 0;
	
	public MyLinkedList() {}
	
	public void add(E e) {
		Node<E> eNode = new Node<E>(e);
		if (head == null) {head = eNode;}
		if (tail != null) {tail.setNext(eNode);}
		tail = eNode;
		size++;
	}
	
	public void add(int index, E e) {
		if ((index < 0) || (index > size)) {throw new IndexOutOfBoundsException("" + index);}
		Node<E> eNode = new Node<E>(e);
		if (index == 0) {
			eNode.setNext(head);
			head = eNode;
		}
		else if (index == size) {add(e);}
		else {
			Node<E> n = getNode(index - 1);
			eNode.setNext(n.getNext());
			n.setNext(eNode);
		}
		size++;
	}
	
	public E get(int index) {
		if ((index < 0) || (index >= size)) {throw new IndexOutOfBoundsException("" + index);}
		return getNode(index).getData();
	}
	
	public int indexOf(E e) {
		int index = 0;
		for (Node<E> n = head; n != null; n = n.getNext()) {
			if (e.equals(n.getData())) {return index;}
			index++;
		}
		return -1;
	}
	
	protected Node<E> getNode(int index) {
		if ((index < 0) || (index >= size())) {throw new IndexOutOfBoundsException("" + index);}
		Node<E> n = head;
		for (int i = 0; i < index; i++) {n = n.getNext();}
		return n;
	}
	
	public Iterator<E> iterator() {return new MyLinkedListIterator<E>(head);}
	
	private class MyLinkedListIterator<E> implements Iterator<E> {
		private Node<E> currentNode;
		
		private MyLinkedListIterator(Node<E> n) {currentNode = n;}
		
		public boolean hasNext() {return currentNode != null;}
		
		public E next() {
			E next = currentNode.getData();
			currentNode = currentNode.getNext();
			return next;
		}
		
		public void remove() {throw new UnsupportedOperationException();}
	}
	
	private class Node<E> {
		private E data;
		private Node<E> next;
		
		private Node(E data) {this.data = data;}
		private Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
		
		public E getData() {return data;}
		public Node<E> getNext() {return next;}
		
		public void setData(E data) {this.data = data;}
		public void setNext(Node<E> next) {this.next = next;}
		
		public String toString() {return data.toString();}
	}
	
	public E remove(int index) {
		if ((index < 0) || (index >= size())) {throw new IndexOutOfBoundsException("" + index);}
		E oldData = get(index);
		Node<E> n = getNode(index - 1);
		n.setNext(n.getNext().getNext());
		size--;
		return oldData;
	}
	
	public E set(int index, E e) {
		if ((index < 0) || (index >= size())) {throw new IndexOutOfBoundsException("" + index);}
		E oldData = get(index);
		getNode(index).setData(e);
		return oldData;
	}
	
	public int size() {return size;}
	
	public String toString() {
		String s = "[";
		for (Node<E> n = head; n != null; n = n.getNext()) {
			s += n.toString();
			if (n.getNext() != null) {s += ", ";}
		}
		return s + "]";
	}
	
	public static void main(String[] args) {
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();
		l.add(0);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		System.out.println(l);
		for (Integer i : l) {System.out.print(i + ", ");}
	}
}
