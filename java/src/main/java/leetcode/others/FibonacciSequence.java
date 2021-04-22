package others;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSequence {

	private static void recursive(List<Integer> list, int index) {

		if(list.size() > 10) {

			return;
		}

		list.add(index, list.get(index - 1) + list.get(index - 2));

		index++;

		recursive(list, index);

	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);

		recursive(list, 2);

		System.out.println(list);
	}
}
