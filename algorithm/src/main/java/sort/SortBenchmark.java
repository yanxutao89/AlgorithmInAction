package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/2/10 16:24
 */
public class SortBenchmark {

    private static final int LENGTH = 57;
    private static final Random GENERATOR = new Random();

    public static void main(String[] args) throws Exception {
        int[] array = new int[LENGTH];
        for (int i = 0; i < LENGTH; ++i) {
            array[i] = GENERATOR.nextInt(LENGTH);
        }
        System.out.println(Arrays.toString(array));
        Sort sort = new BubbleSort();
//        Sort sort = new SelectionSort();
//        Sort sort = new InsertSort();
//        Sort sort = new ShellSort();
//        Sort sort = new QuickSort();
//        Sort sort = new MergeSort();
        System.out.println(Arrays.toString(sort.sort(array, true)));
        System.out.println(Arrays.toString(sort.sort(array, false)));
    }

}
