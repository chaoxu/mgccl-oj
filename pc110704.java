import java.util.*;
import java.math.*;
public class pc110704 {
	static int[] p = new int[4792];
	static int m = 0;
	static int mf = 0;
	public static void main (String args[]){
		int o = 0;
		for(int i=2;i<46340;i++){
			boolean prime = true;
			for(int j=2;j<=Math.sqrt(i);j++){
				if(i%j==0){
					prime = false;
					break;
				}
			}
			if(prime){
				p[o] = i;
				o++;
			}
		}
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int f = in.nextInt();
			int n = in.nextInt();
			boolean d = false;
			BigInteger b = BigInteger.valueOf(n);
			if(f>=n){
				if(n!=0){
					d = true;
				}
			}else if(b.isProbablePrime(10)){
				d = false;
			}else{
				d = divide(f,n);
			}
			if(d){
				System.out.println(n+" divides "+f+"!");
			}else{
				System.out.println(n+" does not divide "+f+"!");
			}
		}
	}
	
	static boolean divide(int f, int n){
		int[] a = factor(n);
		int[] b = factorial_factor(f);
		if(m>mf){
			return false;
		}
		for(int i=0;i<=m;i++){
			for(int j=0;j<a[i];j++){
				n=n/p[i];
			}
			if(b[i]<a[i]){
				return false;
			}
		}
		if(n>f&&n!=1){
			return false;
		}
		return true;
	}
	
	static int[] factor(int n){
		int k = n;
		int[] f = new int[p.length];
		for(int i=0;i<p.length;i++){
			while(k%p[i]==0){
				k = k/p[i];
				f[i]++;
				m = i;
			}
			if(k==1){
				break;
			}
		}
		return f;
	}
	
	static int[] factorial_factor(int n){
		int[] f = new int[p.length];
		for(int i=0;i<=m;i++){
			long d = p[i];
			while(n/d!=0){
				f[i]+= n/d;
				d*=p[i];
				mf = i;
			}
		}
		return f;
	}
}
