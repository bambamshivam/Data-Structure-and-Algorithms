import java.util.*;
import java.io.*;

class window{
    
    static class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
    
    public static int[] win(int arr[],int n, int m){
        Deque<Integer> q=new LinkedList<Integer>();
        int i;
        int a[]=new int[n-m+1];
        for(i=0;i<m;i++){
            while(!q.isEmpty() && arr[i]>=arr[q.peekLast()])
            q.removeLast();
            q.addLast(i);
        }
        int k=0;
        for(;i<n;i++){
            a[k]=arr[q.peek()];
            while(!q.isEmpty() && q.peek()<=i-m)
            q.removeFirst();
            while(!q.isEmpty() && arr[i]>=arr[q.peekLast()])
            q.removeLast();
            q.addLast(i);
            k++;
        }
        a[k]=arr[q.peek()];
        return a;
    }
    
    public static void main(String args[]) throws IOException{
        FastScanner sc=new FastScanner();
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        int m=sc.nextInt();
        int a[]=win(arr,n,m);
        for(int i=0;i<n-m+1;i++)
        System.out.print(a[i] + " ");
    }
}