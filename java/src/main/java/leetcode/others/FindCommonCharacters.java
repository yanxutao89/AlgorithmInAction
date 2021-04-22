package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.



Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]


Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] is a lowercase letter*/
public class FindCommonCharacters {

	/*
	 * Runtime: 70 ms, faster than 5.17% of Java online submissions for Find Common Characters.
	 * Memory Usage: 39.5 MB, less than 17.24% of Java online submissions for Find Common Characters.
	 */
    public List<String> commonChars(String[] A) {

    	List<String> list = new ArrayList<String>();
    	int minIndex = getMinIndex(A);

    	for(char c : A[minIndex].toCharArray()) {

    		int count = 0;
    		for(int i = 0; i < A.length; i++) {

    			if(i == minIndex) {
    				continue;
    			}

    			if(A[i].contains(c + "")) {

    				count++;
    				A[i] = A[i].replaceFirst(c + "", "");
    			}
    		}

    		if(count == A.length - 1) {

    			list.add(c + "");
    		}
    	}

    	return list;
    }

    private int getMinIndex(String[] A) {

    	int minIndex = Integer.MAX_VALUE;
    	int minLen = Integer.MAX_VALUE;

    	for(int i = 0; i < A.length; i++) {

    		if(A[i].length() < minLen) {

    			minLen = A[i].length();
    			minIndex = i;
    		}
    	}

    	return minIndex;
    }

	/*
	 * Runtime: 3 ms, faster than 91.55% of Java online submissions for Find Common Characters.
	 * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Find Common Characters.
	 */
    public List<String> commonChars2(String[] A) {

        int freqGlobal[] = new int[26];
        Arrays.fill(freqGlobal, Integer.MAX_VALUE);

        for (int i = 0; i < A.length; i++) {
            int freq[] = computeFreqArray(A[i]);
            for (int j = 0; j < freq.length; j++) {

                freqGlobal[j] = Math.min(freqGlobal[j], freq[j]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < freqGlobal.length; i++) {
            if (freqGlobal[i] != Integer.MAX_VALUE) {

                for (int j = 0; j < freqGlobal[i]; j++) {
                    result.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return result;
    }

    private int[] computeFreqArray(String s) {

    	int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            freq[idx]++;
        }

        return freq;
    }

    public static void main(String[] args) {

    	String[] A = {"cool","lock","cook"};

    	System.out.println(new FindCommonCharacters().commonChars2(A));
    }
}
