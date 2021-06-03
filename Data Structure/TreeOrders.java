import java.util.*;
import java.io.*;


    
    public class TreeOrders {
        int n;
        static Node nodes[];
        void read() throws IOException{
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
            }
        }

        void inOrder() {
            if(nodes[0]==null)
            return;
            Stack<Node> s=new Stack<Node>();
            Node curr=nodes[0];
            while(curr!=null || s.size()>0){
                while(curr!=null){
                    s.push(curr);
                    curr=curr.left;
                }
                curr=s.pop();
                System.out.print(curr.key + " ");
                curr=curr.right;
            }
        }

        void preOrder() {
            if(nodes[0]==null)
            return;
            Stack<Node> s=new Stack<Node>();
            s.push(nodes[0]);
            while(!s.isEmpty()){
                Node n=s.peek();
                System.out.print(n.key + " ");
                s.pop();
                if(n.right!=null)
                s.push(n.right);
                if(n.left!=null)
                s.push(n.left);
            }
        }

        void postOrder() {
            if(nodes[0]==null)
            return;
            Stack<Node> s1=new Stack<Node>();   
            Stack<Node> s2=new Stack<Node>();
            s1.push(nodes[0]);
            while(!s1.isEmpty()){
                Node n=s1.pop();
                s2.push(n);
                if(n.left!=null)
                s1.push(n.left);
                if(n.right!=null)
                s1.push(n.right);
            }
            while(!s2.isEmpty()){
                Node t=s2.pop();
                System.out.print(t.key + " " );
            }
        }
    
        static public void main(String[] args) throws IOException {
            TreeOrders tree=new TreeOrders(); 
            tree.read();
            tree.inOrder();
            System.out.println();
            tree.preOrder();
            System.out.println();
            tree.postOrder();
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
    
    class Node{
        int key;
        Node left;
        Node right;
        Node(){
            this.key=0;
            this.left=null;
            this.right=null;
        }
    }

    
