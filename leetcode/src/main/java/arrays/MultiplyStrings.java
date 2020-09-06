package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/9/6 14:31
 */
public class MultiplyStrings {

    /**
     * Runtime: 10 ms, faster than 29.58% of Java online submissions for Multiply Strings.
     * Memory Usage: 39.8 MB, less than 50.28% of Java online submissions for Multiply Strings.
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if ("1".equals(num1)) {
            return num2;
        }
        if ("1".equals(num2)) {
            return num1;
        }

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        int zeroNum = 0;
        int over = 0;
        for (int i = chars1.length - 1; i > -1; --i) {
            int i1 = (int) chars1[i] - 48;
            List list = new ArrayList();
            for (int z = 0; z < zeroNum; ++z) {
                list.add(0);
            }
            ++zeroNum;
            for (int j = chars2.length - 1; j > -1; --j) {
                int i2 = (int) chars2[j] - 48;
                int multiply = i1 * i2 + over;
                over = 0;
                if (multiply > 9) {
                    over = multiply / 10;
                    multiply = multiply - over * 10;
                }
                list.add(multiply);
            }
            if (0 != over) {
                list.add(over);
                over = 0;
            }
            lists.add(list);
        }

        StringBuilder sb = new StringBuilder();
        over = 0;
        for (int i = 0; i < lists.get(lists.size() - 1).size(); ++i) {
            int sum = over;
            over = 0;
            for (int j = 0; j < lists.size(); ++j) {
                Integer integer = i < lists.get(j).size() ? lists.get(j).get(i) : 0;
                sum += integer;
            }
            if (sum > 9) {
                over = sum / 10;
                sum = sum % 10;
            }
            sb.append(sum);
        }
        if (0 != over) {
            sb.append(over);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(new MultiplyStrings().multiply(num1, num2));
    }
}
