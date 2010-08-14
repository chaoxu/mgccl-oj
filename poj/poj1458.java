import java.util.*;
public class poj1458{
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			char[] a = in.next().toCharArray();
			char[] x= new char[a.length+1];
			for(int i=0;i<a.length;i++){
				x[i+1] = a[i];
			}
			a = in.next().toCharArray();
			char[] y= new char[a.length+1];
			for(int i=0;i<a.length;i++){
				y[i+1] = a[i];
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
			System.out.println(d[x.length-1][y.length-1]);
		}
	}
}


