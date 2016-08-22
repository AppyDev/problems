package codingProblems;

public class Factors
{  
	public static void main(String[] args) 
	{  
		int input;  
		System.out.println("You entered: " + args[0]);  
		input = Integer.parseInt(args[0]);  
		printFactors(input, "");  
	}  

	static void printFactors(int n, String p) {  
		int start = 1;  

		while (start <= Math.sqrt(n)) {  
			if (n % start == 0) {  
				System.out.println((n / start) + "x" + start + p);  
				
				if (!isPrime(start)) {  
					factorIt(n / start, start);  
				}  
			}  
			start++;  
		}  
	}  

	static void factorIt(int original, int n) {  
		int start = 1;  

		while (((n / start) != 1) && (n % start == 0)) {  

			if (!(start == 1))  
				System.out.println("*" + original + "x" + (n / start) + "x" + start);  

			if (!isPrime(original)) {  
				printFactors(original, "x" + (n / start) + "x" + start);  
			}  

			start++;  
		}  
	}  

	static boolean isPrime(int n) {  
		if (n == 2) {  
			return true;  
		}  
		if (n % 2 == 0) {  
			return false;  
		}  
		for (int i = 3; i * i <= n; i += 2) {  
			if (n % i == 0) {  
				return false;  
			}  
		}  
		return true;  
	}  
}