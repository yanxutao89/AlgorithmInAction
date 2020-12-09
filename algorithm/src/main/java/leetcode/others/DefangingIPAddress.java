package others;


/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 *
 * Example 1:
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 *
 * Example 2:
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 * @author Dell
 *
 */

public class DefangingIPAddress {

	/**
	 * Runtime: 2 ms, faster than 49.37% of Java online submissions for Defanging an IP Address.
	 * Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Defanging an IP Address.
	 * @param address
	 * @return
	 */
	public static String defangIPaddr(String address) {

		return address.replaceAll("\\.", "[.]");
    }

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Defanging an IP Address.
	 * Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Defanging an IP Address.
	 * @param address
	 * @return
	 */
	public static String defangIPaddr2(String address) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < address.length(); i++) {

			if (address.charAt(i) == '.') {

				sb.append("[.]");
			} else {

				sb.append(address.charAt(i));
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(defangIPaddr("1.1.1.1"));
	}


}
