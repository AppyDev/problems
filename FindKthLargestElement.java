package codingProblems;

import java.util.Arrays;

public class FindKthLargestElement 
{
	
	//method 1: using simple sorting (nlgn)
	public static int findKthLargest1(int[] nums, int k) 
	{
	    Arrays.sort(nums);
	    return nums[nums.length-k];
	}
	
	//method 2 - Qickselect (n or n^2)
	public static int findKthLargest2(int[] nums, int k) 
	{
		if (k < 1 || nums == null) 
		{
			return 0;
		}
	 
		return getKth(nums.length - k +1, nums, 0, nums.length - 1);
	}
	 
	public static int getKth(int k, int[] nums, int start, int end) {
	 
		int pivot = nums[end];
	 
		int left = start;
		int right = end;
	 
		while (true) {
	 
			while (nums[left] < pivot && left < right) {
				left++;
			}
	 
			while (nums[right] >= pivot && right > left) {
				right--;
			}
	 
			if (left == right) {
				break;
			}
	 
			swap(nums, left, right);
		}
	 
		swap(nums, left, end);
	 
		if (k == left + 1) 
		{
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}
	 
	public static void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
	
	//method 3: using maxHeap (less than nlgn)
	public static int findKthLargest3(int[] arr, int k) throws Exception 
	{
	    //parameter check
	    assert (arr != null && arr.length > 0 && k > 0 && k <= arr.length);
	    MaxHeap heap = new MaxHeap(50, arr);
	    return heap.getMax( k );
	}
	public static void main(String[] args) throws Exception 
	{
	    System.out.println("Method 1: "+findKthLargest1(new int[]{3,2,1,5,6,4}, 1));
	    System.out.println("Method 2: "+findKthLargest2(new int[]{3,2,1,5,6,4}, 1));
	    System.out.println("Method 3: "+findKthLargest3(new int[]{3,2,1,5,6,4}, 1));
	}
}
