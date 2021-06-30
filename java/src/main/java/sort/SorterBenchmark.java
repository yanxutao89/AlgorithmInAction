package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/2/10 16:24
 */
public class SorterBenchmark {

    private static final int LENGTH = 49;
    private static final Random GENERATOR = new Random();

    public static void main(String[] args) throws Exception {
        int[] array = new int[LENGTH];
        for (int i = 0; i < LENGTH; ++i) {
            array[i] = GENERATOR.nextInt(LENGTH);
        }
        System.out.println(Arrays.toString(array));
//        Sorter sorter = new BubbleSorter();
//        Sorter sorter = new BucketCountingSorter();
//        Sorter sorter = new BucketGroupSorter();
//        Sorter sorter = new HeapSorter();
//        Sorter sorter = new InsertSorter();
//        Sorter sorter = new MergeSorter();
//        Sorter sorter = new QuickSorter();
//        Sorter sorter = new RadixSorter();
//        Sorter sorter = new SelectionSorter();
        Sorter sorter = new ShellSorter();
        System.out.println(Arrays.toString(sorter.sort(array, true)));
        System.out.println(Arrays.toString(sorter.sort(array, false)));
    }

}
