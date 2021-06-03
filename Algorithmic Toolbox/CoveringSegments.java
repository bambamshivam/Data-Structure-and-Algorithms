import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        int n=segments.length;
        int points1[]=new int[n];
        for(int i=0;i<n;i++)
        points1[i]=segments[i].start;
        Arrays.sort(points1);
        int points[]=new int[2*n];
        for(int i=0;i<n;i++){
            points[2*i]=points1[i];
            for(int j=0;j<n;j++){
                if(segments[j].start==points1[i]){
                    points[2*i +1]=segments[j].end;
                    segments[j].start=-2;
                    break;
                }
            }
        }
        for(int p=0;p < 2*n -2;p+=2){
            for(int j=p+2;j<2*n;j+=2){
                if(Math.max(points[p],points[j])<=Math.min(points[p+1],points[j+1])){
                    points[j]=Math.max(points[p],points[j]);
                    points[j+1]=Math.min(points[p+1],points[j+1]);
                    points[p]=-1;
                    points[p+1]=-1;
                    break;
                }
            }
        }
        int q=0;
        for(int i=0;i<2*n;i+=2){
            if(points[i]!=-1)
            q++;
        }
        int j=0;
        int ar[]=new int[q];
        for(int k=0;k<2*n;k+=2){
            if(points[k]!=-1){
                ar[j]=points[k+1];
                j++;
            }
        }
        return ar;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int i=0;i<points.length;i++) 
        System.out.print(points[i] + " ");
    }
}
 
