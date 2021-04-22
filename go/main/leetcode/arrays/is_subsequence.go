package main

import (
	"fmt"
)

/**
Given two strings s and t, check if s is a subsequence of t.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.


Follow up: If there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */

func main() {
	s := "abc"
	t := "ahbgdc"
	fmt.Println(isSubsequence(s, t))
}

/**
 Runtime: 0 ms, faster than 100.00% of Go online submissions for Is Subsequence.
 Memory Usage: 2 MB, less than 24.09% of Go online submissions for Is Subsequence.
 */
func isSubsequence(s string, t string) bool {
	count := 0
	start := 0

	for i := 0; i < len(s); i++ {
		for j := start; j < len(t); j++ {
			start++
			if s[i] == t[j] {
				count++
				break
			}
		}
	}


	return count == len(s)
}
