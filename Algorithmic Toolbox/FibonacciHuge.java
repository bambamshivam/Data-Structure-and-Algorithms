import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHuge(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long j=2;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous%m;
            previous = current%m;
            current = (tmp_previous + current)%m;
            if(current==0 && (previous+current)%m==1)
            break;
            else
            j++;
        }
        long c=n%j;
        long previous1 = 0;
        long current1  = 1;
        System.out.println(j);
        if(c<=1)
        return c;
        for (long i = 0; i < c - 1; i++) {
            long tmp_previous1 = previous1%m;
            previous1 = current1%m;
            current1 = (tmp_previous1 + current1)%m;
        }
        return current1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

