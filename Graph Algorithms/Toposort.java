import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {
    static ArrayList<Integer> order;
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        int used[] = new int[adj.length];
        for(int i=0;i<adj.length;i++)
        used[i]=-1;
        order = new ArrayList<Integer>();
        dfs(adj,used,order);
        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order) {
        for(int i=0;i<adj.length;i++){
            if(used[i]!=i)
            reach(adj,i,used);
        }
    }
    
    private static void reach(ArrayList<Integer>[] adj, int x, int a[]) {
        a[x]=x;
        for(int i=0;i<adj[x].size();i++){
            if(a[adj[x].get(i)]!=adj[x].get(i))
            reach(adj,adj[x].get(i),a);
        }
        order.add(x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
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
        ArrayList<Integer> order = toposort(adj);
        int p=order.size()-1;
        while(p>=0) {
            System.out.print((order.get(p) + 1) + " ");
            p--;
        }
    }
}

