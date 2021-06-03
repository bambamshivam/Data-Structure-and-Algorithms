import java.util.*;
import java.io.*;

public class ConnectingPoints {
    private static Random random = new Random();
    static int parent[];
    static int rank[];
    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.0;
        int n=x.length;
        parent=new int[n];
        rank=new int[n];
        dist a[]=new dist[n*n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        int p=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[p]=new dist(i,j,Math.sqrt(Math.pow(x[i]-x[j],2) + Math.pow(y[i]-y[j],2)));
                p++;
            }
        }
        randomizedQuickSort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            if(Find(a[i].s)!=Find(a[i].e)){
                result+=a[i].d;
                Union(a[i].s,a[i].e);
            }
        }
        return Math.round(result*1000000000.0)/1000000000.0;
    }
    
    static int Find(int i){
        while(i!=parent[i])
        i=parent[i];
        return i;
    }
        
    static void Union(int i, int j){
        int iid=Find(i);
        int jid=Find(j);
        if(rank[iid]>rank[jid])
        parent[jid]=iid;
        else{
            parent[iid]=jid;
            if(rank[iid]==rank[jid])
            rank[jid]=rank[iid]+1;
        }
    }
    
    private static int[] partition3(dist[] a, int l, int r) {
        double x = a[l].d;
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i].d <= x) {
                j++;
                dist t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        dist t = a[l];
        a[l] = a[j];
        a[j] = t;
        int m2=j;
        while(l<j){
            if(a[l].d==x && a[j].d!=x){
                dist p=a[j];
                a[j]=a[l];
                a[l]=p;
                l++;
                j--;
            } 
            else if(a[l].d==x && a[j].d==x)
            j--;
            else
            l++;
        }
        
        int m1=j+1;
        int[] m = {m1, m2};
        return m;
    }

    private static void randomizedQuickSort(dist[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        dist t = a[l];
        a[l] = a[k];
        a[k] = t;
        int m[]=new int[2];
        m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(minimumDistance(x, y));
    }
    
    static class dist{
        int s;
        int e;
        double d;
        dist(int s,int e, double d){
            this.s=s;
            this.e=e;
            this.d=d;
        }
    }
}

