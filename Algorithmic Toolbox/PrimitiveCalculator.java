import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int ar[]=new int[n+1];
        ar[1]=0;
        List<Integer> sequence = new ArrayList<Integer>();
        List<Integer> sequence1 = new ArrayList<Integer>();
        for(int i=2;i<n+1;i++){
            ar[i]=i+1;
            if (i % 3 == 0)
            sequence.add(3);
            if (i % 2 == 0)
            sequence.add(2);
            sequence.add(1);
            for(int j=0;j<sequence.size();j++){
               int k=sequence.get(j);
               int num=0;
               if(k==1 && i-1>=1)
               num=ar[i-1]+1;
               if(k==2 && i/2>=1)
               num=ar[i/2]+1;
               if(k==3 && i/3>=1)
               num=ar[i/3]+1;
               if(num<ar[i])
               ar[i]=num;
            }
            sequence.clear();
        }
        int p=n;
        sequence1.add(n);
        while(p>1){
            int t=n;
            if(p%3==0 && ar[p/3]<ar[t])
            t=p/3;
            if(p%2==0 && ar[p/2]<ar[t])
            t=p/2;
            if(ar[p-1]<ar[t])
            t=p-1;
            sequence1.add(t);
            p=t;
        }
        Collections.reverse(sequence1);
        return sequence1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

