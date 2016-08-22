package codingProblems;

public class ChangeBase 
{
	public static String intToAnybase(int number, int base)
	{
	    int quotient = number / base;
	    int remainder = number % base;

	    if(quotient == 0) // base case
	    {
	        return Integer.toString(remainder);      
	    }
	    else
	    {
	        return intToAnybase(quotient, base) + Integer.toString(remainder);
	    }            
	}
	public static int anyToInteger(String binary,int base)
	{
	    char[] numbers = binary.toCharArray();
	    int result = 0;
	    int count = 0;
	    for(int i=numbers.length-1;i>=0;i--)
	    {
	         result+=(int)Math.pow(base, count)*(int)(numbers[i]-'0');
	         count++;
	    }
	    return result;
	}
	public static String anyBaseToanyBase(int n, int from, int to)
	{
		int temp=anyToInteger(Integer.toString(n),from);
		return intToAnybase(temp,to);
	}
	public static void main(String args[])
	{
		System.out.println(anyBaseToanyBase(1010,2,9));
		//System.out.println(anyToInteger("121",3));
	}
}
