package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
public class PhoneNumberMnemonic {
  @EpiTest(testDataFile = "phone_number_mnemonic.tsv")

  public static List<String> phoneMnemonic(String phoneNumber) {
	List<String> perms = new ArrayList<>();
	permuteHelper(phoneNumber, 0, "", perms);
    return perms;
  }
  
  private static final String[] MAPPINGS = {"0", "1", "ABC", "DEF", "GHI",
		  "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
  
  static void permuteHelper(String phoneNumber, int digit, String prefix, 
		  List<String> permutations) {
	  if (digit == phoneNumber.length()) {
		  permutations.add(prefix);
	  } else {
		  String mnemonic = MAPPINGS[phoneNumber.charAt(digit) - '0'];
		  for (int i = 0; i < mnemonic.length(); ++i) {
			  permuteHelper(phoneNumber, digit + 1, prefix + mnemonic.charAt(i), permutations);
		  }
	  }
  }
  
  @EpiTestComparator
  public static BiPredicate<List<String>, List<String>> comp =
      (expected, result) -> {
    if (result == null) {
      return false;
    }
    Collections.sort(expected);
    Collections.sort(result);
    return expected.equals(result);
  };

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PhoneNumberMnemonic.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
