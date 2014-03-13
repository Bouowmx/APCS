import java.util.Array;
import java.util.Random;
import static java.lang.System.arraycopy;
import static java.lang.System.nanoTime;
import static java.lang.System.out;

public class MergeSort {
	public static double[] sort(double[] array) {
		if (array.length <= 1) {return array;}
		double[] left, right;
		left = new double[array.length / 2];
		right = new double[array.length - left.length];
		arraycopy(array, 0, left, 0, left.length);
		arraycopy(array, array.length / 2, right, 0, right.length);
		if (array.length % 2 == 1) {right[right.length - 1] = array[array.length - 1];}
		left = sort(left);
		right = sort(right);
		double[] arrayCopy = new double[array.length];
		arraycopy(array, 0, arrayCopy, 0, array.length);
		int i = 0, j = 0, k = 0;
		while ((j < left.length) && (k < right.length)) {
			if (left[j] < right[k]) {arrayCopy[i++] = left[j++];}
			else {arrayCopy[i++] = right[k++];}
		}
		while (j < left.length) {arrayCopy[i++] = left[j++];}
		while (k < right.length) {arrayCopy[i++] = right[k++];}
		return arrayCopy;
	}
	public static int[] sort(int[] array) {
		if (array.length <= 1) {return array;}
		int[] left, right;
		left = new int[array.length / 2];
		right = new int[array.length - left.length];
		arraycopy(array, 0, left, 0, left.length);
		arraycopy(array, array.length / 2, right, 0, right.length);
		if (array.length % 2 == 1) {right[right.length - 1] = array[array.length - 1];}
		left = sort(left);
		right = sort(right);
		int[] arrayCopy = new int[array.length];
		arraycopy(array, 0, arrayCopy, 0, array.length);
		int i = 0, j = 0, k = 0;
		while ((j < left.length) && (k < right.length)) {
			if (left[j] < right[k]) {arrayCopy[i++] = left[j++];}
			else {arrayCopy[i++] = right[k++];}
		}
		while (j < left.length) {arrayCopy[i++] = left[j++];}
		while (k < right.length) {arrayCopy[i++] = right[k++];}
		return arrayCopy;
	}
	
	public static void main(String[] args) {
		int[] array = new int[11];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {array[i] = random.nextInt(100);}
		out.println(Arrays.toString(array));
		long t1 = nanoTime();
		array = sort(array);
		long t2 = nanoTime();
		out.println(Arrays.toString(array));
		out.println("Time: " + times(t2, t1));
		out.println("\nBenchmark:");
		out.println("Number of elements: Time");
		for (int i = 0; i <= 7; i++) {
			int elements = (int) Math.pow(10, i);
			array = new int[elements];
			for (int j = 0; j < elements; j++) {array[i] = random.nextInt();}
			t1 = nanoTime();
			sort(array);
			t2 = nanoTime();
			out.println(10 + "^" + i + ": " + times(t2, t1));
		}
	}
	
	public static String times(long t2, long t1) {return (t2 - t1) + " ns / " + ((double) (t2 - t1) / 1000000) + " ms / " + ((double) (t2 - t1) / 1000000000) + " s";}
}
