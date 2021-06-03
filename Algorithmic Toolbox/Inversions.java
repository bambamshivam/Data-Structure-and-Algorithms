import java.util.*;

public class Inversions {
    static int d=0;
    public static int[] merge(int a[],int b[],int z){
        int n=a.length + b.length;
        int c[]=new int[n];
        int i=0;
        int j=0;
        int k=0;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                c[k]=a[i];
                i++;
            }
            else{
                c[k]=b[j];
                d+=(a.length-i);
                j++;
            }
            k++;
        }
        while(i<a.length){
            c[k]=a[i];
            k++;
            i++;
        }
        while(j<b.length){
            c[k]=b[j];
            j++;
            k++;
        }
        if(n==z)
        System.out.println(d);
        return c;
    }

    public static int[] gnoi(int[] a,int n) {
        if(a.length==1)
        return a;
        else{
            int n1=a.length;
            int n2=n1/2;
            int n3=n1-n2;
            int b[]=new int[n2];
            int c[]=new int[n3];
            for(int i=0;i<n2;i++)
            b[i]=a[i];
            for(int i=0;i<n3;i++)
            c[i]=a[n2+i];
            return merge(gnoi(b,n),gnoi(c,n),n);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int b[]=gnoi(a,n);
    }
}

