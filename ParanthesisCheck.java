package codingProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
public class ParanthesisCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Please Enter Your String");
        String s=in.nextLine();
		System.out.println(checkParan(s));
		in.close();
	}
	public static boolean checkParan(String s){
		Stack<Character> st=new Stack<Character>();
		boolean ans=false;
		Character[] openParan={'(','[','{'};
		Character[] closeParan={')',']','}'};
		List<Character> openParList = Arrays.asList(openParan);
		List<Character> closeParList = Arrays.asList(closeParan); 
		if(s==null){
			return ans;
		}	
		else if(s.length()==0){
			ans=true;
			return ans;
		}
		else{
			for(int i=0;i<s.length();i++){
				char temp=s.charAt(i);
				if(openParList.contains(temp)){
					st.push(temp);
				}	
				else if(closeParList.contains(temp)){
					if(!st.empty()){
						if(st.peek()!='(' && temp==')'){
							return ans;
						}
						else if(st.peek()!='[' && temp==']'){
							return ans;
						}
						else if(st.peek()!='{' && temp=='}'){
							return ans;
						}
						else 
							st.pop();
					}
					else
						return ans;
				}
				else
					return ans;
			}
			if( st.empty()){
	            ans = true;
	            return ans;
	        }else{
	            return ans;
	        }
		}
	}	
}
