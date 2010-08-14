import java.util.*;

public class uva10440{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int tk = in.nextInt();
		for(int z=0;z<tk;z++){
			int n = in.nextInt();
			int t = in.nextInt();
			int m = in.nextInt();
			int[] a = new int[m];
			for(int i=0;i<m;i++){
				a[i] = in.nextInt();
			}
			int r = m/n;
			if(n*r<m){
				r++;
			}
			System.out.println(f(a,m-1,n,t)-t+" "+r);
		}
	}
	public static int f(int[] a,int m,int n, int t){
		if(m<n){
			return a[m] + 2*t;
		}
		return Math.max(f(a,m-n,n,t),a[m])+2*t;
	}
}
