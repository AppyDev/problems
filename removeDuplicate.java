package codingProblems;
public class removeDuplicate {
	/* Name of the class has to be "Main" only if the class is public. */
	static String removeDuplicates(String word) {
	    String result = new String("");

	    for (int i = 0; i < word.length(); i++) {
	        if (!result.contains("" + word.charAt(i))) {
	            result += "" + word.charAt(i);
	        }
	    }
	    return result;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(removeDuplicates("gtghvrtdtf"));
	}
}

