package others;

/*Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".


Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Note:

The input string length won't exceed 1000.
*/
public class PalindromicSubstrings {

	/*
	 * Runtime: 160 ms, faster than 5.05% of Java online submissions for Palindromic Substrings.
	 * Memory Usage: 36.2 MB, less than 45.57% of Java online submissions for Palindromic Substrings.
	 */
	public int countSubstrings(String s) {

		int res = s.length();

		for(int i = 0; i < s.length() - 1; i++) {
			for(int j = i + 1; j < s.length(); j++) {

				String string = s.substring(i, j + 1);
				if(isPalindromic(string)) {

					res++;
				}
			}
		}

		return res;
    }

	private boolean isPalindromic(String string) {

		int start = 0, end = string.length() - 1;

		while(start < end) {

			if(string.charAt(start) == string.charAt(end)) {
				start++;
				end--;
			} else {

				return false;
			}
		}

		return true;
	}

	/*
	 * Runtime: 6 ms, faster than 37.78% of Java online submissions for Palindromic Substrings.
	 * Memory Usage: 36.1 MB, less than 45.57% of Java online submissions for Palindromic Substrings.
	 */
	public int countSubstrings2(String s) {

		if(s.isEmpty()){
            return 0;
        }
        int count = 0;

        boolean[][] isPalin = new boolean[s.length()][s.length()];

        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(j == i){
                    isPalin[i][j] = true;
                } else if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 2){
                        isPalin[i][j] = true;
                    }else{
                        if(isPalin[i + 1][j - 1]){
                            isPalin[i][j] = true;
                        }
                    }
                }
                if(isPalin[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

	public static void main(String[] args) {

		String s = "aaa";
		System.out.println(new PalindromicSubstrings().countSubstrings(s));
	}
}
