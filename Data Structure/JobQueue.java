import java.io.*;
import java.util.StringTokenizer;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private worker[] q;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        q=new worker[numWorkers];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
        for (int i = 0; i < numWorkers; ++i) {
            q[i]=new worker(i,0);
        }
    }

    private void assignJobs() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(q[0].num + " " + q[0].finish_time);
            q[0].finish_time+=jobs[i];
            siftdown(0);
        }
    }
    
    private void siftdown(int i){
        int min=i;
        int l=2*i +1;
        if(l<numWorkers && q[l].finish_time<q[min].finish_time)
        min=l;
        int r=2*i +2;
        if(r<numWorkers && q[r].finish_time<q[min].finish_time)
        min=r;
        if(l<numWorkers && q[l].finish_time==q[min].finish_time && q[l].num<q[min].num)
        min=l;
        if(r<numWorkers && q[r].finish_time==q[min].finish_time && q[r].num<q[min].num)
        min=r;
        if(min!=i){
            worker temp=q[min];
            q[min]=q[i];
            q[i]=temp;
            siftdown(min);
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        out.close();
    }
    
    class worker{
        int num;
        long finish_time;
        worker(int num,long finish_time){
            this.num=num;
            this.finish_time=finish_time;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
