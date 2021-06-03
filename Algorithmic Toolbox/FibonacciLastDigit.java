import java.util.*;

public class FibonacciLastDigit {
    private static long getFibonacciLastDigitNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous%10;
            previous = current%10;
            current = (tmp_previous + current)%10;
        }

        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}