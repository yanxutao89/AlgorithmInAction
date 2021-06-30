package sort;

import java.util.Arrays;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/2/10 16:09
 */
public class RadixSorter implements Sorter {
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
        int maxDigit = getMaxDigit(arr);
        return radixSort(arr, maxDigit, isAsc);
    }

    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLength(maxValue);
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    protected int getNumLength(long num) {
        if (num == 0) {
            return 1;
        }
        int length = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            ++length;
        }
        return length;
    }

    private int[] radixSort(int[] arr, int maxDigit, boolean isAsc) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; ++i, dev *= 10, mod *= 10) {
            int[][] buckets = new int[mod * 2][0];
            for (int j = 0; j < arr.length; ++j) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                buckets[bucket] = arrayAppend(buckets[bucket], arr[j]);
            }

            int sortIndex = 0;
            if (isAsc) {
                for (int j = 0; j < buckets.length; ++j) {
                    int[] bucket = buckets[j];
                    for (int value : bucket) {
                        arr[sortIndex++] = value;
                    }
                }
            }
            else {
                for (int j = buckets.length - 1; j > -1; --j) {
                    int[] bucket = buckets[j];
                    for (int value : bucket) {
                        arr[sortIndex++] = value;
                    }
                }
            }
        }

        return arr;
    }

    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
