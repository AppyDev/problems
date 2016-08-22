package codingProblems;
import java.util.Scanner;

public class IntManipulation 
{
	//Check prime number 
	public static boolean isPrimeNumber(int number) 
	{
		if (number == 2 || number == 3) 
		{
			return true;
		}
		if (number % 2 == 0) {
			return false;
		}
		int sqrt = (int) Math.sqrt(number);
		for (int i = 3; i <= sqrt; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	//convert float to binary (3.72)
	public static String printBinary(String n) 
	{
		int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
		double decPart = Double.parseDouble(n.substring(n.indexOf('.'), n.length()));
		String int_string = "";
		while (intPart > 0) {
			int r = intPart % 2;
			intPart >>= 1;
			int_string = r + int_string;
		}
		StringBuffer dec_string = new StringBuffer();
		while (decPart > 0) {
			if (dec_string.length() > 32) 
				break;
			if (decPart == 1) {
				dec_string.append((int)decPart);
				break;
			}
			double r = decPart * 2;
			if (r >= 1) {
				dec_string.append(1);
				decPart = r - 1;
			} else {
				dec_string.append(0);
				decPart = r;
			}
		}
		return int_string + "." + dec_string.toString();
	}
	//number of bit required to convert from a to b
	public static int bitSwapRequired(int a, int b) 
	{
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}
		return count;
	}
	//swap odd and even bits
	public static int swapOddEvenBits(int x) 
	{
		return ( ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1) );
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number to check prime:");
		int n=in.nextInt();
		System.out.println(n+" is Prime:"+isPrimeNumber(n));
		/*System.out.println("Enter float:");
		String d=in.next();
		System.out.println("Binary representation:"+printBinary(d));
		System.out.println("Enter 2 numbers:");
		int a=in.nextInt();
		int b=in.nextInt();
		System.out.println("Number of bits required:"+bitSwapRequired(a,b));*/
		in.close();
	}
}
