package codingProblems;

/**
 * Find Kth Largest element in an unsorted array using Max-Heap 
 * 1) Build a Max Heap tree in O(n)
 * 2) Use Extract Max k times to get kth maximum element. O(klogn)
 * Time complexity: O(n + klogn)
 */
public class MaxHeap 
{

	int[] a;
	int size;
	int n;
	
	public int getVal( int pos ) 
	{		
		return a[pos];
	}
		
	
	public MaxHeap( int size, int[] e ) 
	{
		this.size = size;
		a = new int[size];
		createHeap(e);
	}
	
	public int parent( int pos ) 
	{
		return (pos-1)/2;
	}
	
	public void createHeap( int[] e ) 
	{
		for( int val : e ) {
			int curr = n++;
			a[curr] = val;
			while( curr != 0 && a[curr] > a[parent(curr)]) {
				int t = a[curr];
				a[curr] = a[parent(curr)];
				a[parent(curr)] = t;
				curr = parent(curr);
			}
		}
	}
	
	public int getMax() 
	{
		int max = a[0];
		a[0] = a[n-1];
		a[n-1] = 0;
		n--;
		int pos = 0;
		while( !leaf(pos) && ( a[pos] < a[left(pos)]) || a[pos] < a[right(pos)]) {
			if( a[left(pos)] > a[right(pos)]) {
				int t = a[pos];
				a[pos] = a[left(pos)];
				a[left(pos)] = t;
				pos = left(pos);
			} else {
				int t = a[pos];
				a[pos] = a[right(pos)];
				a[right(pos)] = t;
				pos = right(pos);
			}
		}
		return max;
	}
	
	public int getMax( int k ) 
	{
		int max = 0;
		for( int i=0; i < k; i++ ) 
		{
			max = getMax();
		}
		return max;
	}
	
	public boolean leaf( int pos ) 
	{
		return pos >= n/2;
	}
	
	public int left( int pos ) 
	{
		return (2*pos + 1);
	}
	
	public int right( int pos ) 
	{
		return (2*pos + 2);
	}
	
	public static void main(String[] args) 
	{
		int[] a = {88, 30, 11, 17, 22, 16, 39, 8, 31, 55, 29, 63, 77, 69, 99, 90, 81, 2, 20, 53, 62, 5, 33, 44, 6};
		int k = 5;
		MaxHeap heap = new MaxHeap(50, a);
		int res = heap.getMax( k );
		System.out.println(k +"th maximum element from end is : " +res);
	}
}
