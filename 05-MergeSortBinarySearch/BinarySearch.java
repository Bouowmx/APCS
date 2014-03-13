import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import static java.lang.System.out;

public class BinarySearch {
	public static int binarySearchIterative(int e, int[] a) {
		int start = 0, end = a.length;
		for (;;) {
			if ((end - start) < 1) {return -1;}
			if (e == a[(start + end) / 2]) {return (start + end) / 2;}
			if (e < a[(start + end) / 2]) {end = (start + end) / 2;}
			if (e > a[(start + end) / 2]) {start = ((start + end) / 2) + 1;}
		}
	}
	
	public static int binarySearchRecursive(int e, int[] a) {return binarySearchRecursive(e, a, 0, a.length);}
	
	private static int binarySearchRecursive(int e, int[] a, int start, int end) {
		if ((end - start) < 1) {return -1;}
		if (e < a[(start + end) / 2]) {return binarySearchRecursive(e, a, start, (start + end) / 2);}
		if (e > a[(start + end) / 2]) {return binarySearchRecursive(e, a, ((start + end) / 2) + 1, end);}
		return (start + end) / 2;
	}
	
	public static <E extends Comparable<E>> int binarySearch(ArrayList<E> l, E e) {
		int start = 0, end = l.size();
		for (;;) {
			if ((end - start) < 1) {return -1;}
			if (e.compareTo(l.get((start + end) / 2)) == 0) {return (start + end) / 2;}
			if (e.compareTo(l.get((start + end) / 2)) < 0) {end = (start + end) / 2;}
			if (e.compareTo(l.get((start + end) / 2)) > 0) {start = ((start + end) / 2) + 1;}
		}
	}	
	
	public static void main(String[] args) {
		int[] a = new int[11];
		Random random = new Random();
		for (int i = 0; i < a.length; i++) {a[i] = random.nextInt(100);}
		a = MergeSort.mergeSort(a);
		int e = a[random.nextInt(a.length)];
		out.println("binarySearchIterative(" + e + ", " + Arrays.toString(a) + binarySearchIterative(e, a));
		out.println("binarySearchIterative(-1, " + Arrays.toString(a) + binarySearchIterative(-1, a));
		out.println("binarySearchRecursive(" + e + ", " + Arrays.toString(a) + binarySearchRecursive(e, a));
		out.println("binarySearchRecursive(-1, " + Arrays.toString(a) + binarySearchRecursive(-1, a));
		ArrayList<Integer> list = new ArrayList<Integer>(11);
		for (int i = 0; i < a.length; i++) {list.add(a[i]);}
		out.println("binarySearch(" + list + ", " + e + ") -> " + binarySearch(list, e));
	}
}
