import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    static Queue<Integer> q;
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        int used[]=new int[adj.length];
        int dist[]=new int[adj.length];
        q=new LinkedList<Integer>();
        for(int i=0;i<adj.length;i++){
            dist[i]=-1;
            used[i]=-1;
        }
        dist[s]=0;
        q.add(s);
        while(q.size()!=0){
            int p=q.remove();
            for(int i=0;i<adj[p].size();i++){
                if(dist[adj[p].get(i)]==-1){
                    q.add(adj[p].get(i));
                    dist[adj[p].get(i)]=dist[p]+1;
                }
            }
        }
        return dist[t];
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

