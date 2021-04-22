package others;

import java.util.Arrays;
import java.util.Collections;

/*In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.

Initially, all the cards start face down (unrevealed) in one deck.

Now, you do the following steps repeatedly, until all cards are revealed:

Take the top card of the deck, reveal it, and take it out of the deck.
If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
Return an ordering of the deck that would reveal the cards in increasing order.

The first entry in the answer is considered to be the top of the deck.



Example 1:

Input: [17,13,11,2,3,5,7]
Output: [2,13,3,11,5,17,7]
Explanation:
We get the deck in the order [17,13,11,2,3,5,7] (this order doesn't matter), and reorder it.
After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
We reveal 13, and move 17 to the bottom.  The deck is now [17].
We reveal 17.
Since all the cards revealed are in increasing order, the answer is correct.


Note:

1 <= A.length <= 1000
1 <= A[i] <= 10^6
A[i] != A[j] for all i != j*/
public class RevealCardsInIncreasingOrder {

	/*
	 * Runtime: 3 ms, faster than 32.13% of Java online submissions for Reveal Cards In Increasing Order.
	 * Memory Usage: 37.1 MB, less than 100.00% of Java online submissions for Reveal Cards In Increasing Order.
	 */
	public static int[] deckRevealedIncreasing(int[] deck) {

		Arrays.sort(deck);
		int[] res = reverse(deck);

		for(int i = 0; i < deck.length; i++) {

			if(i > 1) {

				int temp = res[0];
				for(int j = 1; j <= i - 1;  j++) {

					res[j - 1] = res[j];
				}
				res[i - 1] = temp;
			}
		}

		return reverse(res);
	}

	private static int[] reverse(int[] deck) {

		int[] res = new int[deck.length];

		for(int i = 0; i < deck.length; i++) {

			res[i] = deck[deck.length -1 - i];
		}

		return res;
	}

	public static void main(String[] args) {

		int[] deck = {17,13,11,2,3,5,7};

		System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
	}
}
