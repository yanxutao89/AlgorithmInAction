package sort;

import java.util.Arrays;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/2/10 16:09
 */
public class ShellSort implements Sort {

    @Override
    public int[] sort(int[] array) throws Exception {
        if (array == null) {
            throw new Exception("Parameter 'array' must not be null");
        }
        return sort(array, 0, array.length);
    }

    @Override
    public int[] sort(int[] array, int offset, int length) throws Exception {
        checkRange(array, offset, length);
        int[] arr = Arrays.copyOf(array, array.length);
        int len = offset + length;

        int gap = 1;
        while (gap < len) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < len; ++i) {
                int sentinel = arr[i];
                int j = i;
                while (j > gap - 1 && sentinel < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                if (j != i) {
                    arr[j] = sentinel;
                }
            }
            gap = (int) Math.floor(gap / 3);
        }
        return arr;
    }

}
