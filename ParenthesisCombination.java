package codingProblems;

import java.util.Scanner;

public class ParenthesisCombination 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number of parenthesis:");
		printPar(in.nextInt());
		in.close();
	}
	public static void printPar(int l, int r, char[] str, int count)
	{
		if(l<0 || r<l)
			return;		//Error
		if(l==0 && r==0)
			System.out.println(str);		//base case
		else
		{
			if(l>0)
			{
				str[count]='(';
				printPar(l-1, r, str, count+1);
			}
			if(r>0)
			{
				str[count]=')';
				printPar(l, r-1, str, count+1);
			}
		}
	}
	public static void printPar(int count)
	{
		char[] str = new char[count*2];
		printPar(count, count, str, 0);
	}
}
