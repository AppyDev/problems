package codingProblems;
import java.util.*;

public class StackWithMaxHeap {
	int top = -1;
	    int[] stack;

	    public StackWithMaxHeap(int size) {
	        stack = new int[size];
	    }

	    public void push(int v) {
	        if (top == stack.length - 1) {
	            System.out.println("Oveflow!!");
	            return;
	        }
	        stack[++top] = v;
	    }

	    public void pop() {
	        if (top < 0) {
	            System.out.println("Empty stack");
	            return;
	        }

	        stack[top] = 0;
	        top--;

	    }

	    public int getMax() {

	        int[] c = stack.clone();
	         // not a complete heap sort, but with below approach, i am trying bubble up.
	        // build the heap starting from n/2, as any nodes after n/2 are leaf(s)
	        for (int j = stack.length / 2; j >= 0; j--) {
	            buildMaxHeap(c, j, c.length - 1);
	        }

	        return c[0];
	    }

	    private void buildMaxHeap(int[] clone, int i, int j) {
	        int root = i;

	        while (root * 2 + 1 <= j) {
	            int c = root * 2 + 1;

	            if ((c + 1) <= j && clone[c] <= clone[c + 1]) {
	                c = c + 1;
	            }

	            if (clone[root] < clone[c]) {
	                int t = clone[root];
	                clone[root] = clone[c];
	                clone[c] = t;
	                root = c;
	            } else {
	                root++;
	            }
	        }

	    }

	    public void display() {
	        System.out.println("------------------------");
	        for (int i = top; i >= 0; i--) {
	            System.out.println(stack[i]);
	        }
	    }
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements in a stack:");
		int n= in.nextInt();
		System.out.println("Enter "+n+" elements of stack:");
		StackWithMaxHeap s =  new StackWithMaxHeap(n);
		for(int i=0;i<n;i++){
			s.push(in.nextInt());
		}
		System.out.println("Max:"+s.getMax());
		in.close();
	}
}
