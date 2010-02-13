import java.math.BigInteger;
import java.util.*;
public class pc110504 {
	static ArrayList<Integer> pi;
	static BigInteger[] p;

	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		pi = new ArrayList<Integer>();
		for(int i=2;i<10000;i++){
			boolean prime = true;
			for(int j=2;j<=Math.sqrt(i);j++){
				if(i%j==0){
					prime = false;
				}
			}
			if(prime){
				pi.add(i);
			}
		}
		p = new BigInteger[pi.size()];
		for(int i=0;i<pi.size();i++){
			p[i] = BigInteger.valueOf(pi.get(i));
		}
		Set<Integer> p2 = new HashSet<Integer>(pi);
		
		
		int[] a = new int[10000];
		a[1]=1;
		BigInteger k = BigInteger.ONE;
		for(int i=2;i<1000;i++){
			k = k.multiply(BigInteger.TEN).add(BigInteger.ONE);
			BigInteger t = k;
			/*for(int j=1;j<10000&&t.compareTo(BigInteger.ONE)!=0;j+=2){
				BigInteger[] t2 = t.divideAndRemainder(BigInteger.valueOf(j));
				if(t2[1]==BigInteger.ZERO){
					t = t2[0];
					if(a[j]==0){
						a[j]= i;
					}
				}
			}
			*/
			for(int j=1;j<10000&&t.compareTo(BigInteger.ONE)!=0;j+=2){
				BigInteger[] t2 = t.divideAndRemainder(BigInteger.valueOf(j));
				if(t2[1]==BigInteger.ZERO){
				//	t = t2[0];
					if(a[j]==0){
						a[j]= i;
					}
				}
			}
		}
		
		/*for(int i=2;i<1000;i++){
			k = k.multiply(BigInteger.TEN).add(BigInteger.ONE);
			BigInteger t = new BigInteger(k.toString());
			/*for(int j=1;j<p.length&&t.compareTo(p[j])==1;j++){
				BigInteger[] t2 = t.divideAndRemainder(p[j]);
				if(t2[1]==BigInteger.ZERO){
					t = t2[0];
					if(a[pi.get(j)]==0){
						a[pi.get(j)]= i;
					}
				}
			}
		}*/
		
		int c =0;
		int c1=0;
		for(int i=1;i<10000;i+=2){
			if(i%5 !=0&&a[i]==0){
				c++;
				if(p2.contains(i)){
					c1++;
				}else{
					System.out.println(i);
				}
				
			}
		}
		System.out.println(c);
		System.out.println(c1);
		while(in.hasNext()){
			System.out.println(a[in.nextInt()]);
		}
	}
	
	static int[] factor(int n){
		int k = n;
		int[] f = new int[pi.size()];
		for(int i=0;i<pi.size();i++){
			while(k%i==0){
				k = k/i;
				f[i]++;
			}
		}
		return f;
	}
	
	static int[] factor(BigInteger n){
		BigInteger k = new BigInteger(n.toString());
		BigInteger[] t;
		int[] f = new int[p.length];
		for(int i=0;i<p.length;i++){
			t = k.divideAndRemainder(p[i]);
			while(t[1].compareTo(BigInteger.ZERO)==0){
				k = t[0];
				f[i]++;
			}
		}
		return f;
	}
	
	
}
