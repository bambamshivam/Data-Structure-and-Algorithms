import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(long n) {
    long prev=0;
    long next=1;
    if(n<=1)
    return n;
    for(long i=2;i<=n;i++){
        long temp=prev;
        prev=next;
        next=temp+prev;
    }
    return next;
}

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();

    System.out.println(calc_fib(n));
  }
}
