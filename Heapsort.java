package codingProblems;

public class Heapsort {
	private static <T extends Comparable<T>> void sort(T[] arr)
	{
		int heapsize=arr.length;
		buildHeap(arr, heapsize);
		while(heapsize>1)
		{
			swap(arr, 0, heapsize-1);
			heapsize--;
			heapify(arr, heapsize, 0);
		}
	}
	private static <T extends Comparable<T>> void buildHeap(T[] arr, int heapsize)
	{
		for (int i = (int)(arr.length / 2); i >= 0; i--)
		{
			heapify(arr, heapsize, i);
		}
	}
	private static <T extends Comparable<T>> void heapify(T[] arr, int heapsize, int i)
	{
		int left=i*2+1;
		int right=i*2+2;
		int maxVal;
		if(left<heapsize && arr[left].compareTo(arr[i])>0)
			maxVal=left;
		else
			maxVal=i;
		if(right<heapsize && arr[right].compareTo(arr[maxVal])>0)
			maxVal=right;
		if(maxVal != i)
		{
			swap(arr, i, maxVal);
			heapify(arr, heapsize, maxVal);
		}
	}
	private static <T extends Comparable<T>> void swap(T[] arr, int i, int j)
	{
		T temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void main(String args[])
	{
		Integer[] arr={5,2,6,9,3};
		sort(arr);
		for(Integer i:arr)
			System.out.print(i+" ");
	}
}
