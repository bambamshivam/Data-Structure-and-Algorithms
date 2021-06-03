import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StronglyConnected {
    static ArrayList<Integer> order;
    static ArrayList<Integer>[] adj1;
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        order=new ArrayList<Integer>();
        int c=0;
        int used[]=new int[adj.length];
        for(int i=0;i<adj.length;i++)
        used[i]=-1;
        int used1[]=new int[adj.length];
        for(int i=0;i<adj.length;i++)
        used1[i]=-1;
        dfs(adj1,used);
        for(int i=order.size()-1;i>=0;i--){
            if(used1[order.get(i)]==-1){
                c++;
                reach1(adj,order.get(i),used1);
            }
        }
        return c;
    }
    
    private static void dfs(ArrayList<Integer>[] adj1, int[] used) {
        for(int i=0;i<adj1.length;i++){
            if(used[i]!=i)
            reach(adj1,i,used);
        }
    }
    
    private static void reach(ArrayList<Integer>[] adj1, int x, int a[]) {
        a[x]=x;
        for(int i=0;i<adj1[x].size();i++){
            if(a[adj1[x].get(i)]!=adj1[x].get(i))
            reach(adj1,adj1[x].get(i),a);
        }
        order.add(x);
    }
    
    private static void reach1(ArrayList<Integer>[] adj, int x, int a[]) {
        a[x]=x;
        for(int i=0;i<adj[x].size();i++){
            if(a[adj[x].get(i)]!=adj[x].get(i))
            reach1(adj,adj[x].get(i),a);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        adj1 = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            adj1[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj1[y - 1].add(x - 1);
        }
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}

