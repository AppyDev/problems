package codingProblems;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramComparator implements Comparator<String>
{
	public int compare(String s1, String s2) 
	{
		return sortChars(s1).compareTo(sortChars(s2));
	}
	public String sortChars(String s) 
	{
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	public static void main(String[] args)
	{
	    String[] strArray = new String[]{"abets","mates","baste","meats", "betas","beast", "steam", "tames", "beats", "teams"}; 
	    sortArraysByAnagrams(strArray);
	    for(String str : strArray){
	        System.out.println(str);
	    }

	}
	private static void sortArraysByAnagrams(String[] strArray) 
	{
	    Arrays.sort(strArray, new AnagramComparator());
	}
}
