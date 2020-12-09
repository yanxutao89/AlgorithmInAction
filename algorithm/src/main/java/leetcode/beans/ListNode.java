package beans;

public class ListNode {

	public int val;

	public ListNode next;

	public ListNode(int x) { val = x; }

    public  ListNode(){

    }

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

}
