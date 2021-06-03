import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int k=1;
        while(n>0){
            summands.add(k);
            n-=k;
            k+=1;
            for(int i=0;i<summands.size();i++){
                if(n==summands.get(i)){
                    summands.set(summands.size() - 1, summands.get(summands.size() - 1) + n);
                    n=0;
                    break;
                }
            }
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

