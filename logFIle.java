package codingProblems;
import java.io.*;
import java.util.*;

public class logFIle {
	public static void main(String[] args) throws IOException {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("ENter log");
	    HashMap<String, List<String>> dictMap = new HashMap<String, List<String>>();
	    String user;
	    List<String> page=new ArrayList<String>();
	    String s;
	    while ((s = in.readLine()) != null) {
	        user = Arrays.asList(s.split(",")).get(0);System.out.println(user);
	        page.add(Arrays.asList(s.split(",")).get(1));System.out.println(page);
	        dictMap.put(user, page);
	      }
	    
	  }
}
