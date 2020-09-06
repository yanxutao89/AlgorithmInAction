package others;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        int len = strs.length;
        if(strs == null || len == 0)
            return "";
        for(int i = 0; i < len; i++) {
            if (strs[i] == ""){
                return "";
            }
        }
        int index = 0;
        outer:
        while(true){
            int count = 0, i;
            for(i = 0; i < len - 1; i++){
                if(strs[i].charAt(index) == strs[i+1].charAt(index))
                    count++;
                else
                    break outer;
            }
            if(count == len - 1)
                sb.append(strs[i].charAt(index));
            index++;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String[] strs = {""};
        System.out.println(longestCommonPrefix(strs));
    }
}
