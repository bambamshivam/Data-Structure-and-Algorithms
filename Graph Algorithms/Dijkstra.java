import java.util.*;

public class Dijkstra {
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        int dist[]=new int[adj.length];
        int used[]=new int[adj.length];
        for(int i=0;i<adj.length;i++){
            dist[i]=Integer.MAX_VALUE;
            used[i]=-1;
        }
        dist[s]=0;
        for(int k=0;k<adj.length-1;k++){
            int u=min(dist,used);
            used[u]=u;
            for(int i=0;i<adj[u].size();i++){
                if(dist[adj[u].get(i)]>dist[u]+cost[u].get(i) && used[adj[u].get(i)]==-1 && dist[u]!=Integer.MAX_VALUE)
                dist[adj[u].get(i)]=dist[u]+cost[u].get(i);
            }
        }
        if(dist[t]!=Integer.MAX_VALUE)
        return dist[t];
        else
        return -1;
    }
    
    static int min(int dist[],int used[]){
        int m=Integer.MAX_VALUE;
        int min_index=-1;
        for(int i=0;i<dist.length;i++){
            if(used[i]==-1 && dist[i]<=m){
                m=dist[i];
                min_index=i;
            }
        }
        return min_index;
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

