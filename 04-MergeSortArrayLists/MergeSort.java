import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import static java.lang.Math.pow;
import static java.lang.System.arraycopy;
import static java.lang.System.nanoTime;
import static java.lang.System.out;

public class MergeSort {
	public static ArrayList<String> mergeSort(ArrayList<String> list) {
                if (list.size() <= 1) {return list;}
                ArrayList<String> left = new ArrayList<String>(list.size() / 2), right = new ArrayList<String>(list.size() - (list.size() / 2));
                for (int i = 0; i < list.size() / 2; i++) {
                        left.add(list.get(i));
                        right.add(list.get((list.size() / 2) + i));
                }
                if (list.size() % 2 == 1) {right.add(list.get(list.size() - 1));}
                left = mergeSort(left);
                right = mergeSort(right);
                ArrayList<String> listSorted = new ArrayList<String>(list.size());
                int i = 0, j = 0;
		while ((i < left.size()) && (j < right.size())) {
			if (left.get(i).compareTo(right.get(j)) < 0) {listSorted.add(left.get(i++));}
			else {listSorted.add(right.get(j++));}
		}
		while (i < left.size()) {listSorted.add(left.get(i++));}
		while (j < right.size()) {listSorted.add(right.get(j++));}
                return listSorted;
        }
        
        public static double[] mergeSort(double[] array) {
                if (array.length <= 1) {return array;}
                double[] left, right;
                left = new double[array.length / 2];
                right = new double[array.length - left.length];
                arraycopy(array, 0, left, 0, left.length);
                arraycopy(array, array.length / 2, right, 0, right.length);
                left = mergeSort(left);
                right = mergeSort(right);
                double[] arraySorted = new double[array.length];
                int i = 0, j = 0, k = 0;
                while ((j < left.length) && (k < right.length)) {
                        if (left[j] < right[k]) {arraySorted[i++] = left[j++];}
                        else {arraySorted[i++] = right[k++];}
                }
                while (j < left.length) {arraySorted[i++] = left[j++];}
                while (k < right.length) {arraySorted[i++] = right[k++];}
                return arraySorted;
        }

        public static int[] mergeSort(int[] array) {
                if (array.length <= 1) {return array;}
                int[] left, right;
                left = new int[array.length / 2];
                right = new int[array.length - left.length];
                arraycopy(array, 0, left, 0, left.length);
                arraycopy(array, array.length / 2, right, 0, right.length);
                left = mergeSort(left);
                right = mergeSort(right);
                int[] arraySorted = new int[array.length];
                int i = 0, j = 0, k = 0;
                while ((j < left.length) && (k < right.length)) {
                        if (left[j] < right[k]) {arraySorted[i++] = left[j++];}
                        else {arraySorted[i++] = right[k++];}
                }
                while (j < left.length) {arraySorted[i++] = left[j++];}
                while (k < right.length) {arraySorted[i++] = right[k++];}
                return arraySorted;
        }

        public static void main(String[] args) {
                int[] array = new int[11];
                ArrayList<String> list = new ArrayList<String>();
                Random random = new Random();
                final String[] ALPHABET = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
                for (int i = 0; i < array.length; i++) {
                        array[i] = random.nextInt(100);
                        list.add(ALPHABET[random.nextInt(26)]);
                }
                long t1, t2;
                out.println("Array:");
                out.println(Arrays.toString(array));
                t1 = nanoTime();
                array = mergeSort(array);
                t2 = nanoTime();
                out.println(Arrays.toString(array));
                out.println("Time: " + times(t2, t1));
                out.println("\nArrayList:");
                out.println(list);
                t1 = nanoTime();
                list = mergeSort(list);
                t2 = nanoTime();
                out.println(list);
                out.println("Time: " + times(t2, t1));
                out.println("\nBenchmark:");
                out.println("Number of elements: Time");
                out.println("Arrays:");
                for (int i = 0; i <= 7; i++) {
                        array = new int[(int) pow(10, i)];
                        for (int j = 0; j < array.length; j++) {array[i] = random.nextInt();}
                        t1 = nanoTime();
                        mergeSort(array);
                        t2 = nanoTime();
                        out.println(10 + "^" + i + ": " + times(t2, t1));
                }
                array = null; //Don't need it any more; save some memory.
                out.println("\nArrayLists:");
                for (int i = 0; i <= 7; i++) {
                        int elements = (int) pow(10, i);
                        list = new ArrayList<String>(elements);
                        for (int j = 0; j < elements; j++) {list.add(ALPHABET[random.nextInt(26)]);}
                        t1 = nanoTime();
                        mergeSort(list);
                        t2 = nanoTime();
                        out.println(10 + "^" + i + ": " + times(t2, t1));
                }
        }

        public static String times(long t2, long t1) {return (t2 - t1) + " ns / " + ((double) (t2 - t1) / 1000000) + " ms / " + ((double) (t2 - t1) / 1000000000) + " s";}
}
