/*
 * Make a function to test whether a binary number/string is a palindrome.
 */

package codingProblems;

public class PalindromeString 
{
	public static boolean isPalin(String text)
	{
		String reverse = reverse(text);
		if(text.equalsIgnoreCase(reverse))
		{
			return true;
		}     
		return false;
	}
	//recursive function
	public static String reverse(String input)
	{
		if(input == null || input.isEmpty())
		{
			return input;
		}       
		return input.charAt(input.length()-1)+reverse(input.substring(0, input.length()-1));
	}
	
	//ierative
	public static boolean isPalindrome(String x)
	{
		int l = 0; // Initialize left position
		int r = x.length()-1; // initialize right position
		char[] c=x.toCharArray();
		
		// One by one compare bits
		while (l < r)
		{
			if (c[l] != c[r])
				return false;
			l++;     
			r--;
		}
		return true;
	}
	public static void main(String args[]) 
	{
		System.out.println("abba:" + isPalin("abba"));
		System.out.println("abcd:" + isPalin("abcd")); 
		System.out.println("abba:" + isPalindrome("1010"));
		System.out.println("abcd:" + isPalindrome("11")); 
	}	
}
