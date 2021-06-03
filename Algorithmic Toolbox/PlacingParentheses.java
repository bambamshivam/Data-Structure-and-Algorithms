import java.util.*;

public class PlacingParentheses {
    
    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }
    
    private static long[] mm(int i,int j,long ma[][],long mi[][],String exp){
        long a[]=new long[2];
        long a1=0;
        long b=0;
        long c=0;
        long d=0;
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
        for(int k=i;k<j;k++){
            a1=eval(ma[i][k],ma[k+1][j],exp.charAt(2*k + 1));
            b=eval(ma[i][k],mi[k+1][j],exp.charAt(2*k + 1));
            c=eval(mi[i][k],ma[k+1][j],exp.charAt(2*k + 1));
            d=eval(mi[i][k],mi[k+1][j],exp.charAt(2*k + 1));
            a[0]=Math.min(Math.min(a1,b),Math.min(c,d));
            a[1]=Math.max(Math.max(a1,b),Math.max(c,d));
            if(a[0]<min)
            min=a[0];
            if(a[1]>max)
            max=a[1];
        }
        a[0]=min;
        a[1]=max;
        return a;
    }
    
    private static long getMaximValue(String exp,long ma[][],long mi[][]) {
        int n=(exp.length()-1)/2;
        for(int i=1;i<n+1;i++){
            for(int j=0;j<n+1-i;j++){
                int k=j+i;
                long a[]=mm(j,k,ma,mi,exp);
                mi[j][k]=a[0];
                ma[j][k]=a[1];
            }
        }
        return ma[0][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        int n=(exp.length()-1)/2;
        long mi[][]=new long[n+1][n+1];
        long ma[][]=new long[n+1][n+1];
        for(int i=0;i<n+1;i++){
            mi[i][i]=Integer.parseInt(exp.substring(2*i,2*i +1));
            ma[i][i]=Integer.parseInt(exp.substring(2*i,2*i +1));
        }
        System.out.println(getMaximValue(exp,ma,mi));
    }
}

