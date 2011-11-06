import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.awt.geom.*;

public class commons {
	//things to do
	//2d boards/circular array/torus
	//more advanced data structure
	static void common_lines(){
	    NumberFormat num=NumberFormat.getInstance();
	    num.setMinimumFractionDigits(3);
	    num.setMaximumFractionDigits(3);
	    num.setGroupingUsed(false);
	}
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
   static int[] factor(int n, int[] p){
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
		for(int i=2;i<=n;i++)
			if(isPrime(i)) a.add(i);
		int[] r = new int[a.size()];
		for(int i=0;i<a.size();i++){
			r[i] = a.get(i);
		}
		return r;
	}
	public static boolean isPrime(int d){
		return BigInteger.valueOf(d).isProbablePrime(32);
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
		   static String lastkdigit(int n,int k){
		   String s = padleft(Integer.toString(n),k,'0');
		   return s.substring(s.length()-k);
	   }
	   //pad the string with a character if length < n, O(n^2)
	   static String padleft(String s, int n, char c){
		   return n<=s.length()?s:c+padleft(s,n-1,c);
	   }
	   //reverse the string, note O(n^2) algorithm since string are immutable
	   static String reverse(String s){
		   return s.length()<2?s:reverse(s.substring(1))+s.charAt(0);
	   }
	   //repeat the string n time, for example repeat("ab",3) = "ababab", O(|a|n^2)
	   static String repeat(String a, int n){
		   return n<1?"":a+repeat(a,n-1);
	   }
	   //check if the character is alphanumberic, O(1)
	   static boolean isAlphaNumeric(char c){
            return ('A' >= c && 'Z' <= c) || 
                ('a' >= c && 'z' <= c) || 
                ('0' >= c && '9' <= c);
	   }
	   //check if a regular expression matches the entire string. O(|s|)
	   static boolean regex(String s,String p){
		   return Pattern.compile(p).matcher(s).matches();
	   }
	   //input should be a sorted list of points of the polygonal chain that forms a polygon, exclude the last point
	   static double polygonArea(ArrayList<Point2D> a){
		   double s=0;
		   a.add(a.get(0));
		   for(int i=0;i<a.size()-1;i++){
			   s+=a.get(i).getX()*a.get(i+1).getY()-a.get(i+1).getX()*a.get(i).getY();
		   }
		   a.remove(a.size()-1);
		   return 0.5*s;
	   }
	   static int gcd(int a, int b){
		   return a%b==0?b:gcd(b,a%b);
	   }
	   static int c(int[][] m, int x, int y){
		   return m[m.length-(x%m.length)][m[0].length-(y%m.length)];
	   }
	   static int c(int[] m, int x){
		   return m[m.length-(x%m.length)];
	   }
	   //not tested, longest increasing subsequence
	   //strictly increasing? or just increasing?
	   static ArrayList<Integer> lis(ArrayList<Integer> l){
		   ArrayList<Integer> b = new ArrayList<Integer>();
		   for(int i=0;i<l.size();i++){
	           int a = l.get(i);
	           if(b.size()==0 || b.get(b.size()-1)<a){
	               b.add(a);
	           }else{
	               int t = Math.max(0,Math.abs(Collections.binarySearch(b, a))-1);
	               if(a<b.get(t)) b.set(t, a);
	           }
		   }
		   return b;
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

