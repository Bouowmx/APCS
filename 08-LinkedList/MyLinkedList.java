public class MyLinkedList<E> {
	private Node<E> head;
	private int size = 0;
	
	public MyLinkedList() {}
	
	public void add(E e) {
		Node<E> eNode = new Node<E>(e);
		eNode.setNext(head);
		head = eNode;
		size++;
	}
	
	public void add(int index, E e) {
		if ((index < 0) || (index >= size())) {throw new IndexOutOfBoundsException("" + index);}
		Node<E> eNode = new Node<E>(e);
		eNode.setNext(getNode(index));
		getNode(index - 1).setNext(eNode);
		size++;
	}
	
	public E get(int index) {return getNode(index).getData();}
	
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

	private class Node<E> {
		private E data;
		private Node<E> next;
		
		public Node(E data) {this.data = data;}
		public Node(E data, Node<E> next) {
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
		E oldData = get(index);
		getNode(index - 1).setNext(getNode(index + 1));
		size--;
		return oldData;
	}
	
	public E set(int index, E e) {
		E oldData = get(index);
		Node<E> eNode = new Node<E>(e);
		eNode.setNext(getNode(index + 1));
		getNode(index - 1).setNext(eNode);
		return oldData;
	}
	
	public int size() {return size;}
	
	public String toString() {
		String s = "[";
		for (Node<E> n = head; n != null; n = n.getNext()) {s += n.toString() + ", ";}
		return s.substring(0, s.length() - 2) + "]";
	}
	
	public static void main(String[] args) {
		MyLinkedList<Integer> l = new MyLinkedList<Integer>();
		l.add(4);
		l.add(3);
		l.add(2);
		l.add(1);
		l.add(0);
		System.out.println(l);
		System.out.println(l.set(3, 9));
		System.out.println(l);
		l.add(3, 3);
		System.out.println(l);
		System.out.println(l.remove(4));
		System.out.println(l);
	}
}
