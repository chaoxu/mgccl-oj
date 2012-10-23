import java.util.ArrayList;


public class nt {
    static int[] extended_gcd(int a, int b, int s1, int t1, int s2, int t2){
    	int[] m = {s1,t1};
        if(a*s1+b*t1!=1){
            int r = (s2*a+t2*b)/(s1*a+t1*b);
            s2 = (s2-r*s1);
            t2 = (t2-r*t1);
            m = extended_gcd(a, b, s2, t2, s1, t1);
        }
        return m;
   }
	//Find the digits of n in base b.
    static ArrayList<Integer> digit(int n, int b){
    	ArrayList<Integer> z = new ArrayList<Integer>();
    	if(n>0){
    		z = digit(n/b, b);
    		z.add(n%b);
    	}
    	return z;
    }
   static int[] factorbasis(int n, int[] p){
	    // p is a list of prime numbers
		int k = n;
		int[] f = new int[p.length];
		for(int i=0;i<p.length;i++){
			while((k%p[i])==0){
				k = k/p[i];
				f[i]++;
			}
		}
		return f;
	}
   static int[] factor(int n, int[] p){
	    int k = n;
	    ArrayList<Integer> f = new ArrayList<Integer>();
		int i = 0;
		while(k!=1){
			while((k%p[i])==0){
				k = k/p[i];
				f.add(p[i]);
			}
			i++;
		}
		int[] b = new int[f.size()];
		for(int j=0;j<f.size();j++){
			b[j] = f.get(j);
		}
		return b;
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
}
