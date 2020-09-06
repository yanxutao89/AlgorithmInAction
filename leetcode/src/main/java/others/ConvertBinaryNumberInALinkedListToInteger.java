package others;

import java.util.ArrayList;
import java.util.List;

import bean.ListNode;
import utils.ListNodeUtils;
/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.



Example 1:


Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:

Input: head = [0]
Output: 0
Example 3:

Input: head = [1]
Output: 1
Example 4:

Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880
Example 5:

Input: head = [0,0]
Output: 0


Constraints:

The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.
 * @author Dell
 *
 */
public class ConvertBinaryNumberInALinkedListToInteger {

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
	 * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
	 * @param head
	 * @return
	 */
	 public int getDecimalValue(ListNode head) {

		 int sum = 0;
		 List<Integer> list = new ArrayList<>();
		 while(head != null) {
			 list.add(head.val);
			 head = head.next;
		 }

		 for(int i = 0; i < list.size(); ++i) {
			 Integer integer = list.get(i);
			 sum += integer == 1 ? Math.pow(2, list.size() - 1 - i) : 0;
		 }

		 return  sum;
	 }

	 /**
	  * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
	  * Memory Usage: 33.9 MB, less than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
	  * @param head
	  * @return
	  */
	 public int getDecimalValue2(ListNode head) {

		 int sum = 0;
		 while(head != null) {
			 sum = (sum << 1) + head.val;
			 head = head.next;
		 }

		 return  sum;
	 }

	public static void main(String[] args) {

		String input = ",1,0,0,1,0,0,1,1,1,0,0,0,0,0,0,";
		ListNode head = ListNodeUtils.stringToListNode(input);
		System.out.println(new ConvertBinaryNumberInALinkedListToInteger().getDecimalValue(head));
		System.out.println(new ConvertBinaryNumberInALinkedListToInteger().getDecimalValue2(head));
	}
}
