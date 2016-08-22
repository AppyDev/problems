package codingProblems;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
        for(int i=1; i<=numRows; i++){
            List<Integer> pascalRow = new ArrayList<Integer>();
            for(int j=1; j<=i;j++){
                if(j==1 || j==i){
                    pascalRow.add(1);
                }
                else{
                	//System.out.println(pascalTriangle.get(i-2).size());
                	for(int k=j-2; k < j-1; k++)
            			{
            				pascalRow.add((pascalTriangle.get(i-2).get(k)+
            				pascalTriangle.get(i-2).get(k+1)));
            			}  
                }
            }
            pascalTriangle.add(pascalRow);
        }
        return pascalTriangle;
    }
    public static void main(String args[]){
    	PascalTriangle l = new PascalTriangle();
    	List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
    	pascalTriangle = l.generate(5);
    	System.out.print("[\n");		
    	for(List<Integer> csv : pascalTriangle)
    	{
    		//dumb logic to place the commas correctly
    		if(!csv.isEmpty())
    		{
    			System.out.print("["+csv.get(0));
    			for(int i=1; i < csv.size(); i++)
    			{
    				System.out.print("," + csv.get(i));
    			}
    			System.out.print("]");
    		}
    		System.out.print("\n");
    	}
    	System.out.print("]");
    }	
}
