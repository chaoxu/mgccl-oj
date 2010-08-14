/*
ID: mgcclx1
LANG: JAVA
TASK: castle
*/
import java.util.*;
import java.io.*;
public class castle{
    static BufferedWriter out;
	public static void main(String args[]) throws IOException{
    	Scanner in = new Scanner(new File("castle.in"));
    	FileWriter fstream = new FileWriter("castle.out");
        out = new BufferedWriter(fstream);
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] g = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				g[i][j] = in.nextInt();
			}
		}
	}
}
