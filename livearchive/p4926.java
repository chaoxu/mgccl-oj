import java.util.*;
public class p4926 {
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int z = 0;
	int n = in.nextInt();
	while(n!=0){
		z++;
		int t = in.nextInt();
		in.nextLine();
		int[][] m = new int[n][n];
		for(int i=0; i<n; i++){
			String s = in.nextLine();
			for(int j=0; j<n; j++){
				m[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
		solve(0,0,n,m,t);
	    System.out.println("Image "+z+":");
		for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			System.out.print(m[i][j]);
		}
		System.out.println();
		}
		n = in.nextInt();
	}
}

public static void solve(int a, int b, int n, int[][] m, int t){
	int s =0;
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			s+= m[a+i][b+j];
		}
	}
	s*=100;
	int d = 2;
	if(s >= n*n*t){
		d = 1;
	} else if (s <= n*n*(100-t)){
		d = 0;
	}
	if(d==2){
	    n=n/2;
		solve(a,b,n,m,t);
		solve(a+n,b,n,m,t);
		solve(a,b+n,n,m,t);
		solve(a+n,b+n,n,m,t);
		return;
	}
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			m[a+i][b+j]=d;
		}
	}
}
}
