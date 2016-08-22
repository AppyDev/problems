package codingProblems;

public class InsertionSort {
	public static void sort(Integer  a[])
	{
		for(int i=1; i<a.length;i++)
		{
			int temp=a[i];
			int j;
			for(j=i-1;(j>=0&&temp<a[j]);j--)
			{
				a[j+1]=a[j];
				a[j]=temp;
			}
		}
	}
	public static <T extends Comparable<T>> void sortWithComparable(T[] array) 
	{
        for (int i = 1; i < array.length; i++) 
        {
            T item = array[i];
            int index = i;
            while (index > 0 && array[index - 1].compareTo(item) > 0) 
            {
                array[index] = array[--index];
            }
            array[index] = item;
        }
    }
	public static void main(String args[])
	{
		Character[] arr={'c','f','a','t','g'};
		sortWithComparable(arr);
		for(Character i:arr)
		{
			System.out.print(i+" ");
		}
	}
}
