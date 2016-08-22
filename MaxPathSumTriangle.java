package codingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPathSumTriangle 
{
	private static Map<Integer,List<Integer>> triangle = new HashMap<Integer,List<Integer>>();
	private static List<Integer> path = new ArrayList<Integer>();

	public static void main(String args[])
	{
		_init();
		int res = maxSum(triangle);
		System.out.println("Sum = "+res);
		printPath();
	}
	public static void printPath()
	{
		for(Integer key : triangle.keySet())
		{
			Integer max=Integer.MIN_VALUE;
			for(Integer key1: triangle.get(key))
			{
				if(key1.intValue()>max)
					max=key1.intValue();
			}
			path.add(max);
		}
		for(int i=0;i<path.size()-1;i++)
		{
			int a=path.get(i);
			int b=path.get(i+1);
			path.set(i, a-b);
		}
		System.out.println("Maximum Path: "+path);
	}

	//max sum from top to bottom of right angled triangle
	public static int maxSum(Map<Integer,List<Integer>> triangle)
	{
		if(triangle == null || triangle.isEmpty())
			return 0;
		int size = triangle.size();
		if(size == 1)
			return triangle.get(0).get(0);
		int i=size-2,tmp,tmp_max,max_value;
		while(i>=0)
		{
			List<Integer> current_row = new ArrayList<Integer>();
			current_row = triangle.get(i);
			for(int index=0; index<current_row.size(); index++)
			{
				tmp = current_row.get(index);
				tmp_max = tmp+triangle.get(i+1).get(index);
				max_value = tmp+triangle.get(i+1).get(index+1);
				if(tmp_max > max_value)
					max_value = tmp_max;
				current_row.set(index,max_value);
			}
			triangle.put(i,current_row);
			current_row = null;
			i--;

		}
		return triangle.get(0).get(0);
	}

	private static void _init()
	{
		List<List<Integer>> tuples = new ArrayList<List<Integer>>();
		tuples.add(Arrays.asList(2));
		tuples.add(Arrays.asList(3,4));
		tuples.add(Arrays.asList(6,5,7));
		tuples.add(Arrays.asList(4,1,8,3));
		int i=0;
		for(List<Integer> tuple : tuples)
		{
			triangle.put(i++,tuple);
		}
		//print
		for(Integer key : triangle.keySet())
		{
			System.out.println(triangle.get(key));
		}
	}
}
