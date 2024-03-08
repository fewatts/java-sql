import java.math.BigInteger;

public class Padovan {
  public static BigInteger Get(long power) {
    if (power < 3) {
      return BigInteger.ONE;
    }

    BigInteger pprev = BigInteger.ONE;
    BigInteger prev = BigInteger.ONE;
    BigInteger curr = BigInteger.ONE;

    for (int i = 3; i <= power; i++) {
      BigInteger next = pprev.add(prev);
      pprev = prev;
      prev = curr;
      curr = next;
    }
    return curr;
  }

}
