import static java.lang.System.out;

public class DoubleLL<E> {
	private class Node<E> {
		E data;
		Node<E> prev, next;
		
		public Node(E d) {data = d;}
		
		public String toString() {return "" + data;}
		
		public void setData(E d) {data = d;}
		public E getData() {return data;}
		
		public void setNext(Node<E> n) {next = n;}
		public Node<E> getNext() {return next;}
		
		public void setPrev(Node<E> p) {prev = p;}
		public Node<E> getPrev() {return prev;}
	}
	
	private Node<E> current;
	
	public void insert(E d) {
		Node<E> n = new Node<E>(d);
		if (current == null) {current = n;}
		else {
			n.next = current;
			if (current.prev != null) {
				n.prev = current.prev;
				current.prev.next = n;
			}
			current.prev = n;
			current = n;
		}
	}
	
	public E getCurrent() {return current.getData();}
	
	public void forward() {
		if (current.getNext() != null) {current = current.getNext();}
	}
	
	public void back() {
		if (current.getPrev() != null) {current = current.getPrev();}
	}
	
	public String toString() {
		if (current == null) {return "";}
		Node<E> tmp = current;
		while (tmp.getPrev() != null) {tmp = tmp.getPrev();}
		String s = "";
		while (tmp != null) {
			s = s + tmp.getData() + " ";
			tmp = tmp.getNext();
		}
		return s;
	}
	
	public static void main(String[] args) {
		DoubleLL<String> L = new DoubleLL<String>();
		out.println(L);
		L.insert("hello");
		out.println(L);
		L.insert("world");
		out.println(L);
		L.insert("three");
		out.println(L);
		//First test up to here
		out.println(L.getCurrent());
		L.forward();
		out.println(L.getCurrent());
		L.insert("inserted");
		out.println(L);
		//then test again to here
	}
}
