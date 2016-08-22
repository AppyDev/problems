package codingProblems;

import java.util.Stack;

public class MaxOfStack 
{
	// objective here is to keep track of maximum value in a stack of integers
	// create another Stack which will keep track of maximum
	Stack<Integer> main = new Stack<>();
	Stack<Integer> max = new Stack<>();

	public void insert(int x) 
	{
		if (main.isEmpty()) 
		{ // if stack is empty, insert the number in both stacks
			main.add(x);
			max.add(x);
		} 
		else 
		{
			// check if number in Stack(track) is bigger than x
			// which ever is bigger, insert it into Stack
			int a = max.peek();
			max.add(Math.max(a, x));
			main.add(x); // insert it into main stack.
		}
	}

	public int remove() 
	{
		if (!main.isEmpty()) 
		{ // pop the top elements
			max.pop();
			return main.pop();
		}
		return 0;
	}

	public int getMax() 
	{
		return max.peek();
	}

	public static void main(String[] args) 
	{
		MaxOfStack i = new MaxOfStack();
		i.insert(44);
		i.insert(12);
		i.insert(55);
		i.insert(1);
		i.insert(65);
		System.out.println("Max Element is " + i.getMax());
		System.out.println("Removing Element " + i.remove());
		System.out.println("Max Element is " + i.getMax());
	}
}
