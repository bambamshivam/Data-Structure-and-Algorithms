import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    static int a[];
    static ArrayList<Integer>[] adj;
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
       int cc=0;
       for(int i=0;i<adj.length;i++){
           if(a[i]!=i){
               cc++;
               reach(adj,i);
           }
       }
       return cc;
    }
    
    private static void reach(ArrayList<Integer>[] adj, int x) {
        a[x]=x;
        for(int i=0;i<adj[x].size();i++){
            if(a[adj[x].get(i)]!=adj[x].get(i))
            reach(adj,adj[x].get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        adj = (ArrayList<Integer>[])new ArrayList[n];
        a=new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            a[i]=-1;
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

