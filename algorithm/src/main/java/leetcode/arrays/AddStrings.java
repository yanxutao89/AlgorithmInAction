package arrays;


/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/9/6 17:42
 */
public class AddStrings {

    /**
     * Runtime: 2 ms, faster than 97.47% of Java online submissions for Add Strings.
     * Memory Usage: 39.8 MB, less than 55.03% of Java online submissions for Add Strings.
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        if ("0".equals(num1)) {
            return num2;
        }
        if ("0".equals(num2)) {
            return num1;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int over = 0;
        int i = chars1.length - 1;
        int j = chars2.length - 1;
        while (i > -1 || j > -1) {
            int i1 = 0 > i ? 0 : (int) chars1[i] - 48;
            int i2 = 0 > j ? 0 : (int) chars2[j] - 48;
            int sum = i1 + i2 + over;
            over = 0;
            if (sum > 9) {
                over = sum / 10;
                sum = sum - over * 10;
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
        String num1 = "123";
        String num2 = "56";
        System.out.println(new AddStrings().addStrings(num1, num2));
    }
}
