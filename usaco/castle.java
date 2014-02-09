/*
ID: mgcclx1
LANG: JAVA
TASK: castle
*/
import java.util.*;
import java.io.*;
public class castle {
    static int[][] g;
    static int[][] c;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));

        Scanner in = new Scanner(f);
        m = in.nextInt();
        n = in.nextInt();
        g = new int[n][m];
        c = new int[n][m];
        ArrayList<Integer> s = new ArrayList<Integer>();// size of each component
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                g[i][j] = in.nextInt();
            }
        }
        int component = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(c[i][j]==0){
                    int t = flood(i,j,component++);
                    s.add(t);
                }
            }
        }

        int max = 0;
        for(int o:s){
            max = Math.max(max,o);
        }
        out.println(s.size());
        out.println(max);
        int bestx=0,besty=0;
        char bestf='N';
        for(int j=0;j<m;j++){
            for(int i=n-1;i>=0;i--){
                // try north
                int t = s.get(c[i][j]-1);
                if(i-1>=0 && c[i-1][j]!=c[i][j]){
                    if(max<t+s.get(c[i-1][j]-1)){
                        max = t+s.get(c[i-1][j]-1);
                        bestx = i+1;
                        besty = j+1;
                        bestf = 'N';
                    }

                }
                // try east
                if(j+1<m && c[i][j+1]!=c[i][j]){
                    if(max<t+s.get(c[i][j+1]-1)){
                        max = t+s.get(c[i][j+1]-1);
                        bestx = i+1;
                        besty = j+1;
                        bestf = 'E';
                    }
                }
            }
        }

        out.println(max);
        out.println(bestx+" "+besty+" "+bestf);
        out.close();
        System.exit(0);
    }

    public static int flood(int i, int j, int comp){
        int t = 1;
        c[i][j] = comp;
        // try north
        if(i-1>=0 && (g[i][j] & 2)==0 && c[i-1][j]!=comp){
            t+=flood(i-1,j,comp);
        }
        // try south
        if(i+1<n && (g[i][j] & 8)==0 && c[i+1][j]!=comp){
            t+=flood(i+1,j,comp);
        }
        // try west
        if(j-1>=0 && (g[i][j] & 1)==0 && c[i][j-1]!=comp){
            t+=flood(i,j-1,comp);
        }
        // try east
        if(j+1<m && (g[i][j] & 4)==0 && c[i][j+1]!=comp){
            t+=flood(i,j+1,comp);
        }
        return t;
    }
}
