import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int n=stops.length;
        int j=-1;
        int start=0;
        int fills=0;
        int ar[]=new int[n+1];
        for(int i=0;i<n;i++)
        ar[i]=stops[i];
        ar[n]=dist;
        while(j<n){
            int k=j;
            start=start+tank;
            for(int i=k+1;i<n+1;i++){
                if(ar[i]<=start)
                j+=1;
            }
            if(k==j)
            return -1;
            else{
                if(j!=n)
                fills+=1;
                start=ar[j];
            }
        }
        return fills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
