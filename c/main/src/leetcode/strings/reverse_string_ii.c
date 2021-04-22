/*
 * reverse_string_ii.c
 *
 *  Created on: 2021Äê4ÔÂ22ÈÕ
 *      Author: Dell
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

/**
 * Runtime: 0 ms, faster than 100.00% of C online submissions for Reverse String II.
 * Memory Usage: 6.2 MB, less than 38.89% of C online submissions for Reverse String II.
 */
char* reverseStr(char* s, int k)
{
	int i, len, num, left, right;
	char temp;

	len = strlen(s);
	num = ceil(len / (2.0 * k));
	for (i = 0; i < num; ++i) {
		left = i * 2 * k;
		right = len - left < k ? len - 1 : left + k - 1;
		while (left < right) {
			temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			++left;
			--right;
		}
	}

	return s;
}

int main()
{
	char* s = "abcabcabc";
	int k = 3;
	printf("result: %c", reverseStr(s, k));
	return 1;
}
