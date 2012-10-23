import java.util.*;
public class LCS {
	public static int[][] table(int[] x, int[] y){
		int n = x.length;
		int m = y.length;
		int[][] d = new int[n+1][m+1];
		for(int i=1;i<n+1;i++){
			for(int j=1;j<m+1;j++){
				if(x[i-1]==y[j-1]){
					d[i][j] = d[i-1][j-1]+1;
				}else{
					d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
				}
			}
		}
		return d;
	}
	public static int lcs(int[] x, int[] y){
		return table(x,y)[x.length][y.length];
	}
	
	public static int[] LCS(int[] x, int[] y){
		ArrayList<Integer> a = rec(x.length,y.length,x,y,table(x,y));
		int[] r = new int[a.size()];
		for(int i=0;i<a.size();i++){
			r[i]=a.get(i);
		}
		return r;
	}
	public static ArrayList<Integer> rec(int i, int j, int[] x, int[] y, int[][] d){
		ArrayList<Integer> a = new ArrayList<Integer>();
		if(i!=0&&j==0){
			if(x[i-1]==y[j-1]){
		        a=rec(i-1,j-1,x,y, d);
		        a.add(x[i-1]);
			}else if(d[i-1][j]>d[i][j-1]){
				a=rec(i-1,j,x,y,d);
			}else{
				a=rec(i,j-1,x,y,d);
			}
		}
		return a;
	}
}
