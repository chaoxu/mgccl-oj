import java.util.*;
import java.math.*;
public class poj1001 {
	static boolean[][] m;
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		while(in.hasNext()){
				BigDecimal b = new BigDecimal(in.next());
				int n = in.nextInt();
				BigDecimal a = new BigDecimal("1");
				for(int i=0;i<n;i++){
					a = a.multiply(b);
				}
				String s = a.unscaledValue().toString();
				if(s.length()<a.scale()){
						System.out.print(".");
						for(int i=0;i<a.scale()-s.length();i++){
								System.out.print("0");
						}
						System.out.println(s);
				}else{
						s = a.toString();
						int t = s.length();
						for(int i=s.length()-1;i>=0;i--){
							if(s.charAt(i)=='0'){
									t=i;
							}else{
									if(s.charAt(i)=='.'){
											t=i;
									}
									break;
							}
						}
						System.out.println(s.substring(0,t));
				}
		}
	}
}
