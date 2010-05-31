/*
  ID: mgcclx1
  LANG: JAVA
  TASK: numtri
 */
import java.util.*;
import java.io.*;
public class usaco_numtri { 
    static int n = 0;
	static BufferedWriter out;
    public static void main(String args[]) throws IOException{
	    BufferedReader reader = new BufferedReader(new FileReader("numtri.in"));
	    FileWriter fstream = new FileWriter("numtri.out");
		out = new BufferedWriter(fstream);
		StringTokenizer s;
		s = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(s.nextToken());
		int[][] m = new int[n][n];
		for(int i=0;i<n;i++){
			s = new StringTokenizer(reader.readLine());
			for(int j=0;j<=i;j++){

				m[i][j] = Integer.parseInt(s.nextToken());
			}
		}
		for(int i=1;i<n;i++){
			m[i][0] = m[i-1][0]+m[i][0];
			for(int j=1;j<=i;j++){
				m[i][j] = Math.max(m[i-1][j-1],m[i-1][j])+m[i][j];
			}
		}
		int max = m[0][0];
		for(int i=0;i<n;i++){
			if(m[n-1][i]>max){
				max = m[n-1][i];
			}
		}
		out.write(String.valueOf(max)+"\n");
		out.close();
	}
}


