import java.util.*;
public class combinatorics {
	public static long choose(long n, long r){
		if(n-r>r){
			r = n-r;
		}
		int s = 1;
		for(long i=0, j=1; i<r;i++){
			s*=(n-i);
			for(;j<=r && s%j==0;++j){
				s/=j;
			}
		}
		return s;
	}
	public static long catalan(int n){
		return choose(2*n,n)/(n+1);
	}
}
