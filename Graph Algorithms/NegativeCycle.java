import java.util.ArrayList;
import java.util.Scanner;

public class NegativeCycle {
    static int w=0;
    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
       for(int i=0;i<adj.length;i++){
           if(w==1)
           return w;
           else
           check(i,adj,cost);
       }
       return w;
    }
    
    static void check(int t, ArrayList<Integer>[] adj, ArrayList<Integer>[] cost){
        int dist[]=new int[adj.length];
        for(int i=0;i<adj.length;i++)
        dist[i]=Integer.MAX_VALUE;
        dist[t]=0;
        for(int i=0;i<adj.length-1;i++){
            boolean c=false;
            for(int j=0;j<adj.length;j++){
                for(int k=0;k<adj[j].size();k++){
                    if(dist[adj[j].get(k)]>dist[j]+cost[j].get(k) && dist[j]!=Integer.MAX_VALUE){
                        dist[adj[j].get(k)]=dist[j]+cost[j].get(k);
                        c=true;
                    }
                }
            }
            if(c==false)
            break;
        }
        for(int j=0;j<adj.length;j++){
                for(int k=0;k<adj[j].size();k++){
                    if(dist[adj[j].get(k)]>dist[j]+cost[j].get(k) && dist[j]!=Integer.MAX_VALUE){
                        w=1;
                        break;
                    }
                }
                if(w==1)
                break;
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
        System.out.println(negativeCycle(adj, cost));
    }
}

