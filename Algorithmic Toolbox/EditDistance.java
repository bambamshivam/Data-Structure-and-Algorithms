import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int s1=s.length();
    int t1=t.length();
    int ar[][]=new int[s1+1][t1+1];
    for(int i=0;i<s1+1;i++)
    ar[i][0]=i;
    for(int i=0;i<t1+1;i++)
    ar[0][i]=i;
    for(int i=1;i<s1+1;i++){
        for(int j=1;j<t1+1;j++){
            if(s.charAt(i-1)==t.charAt(j-1))
            ar[i][j]=Math.min(ar[i-1][j]+1,Math.min(ar[i][j-1]+1,ar[i-1][j-1]));
            else
            ar[i][j]=Math.min(ar[i-1][j]+1,Math.min(ar[i][j-1]+1,ar[i-1][j-1]+1));
        }
    }
    return ar[s1][t1];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
