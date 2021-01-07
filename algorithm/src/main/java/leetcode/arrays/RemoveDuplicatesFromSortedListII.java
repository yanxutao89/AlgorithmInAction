package leetcode.arrays;

import leetcode.beans.ListNode;
import leetcode.utils.ListNodeUtils;

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

	public ListNode deleteDuplicates(ListNode head) {

		ListNode node = null;
		int curr = -101;
		while (head != null) {
			if (head.val == curr) {
				if (node == null) {
					node = head;
				} else {
					node.next = head;
				}
			} else {
				if (node == null) {
					node = head;
				} else {
					node.next = head;
				}
			}
			curr = head.val;
			head = head.next;
		}

		return node;
	}

	public static void main(String[] args) {
		String input = ",1,2,3,3,4,4,5,";
		ListNode head = ListNodeUtils.stringToListNode(input);
		System.out.println(ListNodeUtils.listNodeToString(new RemoveDuplicatesFromSortedListII().deleteDuplicates(head)));
	}

}
