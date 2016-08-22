package codingProblems;
import java.io.*;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) throws IOException{
		BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
		int arraySize = Integer.parseInt(R.readLine());
		int[] inputArray = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			inputArray[i] = Integer.parseInt(R.readLine());
		}
		int[] inputArray2=inputArray;
		mergeSortTopDown(inputArray);
		for (int j = 0; j < inputArray.length; j++) {
			System.out.print(inputArray[j]+" ");
		}
		System.out.println();
		sort(inputArray2);
		for (int j = 0; j < inputArray2.length; j++) {
			System.out.print(inputArray2[j]+" ");
		}
	}
	
	//top-down
	static void mergeSortTopDown(int[] A) {
		if (A.length > 1) {
			int q = A.length/2;

			int[] leftArray = Arrays.copyOfRange(A, 0, q);
			int[] rightArray = Arrays.copyOfRange(A,q,A.length);

			mergeSortTopDown(leftArray);
			mergeSortTopDown(rightArray);

			merge(A,leftArray,rightArray);
		}
	}

	static void merge(int[] a, int[] l, int[] r) {
		int i,li,ri;
		i = li = ri = 0;
		while ( i < l.length + r.length) {
			if ((li < l.length) && (ri<r.length)) {
				if (l[li] < r[ri]) {
					a[i] = l[li];
					i++;
					li++;
				}
				else {
					a[i] = r[ri];
					i++;
					ri++;
				}
			}
			else {
				if (li >= l.length) {
					while (ri < r.length) {
						a[i] = r[ri];
						i++;
						ri++;
					}
				}
				if (ri >= r.length) {
					while (li < l.length) {
						a[i] = l[li];
						li++;
						i++;
					}
				}
			}
		}
	}
	//Bottom-up
	public static void sort(int[] array) {
        int[] workArray = new int[array.length];
        int chunkSize = 1;
        while (chunkSize < array.length) {
            int i = 0;
            while (i < array.length - chunkSize) {
                merge(array, i, chunkSize, workArray);
                i += chunkSize * 2;
            }
            chunkSize *= 2;
        }
    }

    public static void merge(int[] array, int leftPosition, int chunkSize, int[] workArray) {
        int rightPosition = leftPosition + chunkSize;
        int endPosition = Math.min(leftPosition + chunkSize * 2 - 1, array.length - 1);
        int leftIndex = leftPosition;
        int rightIndex = rightPosition;

        for (int i = 0; i <= endPosition - leftPosition; i++) {
            if (leftIndex < rightPosition &&
                    (rightIndex > endPosition ||
                    array[leftIndex] <= array[rightIndex])) {
                workArray[i] = array[leftIndex++];
            } else {
                workArray[i] = array[rightIndex++];
            }
        }

        for (int i = leftPosition; i <= endPosition; i++) {
            array[i] = workArray[i - leftPosition];
        }
    }
}

