package sort;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/2/10 16:08
 */
public interface Sort {

    int[] sort(int[] array) throws Exception;

    int[] sort(int[] array, int offset, int length) throws Exception;

    default void swap(int[] array, int left, int right) throws Exception {
        if (array == null) {
            throw new Exception("Parameter 'array' must not be null");
        }
        if (left < 0 || left > array.length - 1) {
            throw new Exception("Parameter 'left' out of array range");
        }
        if (right < 0 || right > array.length - 1) {
            throw new Exception("Parameter 'right' out of array range");
        }
        if (left > right) {
            return;
        }
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    default void checkRange(int[] array, int offset, int length) throws Exception {
        if (array == null) {
            throw new Exception("Parameter 'array' must not be null");
        }
        if (offset < 0) {
            throw new Exception("Parameter 'offset' must not be negative");
        }
        if (length < 0) {
            throw new Exception("Parameter 'length' must not be negative");
        }
        if (array.length - offset > length) {
            throw new Exception("The sum of offset and length must not be larger than array's length");
        }
    }
}
