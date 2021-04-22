package leetcode.graphs;

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

    /**
     * Runtime: 8 ms, faster than 25.89% of Java online submissions for Find the Town Judge.
     * Memory Usage: 46.8 MB, less than 34.40% of Java online submissions for Find the Town Judge.
     * @param N
     * @param trust
     * @return
     */
    public int findJudge2(int N, int[][] trust) {
        for (int i = 1; i <= N; ++i) {
            if (satisfies(i, trust, N)) {
                return i;
            }
        }
        return -1;
    }

    private boolean satisfies(int label, int[][] trust, int N) {
        int count = 0;
        for (int[] t : trust) {
            if (label == t[0]) {
                return false;
            }
            if (label == t[1]) {
                ++count;
            }
        }
        return count == N - 1;
    }

    /**
     * Runtime: 6 ms, faster than 28.87% of Java online submissions for Find the Town Judge.
     * Memory Usage: 46.8 MB, less than 41.99% of Java online submissions for Find the Town Judge.
     * @param N
     * @param trust
     * @return
     */
    public int findJudge3(int N, int[][] trust) {
        if (trust.length == 0) {
            return N == 1 ? 1 : -1;
        }
        boolean[] processed = new boolean[N + 1];
        for (int[] t : trust) {
            if (!processed[t[1]]) {
                if (satisfies(t[1], trust, N)) {
                    return t[1];
                }
                processed[t[1]] = true;
            }
        }
        return -1;
    }

    /**
     * Runtime: 2 ms, faster than 99.74% of Java online submissions for Find the Town Judge.
     * Memory Usage: 46.7 MB, less than 41.99% of Java online submissions for Find the Town Judge.
     * @param N
     * @param trust
     * @return
     */
    public int findJudge4(int N, int[][] trust) {
        boolean[] impossible = new boolean[N + 1];
        for (int[] t : trust) {
            impossible[t[0]] = true;
        }

        for (int i = 1; i <= N; ++i) {
            if (!impossible[i]) {
                int count = 0;
                for (int[] t : trust) {
                    if (i == t[1]) {
                        ++count;
                    }
                }
                if (count == N - 1) {
                    return i;
                }
                count = 0;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 1;
        int[][] trust = {};
        System.out.println(new FindTheTownJudge().findJudge(N, trust));
        System.out.println(new FindTheTownJudge().findJudge2(N, trust));
        System.out.println(new FindTheTownJudge().findJudge3(N, trust));
        System.out.println(new FindTheTownJudge().findJudge4(N, trust));
    }

}
