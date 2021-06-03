import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] w) {
        int r=0;
        Arrays.sort(w);
        for(int i=0;i<w.length;i++)
        r+=w[i];
        int w1[]=new int[3];
        w1[0]=r/3;
        w1[1]=2*r / 3;
        w1[2]=r;
        if(r%3!=0)
        return 0;
        int c=0;
        for(int k=0;k<3;k++){
            int W=w1[k];
            int ar[][]=new int[W+1][w.length+1];
            for(int i=0;i<w.length;i++)
            ar[0][i]=0;
            for(int i=0;i<W+1;i++)
            ar[i][0]=0;
            for(int i=0;i<w.length;i++){
                for(int j=1;j<W+1;j++){
                    ar[j][i+1]=ar[j][i];
                    if(w[i]<=j && w[i]!=0){
                        int v=ar[j-w[i]][i]+w[i];
                        if(v>ar[j][i]){
                            ar[j][i+1]=v;
                        }
                    }
                }
            }
            if(ar[W][w.length]==W)
            c++;
        }
        if(c==3)
        return 1;
        else
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

