package codingProblems;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class wordFrequency {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s;
    HashMap<Character,Integer> map=new HashMap<Character,Integer>();
    while ((s = in.readLine()) != null) {
      char[] ar = s.toCharArray();
      Arrays.sort(ar);
      Integer count=0;
      for(int i=0;i<ar.length;i++){
    	  if(!map.containsKey(ar[i]))
    		  count = 1;
    	  else
    		  count=count+1;
    	  map.put(ar[i], count);
      }
      Map<Character,Integer> sortedMap = new TreeMap<Character,Integer>(map);
      String output="";
      for( Character key : sortedMap.keySet() ) {
    	    output=output+key;
    	    output=output+sortedMap.get(key);
    	}
      System.out.println(output);
    }
  }
}
