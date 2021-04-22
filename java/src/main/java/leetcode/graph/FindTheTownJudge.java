package leetcode.graph;

/**
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 *
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 *
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 *
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 *
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= N <= 1000
 * 0 <= trust.length <= 10^4
 * trust[i].length == 2
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 */
public class FindTheTownJudge {

    /**
     * Runtime: 7 ms, faster than 27.48% of Java online submissions for Find the Town Judge.
     * Memory Usage: 47.2 MB, less than 17.77% of Java online submissions for Find the Town Judge.
     * @param N
     * @param trust
     * @return
     */
    public int findJudge(int N, int[][] trust) {
        for (int i = 1; i <= N; ++i) {
            if (trustNobody(i, trust) && trustedByOthers(i, trust, N)) {
                return i;
            }
        }
        return -1;
    }

    private boolean trustNobody(int label, int[][] trust) {
        for (int[] t : trust) {
            if (label == t[0]) {
                return false;
            }
        }
        return true;
    }

    private boolean trustedByOthers(int label, int[][] trust, int N) {
        int count = 0;
        for (int[] t : trust) {
            if (label == t[1]) {
                ++count;
            }
        }
        return count == N - 1;
    }

    public static void main(String[] args) {
        int N = 2;
        int[][] trust = {{1,2}};
        System.out.println(new FindTheTownJudge().findJudge(N, trust));
    }

}
