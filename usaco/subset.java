/*
ID: mgcclx1
LANG: JAVA
TASK: subset
*/
import java.util.*;
import java.io.*;
public class subset {
    static int[][] g;
    static int[][] c;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("subset.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));

        Scanner in = new Scanner(f);
        n = in.nextInt();

        int m = (n*(n+1))/4;
        long[][] d = new long[m+1][n+1];
        for(int j=0;j<n;j++){
            d[0][j]=1;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                d[i][j] = d[i][j-1];
                if(i-j>=0){
                    d[i][j] += d[i-j][j-1];
                }
            }
        }
        if(((n*(n+1))/2)%2!=0){
            d[m][n]=0;
        }
        out.println(d[m][n]/2);
        out.close();
        System.exit(0);
    }
}
