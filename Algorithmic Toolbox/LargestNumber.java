import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        int n=a.length;
        String result = "";
            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    if(Integer.parseInt(a[i]+a[j])<=Integer.parseInt(a[j]+a[i])){
                        String temp=a[j];
                        a[j]=a[i];
                        a[i]=temp;
                    }
                }
            }
            for(int i=0;i<n;i++)
            result+=a[i];
            return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

