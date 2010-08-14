import java.util.*;
public class pc110502 {
	static int count;
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			count = 0;
			pal(in.nextInt());
		}
	}
	
	static void pal(long i){
		if(is_pal(i)){
			System.out.println(count+" "+i);
			return;
		}
		count++;
		pal(i+ reverse(i));
	}
	
	static boolean is_pal(long n){
		char c[] = String.valueOf(n).toCharArray();
		for(int i=0;i<c.length/2;i++){
			if(c[i]!=c[c.length-1-i]){
				return false;
			}
		}
		return true;
	}
	
	static long reverse(long n){
		char c[] = String.valueOf(n).toCharArray();
		char d[] = new char[c.length];
		for(int i=0;i<c.length;i++){
			d[i]=c[c.length-i-1];
		}
		return Long.parseLong(String.valueOf(d));
	}
}
