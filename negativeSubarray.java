/*
 * You are given an array of nn integers. A sub-array is "Negative" if sum of all the 
 * integers in that sub-array is negative. Count the number of "Negative sub-arrays" 
 * in the input array.

	Note: Subarrays are contiguous chunks of the main array. 
	For example if the array is {1,2,3,5} then some of the subarrays are 
	{1}, {1,2,3}, {2,3,5}, {1,2,3,5} etc. But {1,2,5} is not an subarray as it is not contiguous.
 */
package codingProblems;

import java.util.*;

public class negativeSubarray {
	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in= new Scanner(System.in);
		System.out.println("Enter length of array:");
		int n=in.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter "+n+"array elements:");
		for(int i=0;i<n;i++)
			arr[i]=in.nextInt();
		findSubarray(arr,n);
		in.close();
	}
	public static void findSubarray(int[]arr, int n)
	{
		for(int i=0;i<n-1;i++)   {
			int sum=arr[i];
			if(sum<0)
				System.out.println("["+i+":"+i+"]");
			for(int j=i+1;j<=n;j++){
				sum=sum+arr[j];
				if(sum < 0){
					System.out.println("["+i+":"+j+"]");
				}
			}
		}          
	}
}
