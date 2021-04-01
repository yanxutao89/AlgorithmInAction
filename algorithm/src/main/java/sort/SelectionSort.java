package sort;

import java.util.Arrays;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/2/10 16:09
 */
public class SelectionSort implements Sort {

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
        for (int i = offset; i < len - 1; ++i) {
            int index = i;
            for (int j = i + 1; j < len; ++j) {
                if (isAsc) {
                    if (arr[j] < arr[index]) {
                        index = j;
                    }
                } else {
                    if (arr[j] > arr[index]) {
                        index = j;
                    }
                }
            }
            if (index != i) {
                swap(arr, i, index);
            }
        }
        return arr;
    }

}
