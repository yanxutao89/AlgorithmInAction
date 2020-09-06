package others;

/**
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */

public class ImplementStrStr {

	public static int strStr(String haystack, String needle) {

		if(needle == "") {
            return 0;
		}

        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, needle.length() + i).equals(needle)) {

                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){

        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack,needle));

    }
}
