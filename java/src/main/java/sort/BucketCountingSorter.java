package sort;

import java.util.Arrays;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/2/10 16:09
 */
public class BucketCountingSorter implements Sorter {
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
        int maxValue = getMaxValue(arr, offset, length);
        return countingSort(arr, offset, length, maxValue, isAsc);
    }

    private int[] countingSort(int[] arr, int offset, int length, int maxValue, boolean isAsc) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int i = offset; i < offset + length; ++i) {
            ++bucket[arr[i]];
        }

        int sortedIndex = 0;
        if (isAsc) {
            for (int i = 0; i < bucketLen; ++i) {
                while (bucket[i] > 0) {
                    arr[sortedIndex++] = i;
                    --bucket[i];
                }
            }
        }
        else {
            for (int i = bucketLen - 1; i > -1; --i) {
                while (bucket[i] > 0) {
                    arr[sortedIndex++] = i;
                    --bucket[i];
                }
            }
        }
        return arr;
    }

    private int getMaxValue(int[] arr, int offset, int length) {
        int maxValue = arr[0];
        for (int i = offset; i < offset + length; ++i) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    private int getMinValue(int[] arr, int offset, int length) {
        int minValue = arr[0];
        for (int i = offset; i < offset + length; ++i) {
            if (minValue > arr[i]) {
                minValue = arr[i];
            }
        }
        return minValue;
    }
}
