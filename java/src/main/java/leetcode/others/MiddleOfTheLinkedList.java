package leetcode.others;

import leetcode.utils.ListNodeUtils;

import java.util.HashMap;
import java.util.Map;

import leetcode.beans.ListNode;

/*Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.



Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.


Note:

The number of nodes in the given list will be between 1 and 100.*/
public class MiddleOfTheLinkedList {

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
	 * Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Middle of the Linked List.
	 */
	public ListNode middleNode(ListNode head) {

		Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
		int len = 0;

		while(head != null) {

			map.put(len, head);
			len++;
			head = head.next;
		}

		return map.get((int)(len % 2 == 0 ? Math.ceil(len / 2) : Math.floor(len / 2)));
    }

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
	 * Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Middle of the Linked List.
	 */
	public ListNode middleNode2(ListNode head) {

		if(head == null || head.next == null) {

			return head;
		}

		ListNode fast = head, slow = head;
		while(fast != null && fast.next != null){

			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	public static void main(String[] args) {

		String input = ",1,2,3,4,5,6,7,8,";

		System.out.println(ListNodeUtils.listNodeToString(new MiddleOfTheLinkedList().middleNode2(ListNodeUtils.stringToListNode(input))));
	}
}
