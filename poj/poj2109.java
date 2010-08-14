import java.util.*;
import java.math.*;
public class poj2109 {
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			BigInteger p = new BigInteger(in.next());
			//Binary search for the integer;
			int limit = 1073741824;
			int base = 0;
			while(true){
				BigInteger k = BigInteger.valueOf(limit/2 + base);
				int t = k.pow(n).compareTo(p);
				if(t==0||limit==0){
					System.out.println(k);
					break;
				}
				limit/=2;
				if(t<0){
					base+=limit;
				}
			}
		}
	}
}
