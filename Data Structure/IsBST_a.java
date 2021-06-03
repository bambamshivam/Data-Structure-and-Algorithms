import java.util.*;
import java.io.*;



public class IsBST_a {
    

    int n;
    static Node[] nodes;
    int m;
    void read() throws IOException {
        FastScanner in = new FastScanner();
        n = in.nextInt();
        nodes=new Node[n];
        for (int i = 0; i < n; i++)
        nodes[i]=new Node();
        for (int i = 0; i < n; i++) { 
            nodes[i].key=in.nextInt();
            int p=in.nextInt();
            if(p!=-1)
            nodes[i].left=nodes[p];
            int q=in.nextInt();
            if(q!=-1)
            nodes[i].right=nodes[q];
            nodes[i].ind=i;
        }
    }

    boolean isBinarySearchTree() {
        if(n==0)
        return true;
        int ar[]=new int[n];
        int i=0;
        if(nodes[0]==null)
        return true;
        Stack<Node> s=new Stack<Node>();
        Node curr=nodes[0];
        while(curr!=null || s.size()>0){
            while(curr!=null){
                if(curr.left!=null && curr.left.key==curr.key)
                nodes[curr.left.ind].key+=1;
                s.push(curr);
                curr=curr.left;
            }
            curr=s.pop();
            
            ar[i]=curr.key;
            i++;
            curr=curr.right;
        }
        for(int j=0;j<n-1;j++){
            if(ar[j]>ar[j+1])
            return false;
        }
        return true;
    }

    static public void main(String[] args) throws IOException {
        IsBST_a tree = new IsBST_a();
        tree.read();
        if (tree.isBinarySearchTree()){
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}

class FastScanner {
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

class Node {
         int key;
         int ind;
         Node left;
         Node right;
         Node() {
              this.left = null;
              this.right = null;
              this.key = 0;
              this.ind=0;
         }
    }

