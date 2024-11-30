package Operations;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Methods {
    public static BigInteger factorial(int f) {
        if (f < 2) {
            return BigInteger.valueOf(1);
        }
        else {
            return IntStream.rangeClosed(2, f).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
        }
    }

    public static BigInteger fibonacci(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        BigInteger prev = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger temp = current;
            current = current.add(prev);
            prev = temp;
        }
        return current;
    }
}
