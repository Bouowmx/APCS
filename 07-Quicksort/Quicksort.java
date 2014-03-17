import static java.lang.System.arraycopy;
import static java.lang.System.nanoTime;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Quicksort {
	public static <E extends Comparable<? super E>> int partition(E[] a, int l, int r, int pIndex) { //r is exclusive
		E pValue = a[pIndex];
		swap(a, pIndex, r - 1);
		int sIndex = l;
		for (int i = l; i < r - 2; i++) {
			if (a[i].compareTo(pValue) <= 0) {swap(a, i, sIndex++);}
		}
		swap(a, sIndex, r - 1);
		return sIndex;
	}
	
	/*In place
	public static <E extends Comparable<? super E>> void quicksort(E[] a) {quicksort(a, 0, a.length - 1);}
	
	public static <E extends Comparable<? super E>> void quickSort(E[] a, int l, int r) {
		if ((right - left) <= 1) {return;}
		Random random = new Random();
		int pIndex = left + random.nextInt(r - l - 2) + 1;
		pIndex = partition(a, l, r, pIndex);
		quicksort(a, l, pIndex);
		quicksort(a, l, pIndex + 1, r);
	}*/
	
	public static <E extends Comparable<? super E>> E[] quicksort(E[] a) {
		if (a.length <= 1) {return a;}
		Random random = new Random();
		int pIndex = random.nextInt(a.length - 1) + 1;
		E pValue = a[pIndex];
		ArrayList<E> leftList = new ArrayList<E>();
		ArrayList<E> pivotsList = new ArrayList<E>();
		ArrayList<E> rightList = new ArrayList<E>();
		for (int i = 0; i < a.length; i++) {
			if (a[i].compareTo(pValue) < 0) {leftList.add(a[i]);}
			if (a[i].compareTo(pValue) == 0) {pivotsList.add(a[i]);}
			if (a[i].compareTo(pValue) > 0) {rightList.add(a[i]);}
		}
		E[] left = quicksort(leftList.toArray(Arrays.copyOf(a, 0))); //static <T> T[] copyOf(T[] original, int newLength) to get around generic array creation
		E[] pivots = pivotsList.toArray(Arrays.copyOf(a, 0));
		E[] right = quicksort(rightList.toArray(Arrays.copyOf(a, 0)));
		E[] aSorted = Arrays.copyOf(a, a.length);
		arraycopy(left, 0, aSorted, 0, left.length);
		arraycopy(pivots, 0, aSorted, left.length, pivots.length);
		arraycopy(right, 0, aSorted, left.length + pivots.length, right.length);
		return aSorted;
	}
	
	public static <E> void swap(E[] a, int i, int j) {
		E temp = a[j];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[1001];
		Random random = new Random();
		for (int i = 0; i < a.length; i++) {a[i] = random.nextInt(100);}
		out.println(Arrays.toString(a));
		long t1 = nanoTime();
		a = quicksort(a);
		long t2 = nanoTime();
		out.println(Arrays.toString(a));
		out.println("Time: " + (t2 - t1) + " ns / " + ((double) (t2 - t1) / 1000000) + " ms / " + ((double) (t2 - t1) / 1000000000) + " s");
	}
}
