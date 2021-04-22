package main
/**
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.



Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"


Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104
 */

import (
	"fmt"
	"math"
)

/**
Runtime: 0 ms, faster than 100.00% of Go online submissions for Reverse String II.
Memory Usage: 3.5 MB, less than 56.41% of Go online submissions for Reverse String II.
 */
func reverseStr(s string, k int) string {
	arr := []byte(s)
	num := int(math.Ceil(float64(len(s)) / float64(2 * k)))
	for i := 0; i < num; i++ {
		left := i * 2 * k
		var right = 0
		if len(s) - left < k  {
			right = len(s) - 1
		} else {
			right = left + k - 1
		}
		for ; left < right; {
			temp := arr[left]
			arr[left] = arr[right]
			arr[right] = temp
			left++
			right--
		}
	}
	return string(arr)
}

func main() {
	s := "abcabcab"
	k := 3
	fmt.Println(reverseStr(s, k))
}

