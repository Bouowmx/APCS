import java.util.Arrays;
import java.util.Random;
import static java.lang.System.out;

public class Quickselect { //Quickselect is one word
	//I tried creating quickselect for ints. It didn't work because with int, one cannot indicate "empty" space(s) for the pivot: 0, -1, or any other integer don't work. Integer was the next best thing but with the compareTo method, why not with Comparable?
	public static <E extends Comparable<? super E>> E quickselect(E[] a, int n) {return quickselect(a, n, 0, a.length);}
	
	private static <E extends Comparable<? super E>> E quickselect(E[] a, int n, int left, int right) {
		if ((right - left) <= 1) {return a[left];} //Following Java conventions of excluding the latter
		Random random = new Random();
		E pValue = a[left + random.nextInt(right - left - 1)];
		E[] aCopy = Arrays.copyOf(a, a.length); //Iteration would be a better idea, considering all the copying
		Arrays.fill(aCopy, left, right, null);
		int j = left, k = right - 1;
		for (int i = left; i < right; i++) {
			if (a[i].compareTo(pValue) < 0) {aCopy[j++] = a[i];}
			if (a[i].compareTo(pValue) > 0) {aCopy[k--] = a[i];}
		}
		for (int i = left; i < right; i++) {if (aCopy[i] == null) {aCopy[i] = pValue;}}
		int pIndex = -1;
		for (int i = left; i < right; i++) {
			if (aCopy[i].equals(pValue)) {
				pIndex = i;
				break;
			}
		}
		if (pIndex < n) {return quickselect(aCopy, n, pIndex + 1, right);}
		if (pIndex > n) {return quickselect(aCopy, n, left, pIndex);} //No need to use pIndex - 1 because the exclusion of the latter in a range already compensates
		return aCopy[pIndex];
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[20];
		Random random = new Random();
		for (int i = 0; i < a.length; i++) {a[i] = random.nextInt(10);}
		out.println("nth smallest element in " + Arrays.toString(a) + ":");
		Integer[] aCopy = Arrays.copyOf(a, a.length);
		Arrays.sort(aCopy);
		out.println("                sorted: " + Arrays.toString(aCopy));
		out.println("n|nth smallest element");
		out.println("----------------------");
		for (int i = 0; i < 10; i++) {
			out.println(i + "|" + quickselect(a, i));
		}
	}
}
