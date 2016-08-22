package codingProblems;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class StringManipulation {
	public static void main(String args[])
	{
		StringManipulation s = new StringManipulation();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str = in.nextLine();
		s.reverseString1(str);
		s.reverseString2(str);
		System.out.println("Reversed string by method 3:\n"+s.recursiveReverseString(str));
		String[] strArray = str.split(" ");
		System.out.println("Reversed string by method 4:");
		for(String st:strArray)
			System.out.print(s.reverseRecursiveDivide(st)+" ");
		in.close();
	}
	public void reverseString1(String str)
	{
		char[] strArr = str.toCharArray();
		String reverseString = "";
		for(int i=strArr.length-1;i>=0;i--)
		{
			reverseString = reverseString+strArr[i];
		}
		System.out.println("Reversed string by method 1:\n"+reverseString);
	}
	public void reverseString2(String str)
	{
		char[] strArr=str.toCharArray();
		List<Character> trial1= new LinkedList<>();
		for(char c: strArr)
			trial1.add(c);
		Collections.reverse(trial1);
		ListIterator<Character> li = trial1.listIterator();  
		System.out.println("Reversed string by method 2:");
		while(li.hasNext())
			System.out.print(li.next());  
		System.out.println();
	}
	String reverse="";
	public String recursiveReverseString(String str)
	{
        if(str.length() == 1)
        {
            return str;
        } 
        else 
        {
            reverse += str.charAt(str.length()-1)
                    +recursiveReverseString(str.substring(0,str.length()-1));
            return reverse;
        }
    }
	public String reverseRecursiveDivide(String str) 
	{
		if (str.length() <= 1) {
			return str;
		}
		return reverseRecursiveDivide(str.substring(str.length() / 2, str.length())) + 
				reverseRecursiveDivide(str.substring(0, str.length() / 2));
	}
}
