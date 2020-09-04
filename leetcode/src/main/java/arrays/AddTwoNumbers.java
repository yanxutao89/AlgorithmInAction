package arrays;

import main.java.bean.ListNode;

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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		List<Integer> sumList1 = new ArrayList<Integer>();
		List<Integer> sumList2 = new ArrayList<Integer>();
		ListNode node1 = l1;
		ListNode node2 = l2;
		while (null != node1) {
			sumList1.add(0, node1.val);
			node1 = node1.next;
		}
		while (null != node2) {
			sumList2.add(0, node2.val);
			node2 = node2.next;
		}

		int max = Math.max(sumList1.size(), sumList2.size());
		List<Integer> sumList = new ArrayList<Integer>(max);
		for (int i = 0; i < max; ++i) {
			sumList.add(0, (i > sumList1.size() - 1 ? 0 : sumList1.get(i)) + (i > sumList2.size() - 1 ? 0 : sumList2.get(i)));
		}

		List<Integer> resList = new ArrayList<Integer>(sumList.size());
		int over = 0;
		for (int i = sumList.size() - 1; i > -1; --i) {
			Integer integer = sumList.get(i);
			integer += over;
			if (integer > 9 && i > 0) {
				over = integer - 9;
				integer -= 10;
				resList.add(0, integer);
			} else if (integer > 9 && i == 0) {
				resList.add(0, integer - 10);
				resList.add(0, integer / 10);
			} else {
				resList.add(0, integer);
			}
		}

		ListNode sentinel = null;
		ListNode res = null;
		for (int i = resList.size() - 1; i > -1; --i) {
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

	public static void main(String[] args) {

		ListNode l10 = new ListNode(2);
		ListNode l11 = new ListNode(8);
		ListNode l12 = new ListNode(3);
		l10.next = l11;
		l11.next = l12;

		ListNode l20 = new ListNode(5);
		ListNode l21 = new ListNode(6);
		ListNode l22 = new ListNode(4);
		l20.next = l21;
		l21.next = l22;

		System.out.println(new AddTwoNumbers().addTwoNumbers(l10, l20));
	}
}