package numbers;

/**
 * Given the two positive integers m and n, find their greatest common divisor,
 * that is, the largest positive integer that evenly divides both m and n
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/09/12 13:26
 */
public class EuclidAlgorithm {

	public int getGreatestCommonDivisor(int m, int n) {

		if (m < n) {
			// temp variable
//			int temp = m;
//			m = n;
//			n = temp;
			// +-
//			n = m + n;
//			m = n - m;
//			n = n - m;
			// bit operation
//			n = m ^ n;
//			m = m ^ n;
//			n = n ^ m;
			// */
//			n = m * n;
//			m = n / m;
//			n = n / m;
		}
		int r = m % n;
		while (r != 0) {
			m = n;
			n = r;
			r = m % n;
		}
		return n;
	}

	public int getGreatestCommonDivisor2(int m, int n) {
		int r = m % n;
		if (r == 0) {
			return n;
		} else {
			return getGreatestCommonDivisor(n, r);
		}
	}

	public static void main(String[] args) {
		int m = 1769;
		int n = 551;
		System.out.println(new EuclidAlgorithm().getGreatestCommonDivisor(m, n));
		System.out.println(new EuclidAlgorithm().getGreatestCommonDivisor2(m, n));
	}
}
