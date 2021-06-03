    import java.io.*;
    import java.util.*;
    
    public class PhoneBook {
    
        private FastScanner in = new FastScanner();
        private String contacts[] = new String[10000000];
        private int p=0;
        public static void main(String[] args) {
            new PhoneBook().processQueries();
        }
    
        private Query readQuery() {
            String type = in.next();
            int number = in.nextInt();
            if (type.equals("add")) {
                String name = in.next();
                return new Query(type, name, number);
            } else {
                return new Query(type, number);
            }
        }
    
        private void writeResponse(String response) {
            System.out.println(response);
        }
    
    
        private void processQuery(Query query) {
            if (query.type.equals("add"))
            contacts[query.number] = query.name;
            else if (query.type.equals("del")) {
                if(contacts[query.number]!=null)
                contacts[query.number]=null;
            }
            else {
                String response = "not found";
                if (contacts[query.number] != null) 
                response = contacts[query.number];
                writeResponse(response);
            }
        }

    public void processQueries() {
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i)
            processQuery(readQuery());
    }

    static class Query {
        String type;
        String name;
        int number;

        public Query(String type, String name, int number) {
            this.type = type;
            this.name = name;
            this.number = number;
        }

        public Query(String type, int number) {
            this.type = type;
            this.number = number;
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
