import java.util.*;
import java.io.*;
public class poj1163 { 
    public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s;
		s = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(s.nextToken());
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
		System.out.println(max);
	}
}


