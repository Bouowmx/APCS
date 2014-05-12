//This does not work.

import static java.lang.System.out;
import java.util.Arrays;
import java.util.Random;

public class Heapsort {
	/*public static int filledLength(Object[] a) {
		for (int i = a.length - 1; i >= 0; i--) {if (a[i] != null) {return i + 1;}}
		return 0;
	}*/
	
	public static <E extends Comparable<? super E>> void heapify(E[] a) {for (int i = (a.length - 2) / 2; i >= 0; i--) {shiftDown(a, i, a.length - 1);}}
	
	public static <E extends Comparable<? super E>> void heapsort(E[] a) {
		heapify(a);
		for (int i = a.length - 1; i > 0; i--) {
			swap(a, i, 0);
			shiftDown(a, 0, i);
		}
	}
	
	public static <E extends Comparable<? super E>> void shiftDown(E[] a, int start, int end) {
		int root = start;
		while (2 * root + 1 <= end) {
			int swap = root, leftChild = 2 * root + 1, rightChild = 2 * root + 2;
			if (a[swap].compareTo(a[leftChild]) < 0) {swap = leftChild;}
			if ((rightChild <= end) && (a[swap].compareTo(a[rightChild]) < 0)) {swap = rightChild;}
			if (swap != root) {
				swap(a, root, swap);
				root = swap;
			}
			else {return;}
		}
	}
	
	public static <E> void swap(E[] a, int i1, int i2) {
		E t = a[i1];
		a[i1] = a[i2];
		a[i2] = t;
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[10];
		Random r = new Random();
		for (int i = 0; i < 10; i++) {a[i] = new Integer(r.nextInt(1000));}
		out.println(Arrays.toString(a));
		heapsort(a);
		out.println(Arrays.toString(a));
	}
}
