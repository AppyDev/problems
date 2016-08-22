/*Given a sorted array, arr[] and a value, x, find floor of x in given array. 
Floor of x is the largest element in arr[] such that the element is smaller than or equal to x. 
If floor exists, then return index of it, else return -1.*/

package codingProblems;

import java.util.*;

public class MissingElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter input:");
		int testCases = in.nextInt();
		for(int i=0; i<testCases; i++){
		    int arrSize = in.nextInt();
		    int x = in.nextInt();
		    int arr[] = new int[arrSize];
		    for(int j=0;j<arrSize;j++){
		    	arr[j]=in.nextInt();
		    }
		    System.out.println(GFG(arr, x));
		    //System.out.println(testCases);
		}
		in.close();
	}
	public static int GFG(int[] arr, int x){
		for(int i=0; i<arr.length-1;i++){
			if(arr[i]>x)
				return -1;
			else if(arr[i+1]>x){
				return i;
			}
		}
		return -1;
	}

}
