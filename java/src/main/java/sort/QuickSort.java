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
        return quickSort(arr, offset, len - 1, isAsc);
    }

    private int[] quickSort(int[] arr, int left, int right, boolean isAsc) throws Exception {
        if (left < right) {
            int pIndex = partition(arr, left, right, isAsc);
            quickSort(arr, left, pIndex - 1, isAsc);
            quickSort(arr, pIndex + 1, right, isAsc);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right, boolean isAsc) throws Exception {
        int index = left + 1;
        for (int i = index; i <= right; ++i) {
            if (isAsc) {
                if (arr[i] < arr[left]) {
                    swap(arr, index, i);
                    index++;
                }
            } else {
                if (arr[i] > arr[left]) {
                    swap(arr, index, i);
                    index++;
                }
            }
        }
        if (left != index - 1) {
            swap(arr, left, index - 1);
        }
        return index - 1;
    }

}
