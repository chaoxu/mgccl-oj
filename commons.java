import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.awt.geom.*;
//Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

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
	static int[] prime_list(int n){
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=2;i<=n;i++)
			if(isPrime(i)) a.add(i);
		int[] r = new int[a.size()];
		for(int i=0;i<a.size();i++)
			r[i] = a.get(i);
		return r;
	}
	static boolean isPrime(int d){
		return BigInteger.valueOf(d).isProbablePrime(32);
	}
	//likely not useful, java can run for 2 min
	static int[] prime_seive(int n){
		ArrayList<Integer> p = new ArrayList<Integer>();
		boolean[] isPrime = new boolean[n + 1];
	    for (int i = 2; i <= n; i++) {
	        isPrime[i] = true;
	    }
	    for (int i = 2; i*i <= n; i++) {
	        if (isPrime[i]) {
	            for (int j = i; i*j <= n; j++) {
	                isPrime[i*j] = false;
	            }
	        }
	    }
        for (int i = 2; i <= n; i++) {
	        if (isPrime[i]) {
	            p.add(i);
	        }
        }
		int[] b = new int[p.size()];
		for(int i=0;i<b.length;i++){
			b[i] = p.get(i);
		}
		return b;
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
	   //thx to 
	   static String reverse(String s){
		   return (new StringBuilder(s)).reverse().toString();
	   }
	   //repeat the string n time, for example repeat("ab",3) = "ababab", O(|a|n^2)
	   static String repeat(String a, int n){
		   return n<1?"":a+repeat(a,n-1);
	   }
	   //check if the character is alphanumberic, O(1)
	   static boolean isAlphaNumeric(char c){
		   return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".indexOf(c)!=-1;
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
	   
	   static void p(int[] a){
		   for(int i=0;i<a.length;i++){
			   System.out.print(a[i]+" ");
		   }
		   System.out.println();
	   }
		public static int nextInt(InputStream in){
		    int ret = 0;
		    boolean dig = false;

		    try {
				for (int c = 0; (c = in.read()) != -1; ) {
				    if (c >= '0' && c <= '9') {
				        dig = true;
				        ret = ret * 10 + c - '0';
				    } else if (dig) break;
				}
			} catch (IOException e) {}
		    return ret;
		}

		@SuppressWarnings({"unchecked"})
		public static <E> E[] CollectionToArray(Collection<E> c){
			E[] a =(E[]) new Object[c.size()];
			Iterator itr = c.iterator();
			int i=0;
			while(itr.hasNext()){
				a[i] = (E) itr.next();
				i++;
			}
			return a;
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
//untested
class UnionFind {
	int[] s;
	UnionFind(int n){
		s = new int[n];
		for(int i=0;i<n;i++){
			s[i]=i;
		}
	}
	public int find(int x){
		if(s[x]==x){
			return x;
		}
		s[x]=find(s[x]);
		return s[x];
	}
	public void union(int x, int y){
		s[find(x)] = find(y);
	}
}