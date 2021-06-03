import java.util.*;
        
public class ShortestPaths {
    private static void shortestPaths(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, long[] dist, int[] shortest) {
        int prev[]=new int[adj.length];
        int used[]=new int[adj.length];
        for(int i=0;i<adj.length;i++){
            dist[i]=Integer.MAX_VALUE;
            used[i]=-1;
        }
        dist[s]=0;
        for(int i=0;i<adj.length-1;i++){
            boolean f=false;
            for(int j=0;j<adj.length;j++){
                for(int k=0;k<adj[j].size();k++){
                    if(dist[adj[j].get(k)]>dist[j]+cost[j].get(k) && dist[j]!=Integer.MAX_VALUE){
                        dist[adj[j].get(k)]=dist[j]+cost[j].get(k);
                        prev[adj[j].get(k)]=j;
                        f=true;
                    }
                }
            }
            if(f==false)
            break;
        }
        int c=-1;
        ArrayList<Integer> cycle=new ArrayList<>();
        for(int j=0;j<adj.length;j++){
            for(int k=0;k<adj[j].size();k++){
                if(dist[adj[j].get(k)]>dist[j]+cost[j].get(k) && dist[j]!=Integer.MAX_VALUE)
                cycle.add(adj[j].get(k));
            }
        }
        for(int i=0;i<cycle.size();i++){
            if(shortest[cycle.get(i)]==1)
            reach(adj,cycle.get(i),shortest);
        }
    }
    
    private static void reach(ArrayList<Integer>[] adj, int x, int a[]) {
        a[x]=0;
        for(int i=0;i<adj[x].size();i++){
            if(a[adj[x].get(i)]==1)
            reach(adj,adj[x].get(i),a);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int s = scanner.nextInt() - 1;
        long dist[] = new long[n];
        int shortest[] = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
            shortest[i] = 1;
        }
        shortestPaths(adj, cost, s, dist, shortest);
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println('*');
            } else if (shortest[i] == 0) {
                System.out.println('-');
            } else {
                System.out.println(dist[i]);
            }
        }
    }

}

