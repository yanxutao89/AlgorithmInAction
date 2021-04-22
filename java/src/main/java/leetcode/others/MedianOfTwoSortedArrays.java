package others;

import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 */
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        for(int i=0; i<nums1.length; i++)
            arr[i] = nums1[i];
        for(int i=nums1.length; i<nums1.length+nums2.length; i++)
            arr[i] = nums2[i-nums1.length];
        Arrays.sort(arr);
        int flag =  arr.length/2;
        return arr.length%2 == 0 ? (arr[(int)Math.floor(flag)-1]+arr[(int)Math.floor(flag)])*0.5 : arr[(int)Math.ceil(flag)];
    }
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m+n+1)/2;
        int r = (m+n+2)/2;
        return (getkth(nums1, 0, nums2, 0, l) + getkth(nums1, 0, nums2, 0, r))/2.0;
    }
    private static double getkth(int[] a, int aStart, int[] b, int bStart, int k){
        if(aStart > a.length-1)
            return b[bStart+k-1];
        if(bStart > b.length-1)
            return a[aStart+k-1];
        if(k==1)
            return Math.min(a[aStart], b[bStart]);
        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < a.length)
            aMid = a[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < b.length)
            bMid = b[bStart + k/2 - 1];
        if (aMid < bMid)
            return getkth(a, aStart + k/2, b, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return getkth(a, aStart,       b, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }
    public static void main(String[] args){
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4, 5};
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }
}
