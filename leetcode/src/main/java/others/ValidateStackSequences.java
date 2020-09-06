package others;

/*Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.



Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.


Note:

0 <= pushed.length == popped.length <= 1000
0 <= pushed[i], popped[i] < 1000
pushed is a permutation of popped.
pushed and popped have distinct values.*/
public class ValidateStackSequences {

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Stack Sequences.
	 * Memory Usage: 41.5 MB, less than 50.00% of Java online submissions for Validate Stack Sequences.
	 */
	public boolean validateStackSequences(int[] pushed, int[] popped) {

		int s = -1, c = 0;
        int l = pushed.length;
        int[] st = new int[l];

        for (int i = 0; i < l; i++) {
        	st[++s] = pushed[i];

            while (s >= 0 && st[s] == popped[c]) {
            	s--;
                c++;
            }
        }

        return s < 0;
    }

	public static void main(String[] args) {

		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,5,3,2,1};

		System.out.println(new ValidateStackSequences().validateStackSequences(pushed, popped));
	}
}
