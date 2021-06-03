import java.util.*;
import java.io.*;

public class StackWithMax {
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

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(-1);
        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value1 = scanner.nextInt();
                stack.push(value1);
                int value=stack1.peek();
                if(value1>=value)
                stack1.add(value1);
            } else if ("pop".equals(operation)) {
                int value2=stack.peek();
                stack.pop();
                int value3=stack1.peek();
                if(value2==value3)
                stack1.pop();
            } else if ("max".equals(operation)) {
                int value4=stack1.peek();
                System.out.println(value4);
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
