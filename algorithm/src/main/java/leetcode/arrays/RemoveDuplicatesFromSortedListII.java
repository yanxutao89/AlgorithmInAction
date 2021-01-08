package leetcode.arrays;

import leetcode.beans.ListNode;
import leetcode.utils.ListNodeUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/01/07 21:07
 */
public class RemoveDuplicatesFromSortedListII {

	/**
	 * Runtime: 2 ms, faster than 9.33% of Java online submissions for Remove Duplicates from Sorted List II.
	 * Memory Usage: 38.5 MB, less than 36.96% of Java online submissions for Remove Duplicates from Sorted List II.
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		ListNode res = null;
		ListNode node = null;
		Map<Integer, Integer> count = new LinkedHashMap<>();
		while (head != null) {
			count.put(head.val, count.getOrDefault(head.val, 0) + 1);
			head = head.next;
		}

		for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
			if (1 == entry.getValue()) {
				if (node == null) {
					node = new ListNode(entry.getKey());
				} else {
					node.next = new ListNode(entry.getKey());
				}
				res = res == null ? node : res;
				node = node.next == null ? node : node.next;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String input = ",1,2,3,3,4,4,5,";
		ListNode head = ListNodeUtils.stringToListNode(input);
		System.out.println(ListNodeUtils.listNodeToString(new RemoveDuplicatesFromSortedListII().deleteDuplicates(head)));
	}

}
