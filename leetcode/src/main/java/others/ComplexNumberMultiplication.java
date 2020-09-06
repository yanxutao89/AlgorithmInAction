package others;

/*Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:

The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.*/
public class ComplexNumberMultiplication {

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Complex Number Multiplication.
	 * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Complex Number Multiplication.
	 */
	public String complexNumberMultiply(String a, String b) {

		int intA = Integer.parseInt(a.substring(0, a.indexOf('+')));
		int intB = Integer.parseInt(a.substring(a.indexOf('+') + 1, a.length() - 1));

		int intC = Integer.parseInt(b.substring(0, b.indexOf('+')));
		int intD = Integer.parseInt(b.substring(b.indexOf('+') + 1, b.length() - 1));

		return multiply(intA, intB, intC, intD);
    }

	private String multiply(int a, int b, int c, int d) {

		StringBuffer sb = new StringBuffer();

		int left = (a * c) - (b * d);
		int right = a * d + b * c;

		sb.append(String.valueOf(left)).append("+").append(String.valueOf(right)).append("i");

		return sb.toString();
	}

	public static void main(String[] args) {

		String a = "1+1i";
		String b = "1+1i";

		System.out.println(new ComplexNumberMultiplication().complexNumberMultiply(a, b));
	}
}
