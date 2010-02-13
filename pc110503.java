import java.util.*;
import java.math.*;
public class pc110503 {
	static String[] t;
	
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		int n=10000;
		
		BigInteger two = BigInteger.valueOf(2);
		BigInteger k = BigInteger.valueOf(2);
		ArrayList<String> a = new ArrayList<String>();
		while(in.hasNext()){
			String s = in.next();
			boolean f = true;
			for(int i=0;i<a.size();i++){
				if(a.get(i).length()>s.length()*2&&s.compareTo(a.get(i).substring(0,s.length()))==0){
					System.out.println(i+1);
					f = false;
					break;
				}
			}
			while(f){
				String g = k.toString();
				a.add(k.toString());
				if(g.length()>s.length()*2&&s.compareTo(g.substring(0,s.length()))==0){
					System.out.println(a.size());
					f=false;
				}
				k = k.multiply(two);
			}
		}
	}
}
