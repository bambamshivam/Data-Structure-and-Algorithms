    import java.util.ArrayList;
    import java.util.Scanner;
    
    public class Reachability {
        static int a[];
        private static void reach(ArrayList<Integer>[] adj, int x, int y) {
        a[x]=x;
        for(int i=0;i<adj[x].size();i++){
            if(a[adj[x].get(i)]!=adj[x].get(i))
            reach(adj,adj[x].get(i),y);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        reach(adj, x, y);
        if(a[y]==y)
        System.out.println(1);
        else
        System.out.println(0);
    }
}

