package others;

/*The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.



Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537


Constraints:

0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.*/
public class NthTribonacciNumber {

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
	 * Memory Usage: 32.9 MB, less than 100.00% of Java online submissions for N-th Tribonacci Number.
	 */
	public int tribonacci(int n) {

		int[] init = {0, 1, 1};
		if(n < 3) {
			return init[n];
		}

		int res = 0;
		int index = 3;

		res = init[0] + init[1] + init[2];
		while(index < n) {

			init[0] = init[1];
			init[1] = init[2];
			init[2] = res;

			res = init[0] + init[1] + init[2];
			index++;
		}

		return res;
	}

	public static void main(String[] args) {

		int n = 37;

		System.out.println(new NthTribonacciNumber().tribonacci(n));
	}
}
