package others;

import java.util.HashSet;
import java.util.Set;

/*You have a set of tiles, where each tile has one letter tiles[i] printed on it.
 Return the number of possible non-empty sequences of letters you can make.

Example 1:

Input: "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: "AAABBC"
Output: 188

Note:

1 <= tiles.length <= 7
tiles consists of uppercase English letters.*/

public class LetterTilePossibilities {

	/*
	 * Runtime: 136 ms, faster than 6.25% of Java online submissions for Letter Tile Possibilities.
	 * Memory Usage: 40.4 MB, less than 100.00% of Java online submissions for Letter Tile Possibilities.
	 */
	public static int numTilePossibilities(String tiles) {

        boolean[] used = new boolean[tiles.length()];
        HashSet<String> list = new HashSet<>();

        dfs(tiles, new StringBuilder(), list, used);

        for(String s : list){

            System.out.print(s + ",");
        }

        return list.size();
    }

    public static void dfs(String tiles, StringBuilder s, HashSet<String> list, boolean[] used){

        if(s.length() > 0){

            list.add(new String(s));
        }

        for(int i = 0; i < tiles.length(); i++){

            if(!used[i]){

                used[i] = true;
                s.append(tiles.charAt(i));
                dfs(tiles, s, list, used);
                s.deleteCharAt(s.length()-1);
                used[i] = false;
            }
        }
    }

    public static void main(String args[]) {

    	String tiles = "AB";
    	System.out.println(numTilePossibilities(tiles));
    }
}
