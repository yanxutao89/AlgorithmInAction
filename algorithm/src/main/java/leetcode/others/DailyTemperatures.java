package others;

import java.util.Arrays;

/*Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].*/
public class DailyTemperatures {

	/*
	 * Runtime: 224 ms, faster than 9.27% of Java online submissions for Daily Temperatures.
	 * Memory Usage: 43 MB, less than 86.44% of Java online submissions for Daily Temperatures.
	 */
	public int[] dailyTemperatures(int[] T) {

		int[] res = new int[T.length];

		for(int i = 0; i < T.length - 1; i++) {

			res[i] = count(T, i);
		}

		res[T.length - 1] = 0;

		return res;
    }

	private int count(int[] T, int temp) {

		int count = 1;
		int index = temp + 1;

		while(index < T.length && T[index] <= T[temp]) {
			count++;
			index++;
		}

		if(count == T.length - temp) {
			return 0;
		}

		return count;
	}

	public static void main(String[] args) {

		int[] T = {73, 74, 75, 71, 69, 72, 76, 73};

		System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(T)));
	}
}
