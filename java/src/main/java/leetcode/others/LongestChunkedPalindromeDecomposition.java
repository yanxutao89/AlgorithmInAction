package others;

/*Return the largest possible k such that there exists a_1, a_2, ..., a_k such that:

Each a_i is a non-empty string;
Their concatenation a_1 + a_2 + ... + a_k is equal to text;
For all 1 <= i <= k,  a_i = a_{k+1 - i}.


Example 1:

Input: text = "ghiabcdefhelloadamhelloabcdefghi"
Output: 7
Explanation: We can split the string on "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)".
Example 2:

Input: text = "merchant"
Output: 1
Explanation: We can split the string on "(merchant)".
Example 3:

Input: text = "antaprezatepzapreanta"
Output: 11
Explanation: We can split the string on "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)".
Example 4:

Input: text = "aaa"
Output: 3
Explanation: We can split the string on "(a)(a)(a)".


Constraints:

text consists only of lowercase English characters.
1 <= text.length <= 1000*/
public class LongestChunkedPalindromeDecomposition {

	/*
	 * Runtime: 1 ms, faster than 90.07% of Java online submissions for Longest Chunked Palindrome Decomposition.
	 * Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for Longest Chunked Palindrome Decomposition.
	 */
	public int longestDecomposition(String text) {

		int len = text.length();
        int i = len - 1;
        int j = 0;
        int ans = 0;
        int lastSuccessIndex = -1;
        boolean evenCase = false;
        for( ; i >= 0 && j < i;){
        	if(text.charAt(i) == text.charAt(j)){
	            int k = i;
	            int m = j;
	            while(k >= 0 && m > lastSuccessIndex && text.charAt(k) == text.charAt(m)){
	            	k--;
	            	m--;
	            }
	            if(m == lastSuccessIndex){
	            	i = k;
	            	ans += 2;
	            	lastSuccessIndex = j;
	            	j++;
	            	if(i < j){
	            		evenCase = true;
	            	}
	            }else{
	            	j++;
	            }
        	}else{
        		j++;
        	}
        }
        return evenCase ? ans : ans + 1;

	}

	public static void main(String[] args) {

		String text = "ghiabcdefhelloadamhelloabcdefghi";

		System.out.println(new LongestChunkedPalindromeDecomposition().longestDecomposition(text));
	}
}
