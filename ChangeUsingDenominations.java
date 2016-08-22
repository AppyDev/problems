package codingProblems;

public class ChangeUsingDenominations 
{
	public static void main(String[] args) 
	{
		int N = 5;
		int[] coins = {25,10,5,1}; //in sorted order
		System.out.println(GetCombinations(N, coins, 0));
	}
	public static int GetCombinations(int N, int[] coins, int idx)
	{
		if(idx == (coins.length-1)) return 1;  
		int result = 0;
		for(int i=0; (i * coins[idx]) <= N; i++)
		{
			result += GetCombinations(N - (i * coins[idx]), coins, (idx + 1));
		}
		return result;
	}
}
