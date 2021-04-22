package others;

/*
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.



Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"*/

public class ToLowerCase {


	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for To Lower Case.
	 * Memory Usage: 34.3 MB, less than 98.70% of Java online submissions for To Lower Case.
	 */
    public static String toLowerCase(String str) {

    	return str.toLowerCase();
    }


	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for To Lower Case.
	 * Memory Usage: 34 MB, less than 98.70% of Java online submissions for To Lower Case.
	 */
    public static String toLowerCase2(String str) {

    	StringBuffer sb = new StringBuffer();

    	for(int i = 0; i < str.length(); i++) {

    		sb.append(toLower(str.charAt(i)));
    	}

    	return sb.toString();
    }

    private static char toLower(char c) {

    	int i = (byte)c;

    	if(i > 96 && i < 124) {

    		return c;
    	}

    	if(i > 64 && i < 92) {

    		return (char)(i + 32);
    	}

    	return c;
	}

    private static char toUpper(char c) {

    	int i = (byte)c;

    	if(i > 96 && i < 124) {

    		return (char)(i - 32);
    	}

    	if(i > 64 && i < 92) {

    		return c;
    	}

    	return c;
	}

    public static String toLowerCase3(String str) {

    	StringBuffer sb = new StringBuffer();

    	for(int i = 0; i < str.length(); i++) {

    		int num = (int)str.charAt(i);
    		int binary = 0b01100000;
    		int res = num | binary;
    		sb.append((char)res);
    	}

    	return sb.toString();
    }

	public static void main(String[] args) {

    	System.out.println((byte)'A');
       	System.out.println((byte)'a');
    	System.out.println(toLowerCase2("AA"));
    	System.out.println(new ToLowerCase().toLowerCase3("AAbbc"));
    }


}
