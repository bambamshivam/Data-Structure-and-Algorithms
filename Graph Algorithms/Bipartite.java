import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        int dist[]=new int[adj.length];
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<adj.length;i++){
            dist[i]=-1;
        }
        int s=0;
        dist[s]=0;
        q.add(s);
        while(q.size()!=0){
            int p=q.remove();
            for(int i=0;i<adj[p].size();i++){
                if(dist[p]==dist[adj[p].get(i)])
                return 0;
                if(dist[adj[p].get(i)]==-1){
                    q.add(adj[p].get(i));
                    dist[adj[p].get(i)]=dist[p]+1;
                }
            }
        }
        return 1;
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
            adj[y - 1].add(x - 1);
        }
        System.out.println(bipartite(adj));
    }
}

