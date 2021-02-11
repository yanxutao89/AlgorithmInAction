package sort;

import java.util.Arrays;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/2/10 16:09
 */
public class QuickSort implements Sort {

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
        return quickSort(arr, 0, len - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) throws Exception {
        if (left < right) {
            int pIndex = partition(arr, left, right);
            quickSort(arr, left, pIndex - 1);
            quickSort(arr, pIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) throws Exception {
        int index = left + 1;
        for (int i = index; i <= right; ++i) {
            if (arr[i] < arr[left]) {
                swap(arr, index, i);
                index++;
            }
        }
        if (left != index - 1) {
            swap(arr, left, index - 1);
        }
        return index - 1;
    }

}
