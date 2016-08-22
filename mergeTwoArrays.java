package codingProblems;

public class mergeTwoArrays 
{
	public static void merge(int[] a, int[] b, int n, int m) {
		int k = m + n - 1; // Index of last location of array a
		int i = n - 1; // Index of last element in array b
		int j = m - 1; // Index of last element in array a

		// Start comparing from the last element and merge a and b
		while (i >= 0 && j >= 0) {
			if (a[i] > b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}
		while (j >= 0) {
			a[k--] = b[j--];
		}
	}
	public static void main(String args[])
	{
		int a[]={6,20};
		int b[]={5,9,12,13,15};
		merge(a,b,4,3);
		for(int i:a)
			System.out.print(i+" ");
	}
}
