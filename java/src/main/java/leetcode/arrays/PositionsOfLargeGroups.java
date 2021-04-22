package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * In a string s of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".
 *
 * A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].
 *
 * A group is considered large if it has 3 or more characters.
 *
 * Return the intervals of every large group sorted in increasing order by start index.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the only large group with start index 3 and end index 6.
 * Example 2:
 *
 * Input: s = "abc"
 * Output: []
 * Explanation: We have groups "a", "b", and "c", none of which are large groups.
 * Example 3:
 *
 * Input: s = "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * Explanation: The large groups are "ddd", "eeee", and "bbb".
 * Example 4:
 *
 * Input: s = "aba"
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s contains lower-case English letters only.
 */
public class PositionsOfLargeGroups {

    /**
     * Runtime: 1 ms, faster than 99.87% of Java online submissions for Positions of Large Groups.
     * Memory Usage: 39 MB, less than 61.91% of Java online submissions for Positions of Large Groups.
     * @param s
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> lists = new ArrayList<>();
        if (s.length() < 3) {
            return lists;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        char pre = chars[0];
        int index = 0;
        int count = 0;
        for (int i = 1; i < len; ++i) {
            if (chars[i] == pre) {
                ++count;
                continue;
            } else {
                if (count >= 2) {
                    List<Integer> list = new ArrayList<>(2);
                    list.add(index);
                    list.add(index + count);
                    lists.add(list);
                }
                pre = chars[i];
                index = i;
                count = 0;
            }
        }

        if (count >= 2) {
            List<Integer> list = new ArrayList<>(2);
            list.add(index);
            list.add(index + count);
            lists.add(list);
        }

        return lists;

    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(new PositionsOfLargeGroups().largeGroupPositions(s));
    }

}
