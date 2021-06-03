import java.util.*;

class tree_height{
    static int height(Node node){
        if(node==null)
        return 0;
        Queue<Node> q=new LinkedList();
        q.add(node);
        int h=0;
        while(true){
            int c=q.size();
            if(c==0)
            return h;
            h++;
            while(c>0){
                Node n1=q.peek();
                q.remove();
                for(int i=0;i<n1.child.size();i++)
                q.add(n1.child.get(i));
                c--;
            }
        }
    }
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        a[i]=sc.nextInt();
        Node[] nodes=new Node[a.length];
        int root=0;
        for(int i=0;i<a.length;i++)
        nodes[i]=new Node(a[i]);
        for(int i=0;i<a.length;i++){
            if(a[i]==-1)
            root=i;
            else
            nodes[a[i]].child.add(nodes[i]);
        }
        System.out.println(height(nodes[root]));
    }
}

class Node{
    int key;
    ArrayList<Node> child;
    Node(int n){
        key=n;
        child=new ArrayList<Node>();
    }
}