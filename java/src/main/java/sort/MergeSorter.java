package sort;

import java.util.Arrays;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/2/10 16:09
 */
public class MergeSorter implements Sorter {
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
        if (len < 2) {
            return arr;
        }
        int middle = (int) Math.floor(len >> 1);
        int[] left = Arrays.copyOfRange(arr, offset, middle);
        int[] right = Arrays.copyOfRange(arr, middle, len);
        return merge(sort(left, isAsc), sort(right, isAsc), isAsc);
    }

    private int[] merge(int[] left, int[] right, boolean isAsc) {
        int[] result = new int[left.length + right.length];
        int index = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] < right[0]) {
                if (isAsc) {
                    result[index++] = left[0];
                    left = Arrays.copyOfRange(left, 1, left.length);
                }
                else {
                    result[index++] = right[0];
                    right = Arrays.copyOfRange(right, 1, right.length);
                }
            }
            else {
                if (isAsc) {
                    result[index++] = right[0];
                    right = Arrays.copyOfRange(right, 1, right.length);
                }
                else {
                    result[index++] = left[0];
                    left = Arrays.copyOfRange(left, 1, left.length);
                }
            }
        }

        while (left.length > 0) {
            result[index++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[index++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }
}
