package others;

import java.util.ArrayList;
import java.util.List;

/*There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0).

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:

Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
Note:

1 <= rooms.length <= 1000
0 <= rooms[i].length <= 1000
The number of keys in all rooms combined is at most 3000.*/
public class KeysAndRooms {

	/*
	 * Runtime: 1 ms, faster than 92.55% of Java online submissions for Keys and Rooms.
	 * Memory Usage: 43.1 MB, less than 72.41% of Java online submissions for Keys and Rooms.
	 */
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {

		if(rooms == null || rooms.size() == 0) {

			return false;
		}

		int len = rooms.size();
		int[] flag = new int[len];

		dfs(rooms, 0, flag);

		for(int i: flag) {
			if(i == 0) {
				return false;
			}
		}

		return true;
	}

	private void dfs(List<List<Integer>> rooms, int start, int[] flag){

		flag[start] = 1;

		for(int next: rooms.get(start)){
			if(flag[next] == 0){

				dfs(rooms, next, flag);
			}
		}
	}

	public static void main(String[] args) {

		List<List<Integer>> rooms = new ArrayList<List<Integer>>(4);

		for(int i = 0; i < rooms.size() - 1; i++) {

			List<Integer> list = new ArrayList<Integer>();
			list.add(i);
			rooms.add(list);
		}

		rooms.add(new ArrayList<Integer>());

		System.out.println(new KeysAndRooms().canVisitAllRooms(rooms));
	}
}
