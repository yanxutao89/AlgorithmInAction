package others;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.


Example 1:

Input: n = 234
Output: 15
Explanation:
Product of digits = 2 * 3 * 4 = 24
Sum of digits = 2 + 3 + 4 = 9
Result = 24 - 9 = 15
Example 2:

Input: n = 4421
Output: 21
Explanation:
Product of digits = 4 * 4 * 2 * 1 = 32
Sum of digits = 4 + 4 + 2 + 1 = 11
Result = 32 - 11 = 21


Constraints:

1 <= n <= 10^5
 * @author yanxt
 *
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {

	/**
	 * Runtime: 1 ms, faster than 13.74% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
	 * Memory Usage: 33 MB, less than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer
	 * @param n
	 * @return
	 */
    public int subtractProductAndSum(int n) {

    	int product = 1, sum = 0;
    	String string = String.valueOf(n);
    	for(int i = 0; i < string.length(); ++i) {
    		Integer integer = Integer.valueOf(string.charAt(i) + "");
			product *= integer;
			sum += integer;
    	}

    	return product - sum;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
     * Memory Usage: 33.2 MB, less than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
     * @param n
     * @return
     */
    public int subtractProductAndSum2(int n) {

    	int remain = n % 10;
    	int quotient = n / 10;
    	int product = remain;
    	int sum = remain;
    	for(;;) {
    		if(quotient == 0) {
    			break;
    		}
    		n = quotient;
        	remain = n % 10;
        	quotient = n / 10;
        	product *= remain;
        	sum += remain;
    	}
    	return product - sum;
    }

    public static void main(String[] args) {
		int n = 4421;
		System.out.println(new SubtractTheProductAndSumOfDigitsOfAnInteger().subtractProductAndSum(n));
		System.out.println(new SubtractTheProductAndSumOfDigitsOfAnInteger().subtractProductAndSum2(n));
	}

}
