import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int min[]=new int[m+1];
        int coins[]={1,3,4};
        min[0]=0;
        for(int i=1;i<m+1;i++){
            min[i]=m+1;
            for(int j=0;j<3;j++){
                if(i>=coins[j]){
                    int numCoin=min[i-coins[j]]+1;
                    if(numCoin<min[i])
                    min[i]=numCoin;
                }
            }
        }
        return min[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

