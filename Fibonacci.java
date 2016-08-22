package codingProblems;

public class Fibonacci 
{
	public static void main(String args[])
	{
		int n=15;
		System.out.println("Recursive:"+fiboRecursive(n));
		System.out.println("DP:"+fiboDP(n));
		System.out.println("DP:"+fiboMatrix(n));
	}
	//Recursive Fibo with exponential complexity 
	public static int fiboRecursive(int n)
	{
		if(n<=1)
			return n;
		return  fiboRecursive(n-1)+fiboRecursive(n-2);
	}
	//Dynamic Programming with complexity O(n)
	//space complexity can be reduced storing only last 2 elements
	public static int fiboDP(int n)
	{
		int[] fibo=new int[n+1];
		fibo[0]=0;
		fibo[1]=1;
		for(int i=2;i<=n;i++)
		{
			fibo[i]=fibo[i-1]+fibo[i-2];
		}
		return fibo[n];
	}
	//Using power of the matrix {{1,1},{1,0}} - optimized method
	//Complexity O(log n)
	public static int fiboMatrix(int n)
	{
		int[][] F={{1,1},{1,0}};
		if(n==0)
			return 0;
		power(F,n-1);		
		return F[0][0];
	}
	static void power(int[][]F, int n)
	{
		if(n==0 || n==1)
			return;
		int[][] M={{1,1},{1,0}};
		power(F,n/2);
		multiply(F, F);
		if (n%2 != 0)
	     multiply(F, M);
	}
	static void multiply(int[][]F,int[][]M)
	{
		int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
		int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
		int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
		int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];
		
		F[0][0] = x;
		F[0][1] = y;
		F[1][0] = z;
		F[1][1] = w;
	}
}
