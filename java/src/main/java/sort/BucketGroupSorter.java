package sort;

import java.util.Arrays;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/2/10 16:09
 */
public class BucketGroupSorter implements Sorter {
    private static final int BUCKET_SIZE = 5;
    private InsertSorter insertSorter = new InsertSorter();

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
        return bucketSort(arr, offset, length, BUCKET_SIZE, isAsc);
    }

    private int[] bucketSort(int[] arr, int offset, int length, int bucketSize, boolean isAsc) throws Exception {
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int i = offset; i < offset + length; ++i) {
            int value = arr[i];
            if (value < minValue) {
                minValue = value;
            }
            else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        for (int i = 0; i < arr.length; ++i) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrayAppend(buckets[index], arr[i]);
        }

        int sortIndex = 0;
        if (isAsc) {
            for (int i = 0; i < buckets.length; ++i) {
                int[] bucket = buckets[i];
                if (bucket.length <= 0) {
                    continue;
                }
                bucket = insertSorter.sort(bucket, isAsc);
                for (int j = 0; j < bucket.length; ++j) {
                    arr[sortIndex++] = bucket[j];
                }
            }
        }
        else {
            for (int i = buckets.length - 1; i > -1 ; --i) {
                int[] bucket = buckets[i];
                if (bucket.length <= 0) {
                    continue;
                }
                bucket = insertSorter.sort(bucket, isAsc);
                for (int j = 0; j < bucket.length ; ++j) {
                    arr[sortIndex++] = bucket[j];
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
