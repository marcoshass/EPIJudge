package nonepi;

public class PermutationsOfString {

	public static void main(String[] args) {
		permute("", "abcd");
	}

	private static int count = 0;

	public static void permute(String prefix, String sufix) {
		if (sufix.length() == 2) {
			System.out.printf("%d:%s%s\n", ++count, prefix, sufix);
			System.out.printf("%d:%s%s\n", ++count, prefix, reverse(sufix));
		} else {
			for (int i = 0; i < sufix.length(); ++i) {
				permute(prefix + sufix.charAt(i), sufix.substring(0, i) + sufix.substring(i + 1));
			}
		}
	}

	static String reverse(String toReverse) {
		return new StringBuilder(toReverse).reverse().toString();
	}

}
