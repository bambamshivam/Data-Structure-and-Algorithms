import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int a=m/10;
        int b=(m%10)/5;
        int c=(m%10)%5;
        return a+b+c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

