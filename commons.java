import java.math.BigInteger;
import java.text.*;
import java.util.*;


public class commons {
	
	static void common_lines(){
	    NumberFormat num=NumberFormat.getInstance();
	    num.setMinimumFractionDigits(3);
	    num.setMaximumFractionDigits(3);
	    num.setGroupingUsed(false);
	}
    static int[] extended_gcd(int a, int b, int s1, int t1, int s2, int t2){		
        if(a*s1+b*t1==1){
        	int[] m = {s1,t1};
        	return m;
        }
        int r = (s2*a+t2*b)/(s1*a+t1*b);
        s2 = (s2-r*s1);
        t2 = (t2-r*t1);
        return extended_gcd(a, b, s2, t2, s1, t1);
   }
   static int gcd(int a, int b){
        if(a%b==0)
     	   return b;
        return gcd(b, a%b);
   }
   static int[] digit(int n, int m){
	   ArrayList<Integer> a = new ArrayList<Integer>();
	   while(n>0){
		   a.add(n%m);
		   n/=m;
	   }
	   int[] r = new int[a.size()];
	   for(int i=0;i<a.size();i++){
		   r[i] = a.get(i);
		   
	   }
	   return r;
   }
   static int[] factor(int n){
	    // p is a list of prime numbers
		int k = n;
		int[] f = new int[p.length];
		for(int i=0;i<p.length;i++){
			while(k%p[i])==0){
				k = k/p[i];
				f[i]++;
			}
		}
		return f;
	}
   public static long pow_mod(int a,int e,int n){
   	long t = 1;
   	if(e==0){
   		return t;
   	}
   	long sq = pow_mod(a,e/2,n);
   	t = (sq*sq)%n;
	    if(e%2==1){
	    	t*=a;
	    }
	    return t%n;
   }
   
	public static int digit_sum(int n, int b){
		int s = 0;
		while(n!=0){
			s+=n%b;
			n/=b;
		}
		return s;
	}
   public static double angle(double x, double y){
		if(x>0&&y>=0){
			return Math.atan(y/x);
		}
		if(x>0&&y<0){
			return Math.atan(y/x)+2.0*Math.PI;
		}
		if(x<0){
			return Math.atan(y/x)+Math.PI;
		}
		if(x==0&&y<0){
			return 1.5*Math.PI;
		}
		if(x==0&&y>0){
			return Math.PI*0.5;
		}
		return 0.0;
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
	public static int[] prime_seive(int n){
		ArrayList<Integer> p = new ArrayList<Integer>();
		boolean[] a = new boolean[n+1];
		for (int i=2;i<=n;i++){
			if (!a[i]){
				p.add(i);
			}
			for (int j=1;((j<=p.size()) && (i*p.get(j-1)<=n)); j++){
				a[i*p.get(j-1)] = true ;
				if (i%p.get(j-1) == 0) break;
			}
		}
		int[] b = new int[p.size()];
		for(int i=0;i<b.length;i++){
			b[i] = p.get(i);
		}
		return b;
	}
	public static long choose(int n, int r){
		if(n-r>r){
			r = n-r;
		}
		int s = 1;
		for(int i=0, j=1; i<r;i++){
			s*=(n-i);
			for(;j<=r && s%j==0;++j){
				s/=j;
			}
		}
		return s;
	}
	
	public static String string_pad_left(String s, int n, char c){
		char[] t = new char[n];
		for(int i=0;i<n-s.length();i++){
			t[i] = c;
		}
		char[] p = s.toCharArray();
		for(int i=n-p.length;i<n;i++){
			t[i] = p[i-(n-p.length)];
		}
		return String.valueOf(t);
	}
	public static int sum(int[] a){
		int sum = 0;
		for(int i=0;i<a.length;i++){
			sum+=a[i];
		}
		return sum;
	}
	public static int prod(int[] a){
		return prodmod(a,2147483647);
	}
	public static int prodmod(int[] a, int k){
		int prod = 1;
		for(int i=0;i<a.length;i++){
			prod*=(a[i]%k);
			prod%=k;
		}
		return prod;
	}
	public static long prod(long[] a){
		return prodmod(a,9223372036854775807L);
	}
	public static long prodmod(long[] a, long k){
		long prod = 1;
		for(int i=0;i<a.length;i++){
			prod*=(a[i]%k);
			prod%=k;
		}
		return prod;
	}
}

class sorttemplate implements Comparator<int[]>{
    public int compare(int[] o1, int[] o2) {
    	if(o1[0]>o2[0]){
    		return 1;
    	}
    	if(o1[0]<o2[0]){
    		return -1;
    	}
    	return 0;
    }
}
class sorttemplate2 implements Comparator<int[]>{
    public int compare(int[] o1, int[] o2) {
    	for(int i=0;i<o1.length;i++){
			if(o1[i]>o2[i]){
    			return 1;
    		}
    		if(o1[i]<o2[i]){
    			return -1;
    		}
		}
		return 0;
	}
}
