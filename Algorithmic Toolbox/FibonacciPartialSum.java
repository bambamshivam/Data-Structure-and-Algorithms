import java.util.*;

public class FibonacciPartialSum {
   private static long getFibonacciSum(long n) {
        if(n<0)
        return 0;
        n=n+1;
        long j=60;
        long c=n%j;
        long d=n/j;
        long sum1=1;
        long sum2=1;
        long previous1 = 0;
        long current1  = 1;
        if(d==0 && c<=1)
        return n-1;
        if(c==0)
        c=c+j;
        if(c==1)
        sum1=0;
        if(c==2)
        sum1=1;
        for (long i = 0; i < c - 2; i++) {
            long tmp_previous1 = previous1%10;
            previous1 = current1%10;
            current1 = (tmp_previous1 + current1)%10;
            sum1= sum1%10 +current1;
        }
        long previous2 = 0;
        long current2  = 1;
        for (long i = 0; i < j - 2; i++) {
            long tmp_previous2 = previous2%10;
            previous2 = current2%10;
            current2 = (tmp_previous2 + current2)%10;
            sum2= sum2%10 +current2;
        }
        return ((d*sum2)+sum1)%10;
    }
    private static long getFibonacciPartialSum(long m, long n) {
        long a=getFibonacciSum(m-1);
        long b=getFibonacciSum(n);
        if(b>=a)
        return b-a;
        else
        return (10+b)-a;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

