import java.util.*;
import java.math.*;
public class pc110606 {
	static int n = 141;
	static BigInteger[] p = new BigInteger[n];
	static BigInteger[] c = new BigInteger[10001];
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		p[0]=BigInteger.ONE;
		BigInteger two = p[0].add(p[0]);
		for(int i=1;i<n;i++){
			p[i] = p[i-1].multiply(two);
		}
		cost();
		while(in.hasNext()){
			System.out.println(c[in.nextInt()]);
		}
		
	}
	public static void cost(){
		c[0]=BigInteger.ZERO;
		BigInteger sum = BigInteger.ZERO;
		int k = 1;
		int i=1;
		while(true){
			for(int j=0;j<i;j++){
				if(k>10000){
					return;
				}
				sum= sum.add(p[i-1]);
				c[k] = sum.abs();
				k++;
			}
			i++;
		}
	}
}
