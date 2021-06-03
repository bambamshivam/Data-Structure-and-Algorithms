import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        int a1=a.length;
        int b1=b.length;
        int c1=c.length;
        int ar1[][][]=new int[a1+1][b1+1][c1+1];
        for(int i=0;i<a1+1;i++){
            for(int j=0;j<b1+1;j++){
                for(int k=0;k<c1+1;k++){
                    if(i==0 || j==0 || k==0)
                    ar1[i][j][k]=0;
                    else if(a[i-1]==b[j-1] && a[i-1]==c[k-1])
                    ar1[i][j][k]=ar1[i-1][j-1][k-1]+1;
                    else
                    ar1[i][j][k]=Math.max(ar1[i][j-1][k-1],Math.max(ar1[i-1][j-1][k],Math.max(ar1[i-1][j][k-1],Math.max(ar1[i-1][j][k],Math.max(ar1[i][j-1][k],ar1[i][j][k-1])))));
                }
            }
        }
        return ar1[a1][b1][c1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

