package leetcode.numbers;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 * Example 4:
 *
 * Input: x = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/08 16:56
 */
public class ReverseInteger {

	/**
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
	 * Memory Usage: 35.9 MB, less than 85.37% of Java online submissions for Reverse Integer.
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		int res = 0;
		while(x != 0) {
			int tail = x % 10;
			int newRes = res * 10 + tail;
			if ((newRes - tail) / 10 != res) {
				return 0;
			}
			res = newRes;
			x = x / 10;
		}
		return res;
	}

	/**
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
	 * Memory Usage: 36 MB, less than 73.98% of Java online submissions for Reverse Integer.
	 * @param x
	 * @return
	 */
	public int reverse2(int x) {
		long res = 0;
		while(x != 0) {
			int tail = x % 10;
			long newRes = res * 10 + tail;
			res = newRes;
			x = x / 10;
		}
		if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
			return 0;
		}
		return (int)res;
	}

	public static void main(String[] args) {
		int x = 123567899;
		System.out.println(new ReverseInteger().reverse(x));
		System.out.println(new ReverseInteger().reverse2(x));
	}
}
