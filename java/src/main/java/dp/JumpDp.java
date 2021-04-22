package dp;

/**
 * 有 N 阶楼梯，每次可上一阶或两阶，求有多少种上楼梯的方法
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/01 14:07
 */
public class JumpDp implements Dp {

	public int jump(int n) {
		if (n < 3) {
			return n;
		} else {
			int i = 1;
			int j = 2;
			int res = 0;
			for (int k = 0; k < n - 2; ++k) {
				res = i + j;
				i = j;
				j = res;
			}
			return res;
		}
	}

}
