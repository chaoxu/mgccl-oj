import java.util.*;
public class uva10066{
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		int c = 0;
		while(in.hasNext()){
			int n = in.nextInt();
			int m = in.nextInt();
			if(n==0&&m==0){
				break;
			}
			int[] x= new int[n+1];
			for(int i=0;i<n;i++){
				x[i+1] = in.nextInt();
			}
			int[] y= new int[m+1];
			for(int i=0;i<m;i++){
				y[i+1] = in.nextInt();
			}
			int[][] d = new int[x.length][y.length];
			for(int i=1;i<x.length;i++){
				for(int j=1;j<y.length;j++){
					d[i][j] = Math.max(d[i-1][j],d[i][j-1]);
					if(x[i]==y[j]){
						d[i][j] = d[i-1][j-1]+1;
					}
				}
			}
			c++;
			System.out.println("Twin Towers #"+c);
			System.out.println("Number of Tiles : "+d[x.length-1][y.length-1]);
			System.out.println();
		}
	}
}


