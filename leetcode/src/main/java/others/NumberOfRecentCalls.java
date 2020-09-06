package others;

import java.util.LinkedList;
import java.util.Queue;

/*Write a class RecentCounter to count recent requests.

It has only one method: ping(int t), where t represents some time in milliseconds.

Return the number of pings that have been made from 3000 milliseconds ago until now.

Any ping with time in [t - 3000, t] will count, including the current ping.

It is guaranteed that every call to ping uses a strictly larger value of t than before.



Example 1:

Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
Output: [null,1,2,3,3]


Note:

Each test case will have at most 10000 calls to ping.
Each test case will call ping with strictly increasing values of t.
Each call to ping will have 1 <= t <= 10^9.*/
public class NumberOfRecentCalls {


	/*
	 * Runtime: 72 ms, faster than 61.70% of Java online submissions for Number of Recent Calls.
	 * Memory Usage: 64 MB, less than 87.50% of Java online submissions for Number of Recent Calls.
	 */
	private final Queue<Integer> requestQueue = new LinkedList<>();
    public NumberOfRecentCalls() {

    }

    /*
        The question does not explain clearly that t (in their example)
        is timeNow. They do say, that [timeNow - 3000, timeNow] (inclusive) counts.
        Therefore, when 3002 comes in, 3001 falls outside the range, since it was before.
    */
    public int ping(int timeNow) {

        requestQueue.add(timeNow);

        while (requestQueue.peek() < (timeNow - 3000)) {
            requestQueue.poll();
        }

        return requestQueue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
