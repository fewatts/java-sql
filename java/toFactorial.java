import java.math.BigInteger;

public class toFactorial {

    public static String Factorial(int n) {
        if (n == 0 || n == 1)
            return "1";

        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result.toString();
    }

}