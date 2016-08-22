/* All permutations of a given String
 * This algorithm taken O(n!) time since there are n! permutations possible */

package codingProblems;
import java.util.ArrayList;
import java.util.Scanner;

public class AllPermutationsOfString 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string to find permutations:");
		System.out.println("All permutations:"+getPerm(in.next()));
		in.close();
	}
	public static ArrayList<String> getPerm(String s)
	{
		ArrayList<String> perm = new ArrayList<String>();
		if (s==null)
			return null; //Error condition
		else if(s.length() == 0) //base case
		{
			perm.add("");
			return perm;
		}

		char c=s.charAt(0);
		String remainder = s.substring(1);
		ArrayList<String> words= getPerm(remainder);
		for(String word:words)
		{
			for(int i=0;i<= word.length();i++)
			{
				perm.add(insertCharAt(word, c, i));
			}
		}
		return perm;
	}
	public static String insertCharAt(String s, char c, int i)
	{
		String a=s.substring(0,i);
		String b=s.substring(i);
		return a+c+b;
	}              
}
