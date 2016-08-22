/*write a function that takes in an int and returns a string that would be how one would 
 * say that number (ex: 123 -> one hundred twenty three; 50019 -> five thousand nineteen)
*/
package codingProblems;
import java.util.Scanner;
public class digitToWord { 
    public void pw(int n,String ch) 
    { 
        String one[]={" ","one ","two ","three ","four ","five ",
                "six ","seven ","eight ","nine ","ten ","eleven ","twelve ",
                        "thirteen ","fourteen ","fifteen ","sixteen ","seventeen ","eighteen ","nineteen "}; 

        String ten[]={" "," ","twenty ","thirty ","forty ","fifty ","sixty ","seventy ","eighty ","ninety "};   
        if(n>19) 
            System.out.print(ten[n/10]+one[n%10]);
        else  
        {
        	if(one[n]!=" ")
        		System.out.print(one[n]);
        }
        if(n>0)
        	System.out.print(ch); 
    } 

    public static void main(String[] args) {
        int n=0; 
        Scanner in = new Scanner(System.in); 
        System.out.println("Enter an integer number: "); 
        n = in.nextInt();

        if(n<=0) 
            System.out.println("Enter numbers greater than 0"); 
        else { 
        	digitToWord a = new digitToWord(); 
            a.pw((n/1000000)%100,"million ");
            a.pw(((n/10000)%100),"lakh "); 
            a.pw(((n/1000)%100),"thousand "); 
            a.pw(((n/100)%10),"hundred "); 
            a.pw((n%100)," "); 
        }
        in.close();
    }

}