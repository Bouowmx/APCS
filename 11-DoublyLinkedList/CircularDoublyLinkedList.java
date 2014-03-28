import static java.lang.System.out;

public class CircularDoublyLinkedList<E> {
	private static class Node<E> {
		E data;
		Node<E> next, prev;
		
		public Node(E data) {this.data = data;}
		
		public String toString() {return data.toString();}
	}
	
	private int size = 0;
	private Node<E> head, tail;
	
	public CircularDoublyLinkedList() {}
	
	public void add(E e) {
		Node<E> eNode = new Node<E>(e);
		if (head == null) {
			head = eNode;
			tail = eNode;
			head.next = tail;
			head.prev = tail;
			tail.next = head;
			tail.prev = head;
		}
		else {
			eNode.next = head;
			eNode.prev = tail;
			tail.next = eNode;
			tail = eNode;
		}
		size++;
	}
	
	public void add(int index, E e) {
		if ((index < 0) || (index > size())) {throw new IndexOutOfBoundsException("" + index);}
		if (index == 0) {
			Node<E> eNode = new Node<E>(e);
			eNode.next = head;
			eNode.prev = tail;
			head.prev = eNode;
			tail.next = eNode;
			head = eNode;
			size++;
		}
		else if (index == size()) {add(e);}
		else {
			Node<E> eNode = new Node<E>(e);
			Node<E> n = getNode(index);
			eNode.next = n;
			eNode.prev = n.prev;
			n.prev.next = eNode;
			n.prev = eNode;
			size++;
		}
	}
	
	public E get(int index) {
		if ((index < 0) || (index >= size())) {throw new IndexOutOfBoundsException("" + index);}
		return getNode(index).data;
	}
	
	private Node<E> getNode(int index) {
		if ((index < 0) || (index >= size())) {throw new IndexOutOfBoundsException("" + index);}
		Node<E> n = null;
		if (index <= (size() / 2)) {
			n = head;
			for (int i = 0; i < index; i++) {n = n.next;}
			return n;
		}
		else {
			n = tail;
			for (int i = size(); i > index; i--) {n = n.prev;}
			return n;
		}
	}
	
	public int indexOf(E e) {
		int index = 0;
		for (Node<E> n = head; n != null; n = n.next) {
			if (e.equals(n.data)) {return index;}
			index++;
		}
		return -1;
	}
	public E remove(int index) {
		if ((index < 0) || (index >= size())) {throw new IndexOutOfBoundsException("" + index);}
		Node<E> n = getNode(index);
		E oldData = n.data;
		if (index == 0) {head = head.next;}
		if (index == size() - 1) {tail = tail.prev;}
		else {	
			n.prev.next = n.next;
			n.next.prev = n.prev;
		}
		size--;
		return oldData;
	}
	
	public int size() {return size;}
	
	public String toString() {
		if (head == null) {return "[]";}
		String s = "[";
		for (Node<E> n = head; n != tail; n = n.next) {s += n.toString() + ", ";}
		return s + tail.toString() + "]";
	}
	
	public static void main(String[] args) {
		CircularDoublyLinkedList<Integer> l = new CircularDoublyLinkedList<Integer>();
		out.println(l);
		l.add(0);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		out.println(l);
		//printList(l);
		l.add(0, 9);
		l.add(4, 9);
		l.add(7, 9);
		out.println(l);
		//printList(l);
		l.remove(7);
		l.remove(4);
		out.println(l.remove(0));
		out.println(l);
		//printList(l);
		out.println(l.indexOf(3));
	}
	
	public static <E> void printList(CircularDoublyLinkedList<E> l) {
		for (int i = 0; i < l.size(); i++) {
			Node<E> n = l.getNode(i);
			out.println("Node " + i + ":");
			out.println("Data: " + n.data);
			out.println("Next: " + n.next);
			out.println("Prev: " + n.prev);
			out.println();
		}
	}
}
