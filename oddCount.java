/*find all numbers that occurred an odd-number of times in an array*/
package codingProblems;
import java.util.*;

public class oddCount {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter size of array:");
		int n = in.nextInt();
		System.out.println("Enter array elements:");
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();		
		for(int i=0; i<n ;i++){
			int val=in.nextInt();
			if(m.containsKey(val)){
				m.replace(val, m.get(val) + 1);
			}				
			else
				m.put(val, 1);
		}
		System.out.println("Number:Count");		
		Set<Integer> keys = m.keySet();  //get all keys
		for(Integer j: keys)
		{
		    if(m.get(j)%2 != 0)
		    	System.out.println(j+":"+m.get(j));
		}
		in.close();
	}
}
