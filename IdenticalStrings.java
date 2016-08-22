package codingProblems;

import java.util.Scanner;
public class IdenticalStrings {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String a=in.nextLine();
		String b=in.nextLine();
		System.out.println("Given 2 strings have identical characters?"+identicalChar(a,b));
		in.close();
	}
	public static boolean identicalChar(String a,String b){
		if(a.length() != b.length())
			return false;
		
		int[] letters=new int[128];
		char[] a_array=a.toCharArray();
		for(char c:a_array){
			letters[c]++;
		}
		char[] b_array=b.toCharArray();
		for(char c:b_array){
			letters[c]--;
			if(letters[c]<0)
				return false;
		}
		return true;
	}
}
