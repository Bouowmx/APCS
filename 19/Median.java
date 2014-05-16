import static java.lang.System.arraycopy;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

@SuppressWarnings("unchecked")
public class Median<E extends Comparable<? super E>> {
	private class ReverseComparator<T extends Comparable<? super T>> implements Comparator<T> {
		private ReverseComparator() {}
		public int compare(T o1, T o2) {return -o1.compareTo(o2);}
		private boolean equal(T o1, T o2) {return o1.compareTo(o2) == 0;}
	}
	
	private PriorityQueue<E> max = new PriorityQueue<E>(11, new ReverseComparator<E>());
	private PriorityQueue<E> min = new PriorityQueue<E>(); //Right-biased
	
	public Median() {}
	
	public boolean add(E e) {
		if (size() == 0) {min.offer(e);}
		if (e.compareTo(min.peek()) >= 0) {min.offer(e);}
		else {max.offer(e);}
		balance();
		return true;
	}
	
	private void balance() {
		if ((min.size() - max.size()) > 1) {max.offer(min.poll());}
		if ((max.size() - min.size()) > 0) {min.offer(max.poll());}
	}
	
	public E[] getMedian() {
		if (size() == 0) {return null;}
		else if ((size() % 2) == 0) {
			Comparable[] a = {max.peek(), min.peek()};
			return (E[]) a;
		}
		else {
			Comparable[] a = {min.peek()};
			return (E[]) a;
		}
	}
	
	public E[] removeMedian() {
		if (size() == 0) {return null;}
		else if ((size() % 2) == 0) {
			Comparable[] a = {max.poll(), min.peek()};
			balance();
			return (E[]) a;
		}
		else {
			Comparable[] a = {min.poll()};
			balance();
			return (E[]) a;
		}
	}
	
	public E[] toArray() {
		Comparable[] a = new Comparable[size()];
		Object[] maxArray = max.toArray(), minArray = min.toArray();
		Arrays.sort(maxArray);
		Arrays.sort(minArray);
		arraycopy(maxArray, 0, a, 0, maxArray.length);
		arraycopy(minArray, 0, a, maxArray.length, minArray.length);
		return (E[]) a;
	}
	
	public String toString() {
		Object[] maxArray = max.toArray(), minArray = min.toArray();
		Arrays.sort(maxArray);
		Arrays.sort(minArray);
		return Arrays.toString(maxArray) + Arrays.toString(minArray);
	}
	
	public int size() {return max.size() + min.size();}
	
	public static void main(String[] args) {
		Median<Integer> m = new Median<Integer>();
		out.println(m);
		out.println(Arrays.toString(m.toArray()));
		out.println(Arrays.toString(m.getMedian()));
		out.println();
		Random r = new Random();
		for (int i = 0; i < 10; i++) {m.add(r.nextInt(100));}
		out.println(m);
		out.println(Arrays.toString(m.toArray()));
		out.println(Arrays.toString(m.getMedian()));
		out.println();
		m.removeMedian();
		out.println(m);
		out.println(Arrays.toString(m.getMedian()));
	}
}
