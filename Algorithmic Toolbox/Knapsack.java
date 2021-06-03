import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int ar[][]=new int[W+1][w.length+1];
        for(int i=0;i<w.length;i++)
        ar[0][i]=0;
        for(int i=0;i<W+1;i++)
        ar[i][0]=0;
        int w1[]=new int[w.length];
        for(int i=0;i<w.length;i++)
        w1[i]=w[i];
        for(int i=0;i<w.length;i++){
            for(int j=1;j<W+1;j++){
                ar[j][i+1]=ar[j][i];
                if(w[i]<=j){
                    int v=ar[j-w[i]][i]+w[i];
                    if(v>ar[j][i+1]){
                        ar[j][i+1]=v;
                    }
                }
            }
        }
        int m=W;
        int t=w.length;
        int b=ar[W][w.length];
        while(b>0){
            if(ar[m][t]==ar[m][t-1]){
                t=t-1;
            }
            else{
                m=m-w[t-1];
                b=b-w[t-1];
                w[t-1]=0;
                t=t-1;
            }
        }
        for(int i=0;i<w.length;i++)
        System.out.print(w[i] +" ");
        return ar[W][w.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

