package arrays;

/**
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Constraints:
 * Each string consists only of '0' or '1' characters.
 * 1 <= a.length, b.length <= 10^4
 * Each string is either "0" or doesn't contain any leading zero.
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/9/6 21:13
 */
public class AddBinary {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Binary.
     * Memory Usage: 38.4 MB, less than 74.94% of Java online submissions for Add Binary.
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        if ("0".equals(a)) {
            return b;
        }
        if ("0".equals(b)) {
            return a;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        int over = 0;
        int i = chars1.length - 1;
        int j = chars2.length - 1;
        while (i > -1 || j > -1) {
            int i1 = 0 > i ? 0 : (int) chars1[i] - 48;
            int i2 = 0 > j ? 0 : (int) chars2[j] - 48;
            int sum = i1 + i2 + over;
            over = 0;
            if (sum > 1) {
                over = sum / 2;
                sum = sum - over * 2;
            }
            sb.append(sum);
            --i;
            --j;
        }
        if (0 != over) {
            sb.append(over);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(new AddBinary().addBinary(a, b));
    }
}
