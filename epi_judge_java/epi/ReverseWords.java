package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

public class ReverseWords {

	public static void reverseWords(char[] input) {
		int n = input.length;
		reverse(input, 0, n - 1);

		int start = 0, end = 0;

		while (end < n) {
			while (start < end || start < n && input[start] == ' ') {
				start++;
			}
			while (end < start || end < n && input[end] != ' ') {
				end++;
			}
			reverse(input, start, end - 1);
		}

		return;
	}

	static void reverse(char[] s, int start, int end) {
		while (start < end) {
			char tmp = s[start];
			s[start++] = s[end];
			s[end--] = tmp;
		}
	}

	@EpiTest(testDataFile = "reverse_words.tsv")
	public static String reverseWordsWrapper(TimedExecutor executor, String s) throws Exception {
		char[] sCopy = s.toCharArray();

		executor.run(() -> reverseWords(sCopy));

		return String.valueOf(sCopy);
	}

	public static void main(String[] args) {
		System.exit(GenericTest.runFromAnnotations(args, "ReverseWords.java", new Object() {
		}.getClass().getEnclosingClass()).ordinal());
	}
}
