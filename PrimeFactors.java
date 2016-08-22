package codingProblems;

public class PrimeFactors 
{
	public static void getPrimeFact(int n)
	{
		// Print the number of 2s that divide n
	    while (n%2 == 0)
	    {
	    	System.out.print(" "+2);
	        n = n/2;
	    }
	 
	    // n is odd 
	    for (int i = 3; i <= Math.sqrt(n); i = i+2)
	    {
	        // While i divides n, print i and divide n
	        while (n%i == 0)
	        {
	        	System.out.print(" "+i);
	            n = n/i;
	        }
	    }
	 
	    // This condition is to handle the case when n is a prime number > 2
	    if (n > 2)
	        System.out.print(" "+n);
	}
	public static void main(String args[])
	{
		int n = 315;
		getPrimeFact(n);
	}
}

/*import java.util.*;

public class PrimeNumber
{
	public static void main(String args [])
	{
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		System.out.println("Please enter the first number");
		num1 = sc.nextInt();
		System.out.println("Please enter the Second number");
		num2 = sc.nextInt();
		System.out.println("Prime number: ");
		for (int i=num1; i <= num2; i++ ){
		int j;
		for (j=2; j<i; j++){
			int n = i%j;
			if (n==0){
			break;
			}
		}
		if(i == j){
			System.out.print(" "+i);
			}
		}
		System.out.println();
	}
}*/

