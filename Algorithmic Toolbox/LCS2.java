import java.util.*;

public class LCS2 {
    
    private static int lcs2(int[] a, int[] b) {
        int a1=a.length;
        int b1=b.length;
        int ar1[][]=new int[a1+1][b1+1];
        for(int i=0;i<a1+1;i++){
            for(int j=0;j<b1+1;j++){
                if(i==0 || j==0)
                ar1[i][j]=0;
                else if(a[i-1]==b[j-1])
                ar1[i][j]=ar1[i-1][j-1]+1;
                else
                ar1[i][j]=Math.max(ar1[i][j-1],ar1[i-1][j]);
            }
        }
        return ar1[a1][b1];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(lcs2(a,b));
    }
}

