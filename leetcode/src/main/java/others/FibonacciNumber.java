package others;

import javax.management.relation.RoleUnresolved;

/*The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).



Example 1:

Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.


Note:

0 ≤ N ≤ 30.*/
public class FibonacciNumber {

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
	 * Memory Usage: 33 MB, less than 5.51% of Java online submissions for Fibonacci Number.
	 */
	static int[] fn = new int[31];
	static {
		fn[0] = 0;
		fn[1] = 1;

		for(int i = 2; i < 31; i++) {

			fn[i] = fn[i - 1] + fn[i - 2];
		}
	}
	public int fib(int N) {

		return fn[N];
	}

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
	 * Memory Usage: 33.1 MB, less than 5.51% of Java online submissions for Fibonacci Number.
	 */
	public int fib2(int N) {

		if(N == 0 || N == 1) {

			return N;
		}
		return recursive(0, 1, 0, N);
	}

	private int recursive(int pre2, int pre1, int index, int count) {

		int temp = pre1 + pre2;
		pre2 = pre1;
		pre1 = temp;

		if(index == count - 2) {

			return temp;
		}

		index++;
		return recursive(pre2, pre1, index, count);

	}

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
	 * Memory Usage: 32.9 MB, less than 5.51% of Java online submissions for Fibonacci Number.
	 */
	public int fib3(int N) {

		if(N == 0 || N == 1) {

			return N;
		}

		int index = 2;
		int pre2 = 0, pre1 = 1, temp = 1;

		while(index < N + 1) {

			temp = pre2 + pre1;
			pre2 = pre1;
			pre1 = temp;

			index++;
		}

		return temp;
	}

	public static void main(String[] args) {

		int N = 3;

		System.out.println(new FibonacciNumber().fib3(N));
	}
}
