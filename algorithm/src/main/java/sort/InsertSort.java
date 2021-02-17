package sort;

import java.util.Arrays;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/2/10 16:09
 */
public class InsertSort implements Sort {

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
        int len = offset + length;
        for (int i = offset + 1; i < len; ++i) {
            int sentinel = arr[i];
            int j = i;
            if (isAsc) {
                while (j > 0 && sentinel < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                }
            } else {
                while (j > 0 && sentinel > arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                }
            }
            if (j != i) {
                arr[j] = sentinel;
            }
        }
        return arr;
    }

}
