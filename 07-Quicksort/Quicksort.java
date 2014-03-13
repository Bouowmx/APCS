import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Quicksort { //What I have for now
	public static <E extends Comparable<? super E>> E[] quicksort(E[] a) {
		if (a.length <= 1) {return a;}
		Random random = new Random();
		int pIndex = random.nextInt(a.length - 1) + 1;
		E pValue = a[pIndex];
		ArrayList<E> leftList = new ArrayList<E>();
		ArrayList<E> rightList = new ArrayList<E>();
		for (int i = 0; i < a.length; i++) {
			if (a[i].compareTo(pValue) <= 0) {leftList.add(a[i]);}
			if (a[i].compareTo(pValue) > 0) {rightList.add(a[i]);}
		}
		E[] left = quicksort(leftList.toArray(Arrays.copyOf(a, 0))); //static <T> T[] copyOf(T[] original, int newLength) to get around generic array creation
		E[] right = quicksort(rightList.toArray(Arrays.copyOf(a, 0)));
		return null;
	}
}