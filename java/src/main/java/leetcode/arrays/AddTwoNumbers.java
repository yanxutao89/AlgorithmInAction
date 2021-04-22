package leetcode.arrays;

import leetcode.beans.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Definition for singly-linked list. public class ListNode { int val;ListNode next; ListNode(int x) { val = x; } }
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

	/**
	 * Runtime: 9 ms, faster than 5.76% of Java online submissions for Add Two Numbers.
	 * Memory Usage: 45.4 MB, less than 9.02% of Java online submissions for Add Two Numbers.
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		List<Integer> sumList = new ArrayList<Integer>();
		ListNode node1 = l1;
		ListNode node2 = l2;
		while (null != node1) {
			sumList.add(node1.val);
			node1 = node1.next;
		}
		int size = sumList.size();
		int index = 0;
		while (null != node2) {
			if (index < size) {
				sumList.set(index, sumList.get(index) + node2.val);
				++index;
			} else {
				sumList.add(node2.val);
			}
			node2 = node2.next;
		}

		List<Integer> resList = new ArrayList<Integer>(sumList.size());
		int over = 0;
		for (int i = 0; i < sumList.size(); ++i) {
			Integer integer = sumList.get(i) + over;
			over = 0;
			if (integer > 9) {
				if (i < sumList.size() - 1) {
					over = integer / 10;
					resList.add(integer - 10);
				} else {
					resList.add(integer - 10);
					resList.add(integer / 10);
				}
			} else {
				resList.add(integer);
			}
		}

		ListNode res = null;
		ListNode sentinel = null;
		for (int i = 0; i < resList.size() ; ++i) {
			if (null == sentinel) {
				sentinel = new ListNode(resList.get(i));
				res = sentinel;
			} else {
				ListNode listNode = new ListNode(resList.get(i));
				sentinel.next = listNode;
				sentinel = listNode;
			}
		}

		return res;

	}

	/**
	 * Runtime: 2 ms, faster than 71.36% of Java online submissions for Add Two Numbers.
	 * Memory Usage: 39.3 MB, less than 94.14% of Java online submissions for Add Two Numbers.
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

		ListNode res = null;
		ListNode sentinel = null;
		ListNode n1 = l1;
		ListNode n2 = l2;
		int over = 0;
		while (null != n1 || null != n2) {
			int sum = (null == n1 ? 0 : n1.val) + (null == n2 ? 0 : n2.val) + over;
			over = 0;
			if (sum > 9) {
				over = sum / 10;
				sum = sum - 10;
			}
			if (null == sentinel) {
				sentinel = new ListNode(sum);
				res = sentinel;
			} else {
				ListNode listNode = new ListNode(sum);
				sentinel.next = listNode;
				sentinel = listNode;
			}
			n1 = null == n1 ? null : n1.next;
			n2 = null == n2 ? null : n2.next;
		}

		if (over != 0) {
			ListNode listNode = new ListNode(over);
			sentinel.next = listNode;
		}

		return res;

	}

	public static void main(String[] args) {

		ListNode l10 = new ListNode(2);
		ListNode l11 = new ListNode(4);
		ListNode l12 = new ListNode(3);
		l10.next = l11;
		l11.next = l12;

		ListNode l20 = new ListNode(8);
		ListNode l21 = new ListNode(6);
		ListNode l22 = new ListNode(4);
		l20.next = l21;
		l21.next = l22;

		System.out.println(new AddTwoNumbers().addTwoNumbers(l10, l20));
		System.out.println(new AddTwoNumbers().addTwoNumbers2(l10, l20));
	}
}
