import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
    static int n;
    static int r=0;
    private static int acyclic(ArrayList<Integer>[] adj) {
        int a[]=new int[n];
        for(int i=0;i<adj.length;i++){
            for(int j=0;j<n;j++)
            a[j]=-1;
            reach(adj,i,i,a);
            if(r==1)
            break;
        }
        return r;
    }
    
    private static void reach(ArrayList<Integer>[] adj, int x, int y, int a[]) {
        a[x]=x;
        for(int i=0;i<adj[x].size();i++){
            if(adj[x].get(i)==y)
            r=1; 
            if(a[adj[x].get(i)]!=adj[x].get(i))
            reach(adj,adj[x].get(i),y,a);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}

