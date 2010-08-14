import java.util.*;
public class poj3132 {
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		int[] p = prime_list(1120);
		int[][][] d = new int[1121][15][p.length];
		for(int i=0;i<p.length;i++){
			d[0][0][i]=1;
		}
		d[2][1][0] = 1;
		for(int n=1;n<1121;n++){
			for(int k=1;k<15;k++){
				for(int i=1;i<p.length;i++){
					if(n>=p[i]){
						d[n][k][i] += d[n-p[i]][k-1][i-1];
					}
					d[n][k][i] += d[n][k][i-1];
				}
			}
		}
	 	int n = in.nextInt();
		int k = in.nextInt();
		while(n!=0){
			System.out.println(d[n][k][p.length-1]);
			n = in.nextInt();
			k = in.nextInt();
		}
	}

	public static int[] prime_list(int n){
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=2;i<=n;i++){
			if(is_prime(i)){
				a.add(i);
			}
		}
		int[] r = new int[a.size()];
		for(int i=0;i<a.size();i++){
			r[i] = a.get(i);
		}
		return r;
	}
	public static boolean is_prime(int d){
		int s = (int) Math.sqrt(d);
		for(int i=2;i<=s;i++){
			if(d%i==0){
				return false;
			}
		}
		return true;
	}
}

