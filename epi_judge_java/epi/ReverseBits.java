package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ReverseBits {
  @EpiTest(testDataFile = "reverse_bits.tsv")
  public static long reverseBits(long x) {
    long x1 = 0;
    final int LENGTH = 63;
    for (int i = 0; i < LENGTH; ++i) {
    	x1 |= (x & 1);
    	x1 <<= 1;
    	x >>>= 1;
    }
    return x1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseBits.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
