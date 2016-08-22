/*
 * Find all the pairs of numbers from a list that sums to a particular number.
 */
package codingProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SumPairs 
{
	public static void main(String args[])
	{
		List<Integer> list=new ArrayList<Integer>();
		Scanner in =new Scanner(System.in);
		int sum = 16;
		/*while(in.hasNext())
			list.add(in.nextInt());*/
		list.add(1);list.add(16);list.add(45);list.add(8);list.add(10);list.add(8);list.add(6);list.add(0);
		in.close();
		findSumPairs(list, sum);
	}
	public static void findSumPairs(List<Integer> list, int sum) 
	{
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(Integer i:list)
		{
			Integer tempSum=(Integer)sum-i;
			if(tempSum<0)
				tempSum=i;
			if(map.containsKey(tempSum))
			{
				System.out.println("Pair:("+i+","+i+")");
			}
			else if(!map.containsKey(tempSum))
			{
				map.put(tempSum, i);
				if(map.containsKey(i)&&i<=sum)
				{
					System.out.println("Pair:("+i+","+(sum-i)+")");
				}
			}
		}
	}
}
