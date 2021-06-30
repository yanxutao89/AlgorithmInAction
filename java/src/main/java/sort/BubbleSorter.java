package sort;

import java.util.Arrays;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/2/10 16:09
 */
public class BubbleSorter implements Sorter {
    @Override
    public int[] sort(int[] array) throws Exception {
        if (array == null) {
            throw new Exception("Parameter 'array' must not be null");
        }
        return sort(array, 0, array.length, true);
    }

    @Override
    public int[] sort(int[] array, boolean isAsc) throws Exception {
        if (array == null) {
            throw new Exception("Parameter 'array' must not be null");
        }
        return sort(array, 0, array.length, isAsc);
    }

    @Override
    public int[] sort(int[] array, int offset, int length) throws Exception {
        return sort(array, offset, length, true);
    }

    @Override
    public int[] sort(int[] array, int offset, int length, boolean isAsc) throws Exception {
        checkRange(array, offset, length);
        int[] arr = Arrays.copyOf(array, array.length);
        int len = length - offset;
        for (int i = offset + 1; i < len; ++i) {
            boolean isSorted = true;
            for (int j = offset; j < len - i; ++j) {
                if (isAsc) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                        isSorted = false;
                    }
                }
                else {
                    if (arr[j] < arr[j + 1]) {
                        swap(arr, j, j + 1);
                        isSorted = false;
                    }
                }
            }
            if (isSorted) {
                break;
            }
        }
        return arr;
    }
}
