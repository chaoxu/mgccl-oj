import java.util.*;
import java.math.*;
public class pc110603 {
	static BigInteger[] a= new BigInteger[1001];
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			System.out.println(count(in.nextInt()));
		}
	}
	
	static BigInteger count(int n){
		if(a[n]!=null){
			return a[n];
		}
		BigInteger sum=BigInteger.ZERO;
		if(n==0){
			return BigInteger.ONE;
		}
		if(n>0){
			sum =  sum.add(count(n-1).add(count(n-1)));
		}
		if(n>1){
			sum =  sum.add(count(n-2));
		}
		if(n>2){
			sum =  sum.add(count(n-3));
		}
		a[n] = sum;
		return sum;
	}
}
