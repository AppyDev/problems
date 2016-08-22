package codingProblems;

public class CoinWinner {
	static int max(int a, int b)  {    return a > b ? a : b;  }
	static int min(int a, int b)  {    return a < b ? a : b;  }
	static int optimalStrategyOfGame(int arr[], int n)
	{
	    // Create a table to store solutions of subproblems
	    int gap, i, j, x, y, z;
	    int table[][] = new int[n][n];
	 
	    // Fill table using above recursive formula. Note that the table
	    // is filled in diagonal fashion (similar to http://goo.gl/PQqoS),
	    // from diagonal elements to table[0][n-1] which is the result.
	    for (gap = 0; gap < n; ++gap)
	    {
	        for (i = 0, j = gap; j < n; ++i, ++j)
	        {
	            // Here x is value of F(i+2, j), y is F(i+1, j-1) and
	            // z is F(i, j-2) in above recursive formula
	            x = ((i+2) <= j) ? table[i+2][j] : 0;
	            y = ((i+1) <= (j-1)) ? table[i+1][j-1] : 0;
	            z = (i <= (j-2))? table[i][j-2]: 0;
	 
	            table[i][j] = max(arr[i] + min(x, y), arr[j] + min(y, z));
	        }
	    }
	 
	    return table[0][n-1];
	}
	public static void main(String[] args)
	{
	    int arr1[] = {8, 15, 3, 7};
	    int n = arr1.length;
	    System.out.println(optimalStrategyOfGame(arr1, n));
	 
	    int arr2[] = {2, 2, 2, 2};
	    n = arr2.length;
	    System.out.println( optimalStrategyOfGame(arr2, n));
	 
	    int arr3[] = {20, 30, 2, 2, 2, 10};
	    n = arr3.length;
	    System.out.println( optimalStrategyOfGame(arr3, n));

	}
}
