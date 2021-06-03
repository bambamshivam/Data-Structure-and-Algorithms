import java.util.*;

public class GCD {
  private static long gcd(long a, long b) {
    if(b==0)
    return a;
    else
    return gcd(b,a%b);
  }


  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();
    long b = scanner.nextLong();

    System.out.println(gcd(a, b));
  }
}
