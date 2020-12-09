package others;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order(ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 */

public class NextPermutation {

    public static void nextPermutation(int[] a) {
        int i = a.length - 1;

        while(i - 1 >= 0 && a[i-1] >= a[i])
            i--;

        if(i - 1 >= 0) {
            int j = a.length - 1;
            while(a[i-1] >= a[j])
                j--;
            swap(a, i-1, j);
        }

        Arrays.sort(a, i, a.length);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args){
        int a[] = {1,2,3};
        nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}
