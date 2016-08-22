package codingProblems;

import java.util.Scanner;
import java.util.ArrayList;

public class Recursion {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		boolean loopFlag=true;
		while(loopFlag)
		{
			System.out.println("Enter n to get nth fibonacci number:");
			int n=in.nextInt();
			System.out.println(n+"th fibonacci number is: "+fibonacci(n));
			System.out.println("Do your want to continue: y/n");
			char c=in.next().charAt(0);
			switch(c)
			{
				case('y'):{loopFlag=true;break;}
				case('n'):{loopFlag=false;break;}
			}
		}
		System.out.println("****Subsets of set****");
		System.out.println("Enter number of elements in a set:");
		int n=in.nextInt();
		System.out.println("Enter "+n+" elements in a set:");
		ArrayList<Integer> arr =  new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			arr.add(in.nextInt());
		}
		in.close();
		System.out.println("Sets are:\n"+getSubsets(arr, 0));
	}
	public static int fibonacci(int n)
	{
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else if(n>1)
			return fibonacci(n-1)+fibonacci(n-2);
		else
			return -1;
	}
	public static int iterativeFibo(int n) 
	{
		if (n < 0) return -1; // Error condition.
		if (n == 0) return 0;
		int a = 1, b = 1;
		for (int i = 3; i <= n; i++) 
		{
			int c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set,
			int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // Empty set
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets =
					new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset); //
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
}
