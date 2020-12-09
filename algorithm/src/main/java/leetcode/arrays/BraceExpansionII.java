package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Under a grammar given below, strings can represent a set of lowercase words.  Let's use R(expr) to denote the set of words the expression represents.
 * Grammar can best be understood through simple examples:
 * Single letters represent a singleton set containing that word.
 * R("a") = {"a"}
 * R("w") = {"w"}
 * When we take a comma delimited list of 2 or more expressions, we take the union of possibilities.
 * R("{a,b,c}") = {"a","b","c"}
 * R("{{a,b},{b,c}}") = {"a","b","c"} (notice the final set only contains each word at most once)
 * When we concatenate two expressions, we take the set of possible concatenations between two words where the first word comes from the first expression and the second word comes from the second expression.
 * R("{a,b}{c,d}") = {"ac","ad","bc","bd"}
 * R("a{b,c}{d,e}f{g,h}") = {"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"}
 * Formally, the 3 rules for our grammar:
 * For every lowercase letter x, we have R(x) = {x}
 * For expressions e_1, e_2, ... , e_k with k >= 2, we have R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
 * For expressions e_1 and e_2, we have R(e_1 + e_2) = {a + b for (a, b) in R(e_1) × R(e_2)}, where + denotes concatenation, and × denotes the cartesian product.
 * Given an expression representing a set of words under the given grammar, return the sorted list of words that the expression represents.
 *
 * Example 1:
 * Input: "{a,b}{c,{d,e}}"
 * Output: ["ac","ad","ae","bc","bd","be"]
 * Example 2:
 * Input: "{{a,z},a{b,c},{ab,z}}"
 * Output: ["a","ab","ac","z"]
 * Explanation: Each distinct word is written only once in the final answer.
 *
 * Constraints:
 * 1 <= expression.length <= 60
 * expression[i] consists of '{', '}', ','or lowercase English letters.
 * The given expression represents a set of words based on the grammar given in the description.
 */
public class BraceExpansionII {

    /**
     * Runtime: 10 ms, faster than 82.39% of Java online submissions for Brace Expansion II.
     * Memory Usage: 40.1 MB, less than 6.25% of Java online submissions for Brace Expansion II.
     * @param expression
     * @return
     */
	public List<String> braceExpansionII(String expression) {

		Set<String> set = solve(expression);
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;

    }

    private Set<String> solve(String str) {

    	int level = 0;
        int start = 0;
        List<Set<String>> groups = new ArrayList<>();
        groups.add(new HashSet<>());
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if ('{' == c) {
                if (0 == level) {
                	start = i + 1;
                }
                level++;
            } else if ('}' == c) {
                level--;
                if (0 == level) {
                    Set<String> sub = solve(str.substring(start, i));
                    groups.set(groups.size() - 1, merge(groups.get(groups.size() - 1), sub));
                }
            } else if (',' == c && 0 == level) {
                groups.add(new HashSet<>());
            } else if (0 == level) {
                Set<String> tmp = new HashSet<>();
                StringBuilder builder = new StringBuilder();
                while (i < str.length() && Character.isLetter(str.charAt(i))) {
                    builder.append(str.charAt(i++));
                }
                i--;
                tmp.add(builder.toString());
                groups.set(groups.size() - 1, merge(groups.get(groups.size() - 1), tmp));
            }
        }

        Set<String> result = new HashSet<>();
        for (Set<String> group : groups) {
            result.addAll(group);
        }
        return result;

    }

    private Set<String> merge(Set<String> set1, Set<String> set2) {

    	Set<String> result = new HashSet<>();
        if (0 == set1.size()) {
        	return set2;
        }
        if (0 == set2.size()) {
        	return set1;
        }
        for (String str1 : set1) {
            for (String str2 : set2) {
                result.add(str1 + str2);
            }
        }
        return result;

    }

	 public static void main(String[] args) {

		 String expression = "{a,b}{c,{d,e}}";
		 System.out.println(new BraceExpansionII().braceExpansionII(expression));
	 }
}
