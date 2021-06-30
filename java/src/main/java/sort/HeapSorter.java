package sort;

import java.util.Arrays;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/2/10 16:09
 */
public class HeapSorter implements Sorter {
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
        buildMaxHeap(arr, len, isAsc);
        for (int i = len - 1; i > -1; --i) {
            swap(arr, 0, i);
            --len;
            heapify(arr, 0, len, isAsc);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len, boolean isAsc) throws Exception {
        for (int i = (int) Math.floor(len >> 1); i > -1; --i) {
            heapify(arr, i, len, isAsc);
        }
    }

    private void heapify(int[] arr, int index, int len, boolean isAsyc) throws Exception {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int target = index;

        if (left < len) {
            if (isAsyc) {
                target = arr[left] > arr[target] ? left : target;
            }
            else {
                target = arr[left] < arr[target] ? left : target;
            }
        }

        if (right < len) {
            if (isAsyc) {
                target = arr[right] > arr[target] ? right : target;
            }
            else {
                target = arr[right] < arr[target] ? right : target;
            }
        }

        if (target != index) {
            swap(arr, index, target);
            heapify(arr, target, len, isAsyc);
        }
    }
}
