package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*We have a collection of rocks, each rock has a positive integer weight.

Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)



Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.


Note:

1 <= stones.length <= 30
1 <= stones[i] <= 1000*/
public class LastStoneWeight {

	/*
	 * Runtime: 2 ms, faster than 43.61% of Java online submissions for Last Stone Weight.
	 * Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Last Stone Weight.
	 */
	public int lastStoneWeight(int[] stones) {

		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < stones.length; i++) {

			list.add(stones[i]);
		}

		while(list.size() > 1) {

			chooseAndSmash(list);
		}

		return list.size() == 1 ? list.get(0) : 0;
	}

	private void chooseAndSmash(List<Integer> list) {

		Collections.sort(list);

		int x = list.get(list.size() - 2), y = list.get(list.size() - 1);
		if(x == y) {

			list.remove(list.size() - 2);
			list.remove(list.size() - 1);
		} else {

			list.remove(list.size() - 1);
			list.set(list.size() - 1, y - x);
		}

	}

	/*
	 * Runtime: 2 ms, faster than 43.61% of Java online submissions for Last Stone Weight.
	 * Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Last Stone Weight.
	 */
	public int lastStoneWeight2(int[] stones) {

		while(getValidCount(stones) > 1) {

			chooseAndSmash2(stones);
		}

		mergeSort(stones, 0, stones.length - 1);
		return stones[stones.length - 1];
	}

	private void chooseAndSmash2(int[] stones) {

		mergeSort(stones, 0, stones.length - 1);

		int x = stones[stones.length - 2], y = stones[stones.length - 1];
		if(x == y) {

			stones[stones.length - 2] = 0;
			stones[stones.length - 1] = 0;
		} else {

			stones[stones.length - 2] = y - x;
			stones[stones.length - 1] = 0;
		}
	}

	private int getValidCount(int[] stones) {

		int count = 0;
		for(int i = 0; i < stones.length; i++) {

			if(stones[i] != 0) {

				count++;
			}
		}

		return count;
	}

	private static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }

    private static void merge(int[] arr, int start, int midlle, int end){
        int n1 = midlle - start + 1;
        int n2 = end - midlle;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++){
            L[i] = arr[start + i];
        }
        L[n1] = Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++){
            R[i] = arr[midlle + i + 1];
        }
        R[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for(int k = start; k <= end; k++){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
        }
    }

	public static void main(String[] args) {

		int[] stones = {2,7,4,1,8,1};

		System.out.println(new LastStoneWeight().lastStoneWeight2(stones));
	}
}
