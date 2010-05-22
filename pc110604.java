import java.util.*;
import java.math.*;
public class pc110604 {
	static BigInteger[][] m = new BigInteger[151][151];
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			System.out.println(f(in.nextInt()/2,in.nextInt()));
		}
	}
	static BigInteger f(int l,int d){
		if(d==l){
			return BigInteger.ONE;
		}
		if(d>l||d==0){
			return BigInteger.ZERO;
		}
		if(m[l][d]!=null){
			return m[l][d];
		}
		BigInteger sum = BigInteger.ZERO;
		for(int i=0;i<l-1;i++){
			for(int j=0;j<d;j++){
				sum = sum.add(f(i,j).multiply(f(l-1-i,d)));
				sum = sum.add(f(i,d-1).multiply(f(l-1-i,j)));
			}
		}
		m[l][d] = sum.add(f(l-1,d-1));
		return m[l][d];
	}
}
