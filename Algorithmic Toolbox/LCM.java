import java.util.*;

public class LCM {
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
    long c=gcd(a, b);
    System.out.println(a*b/c);
  }
}
