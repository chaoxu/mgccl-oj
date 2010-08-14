import java.util.*;
public class uva147 {
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		int n = 6000;
		int[] c = {1,2,4,10,20,40,100,200,400,1000,2000};
		long[][] d = new long[n+1][11];
		for(int i=0;i<11;i++){
			d[0][i] = 1;
		}
		for(int i=1;i<n+1;i++){
			for(int j=0;j<11;j++){
				if(i>=c[j]){
					d[i][j] += d[i-c[j]][j];
				}
				if(j>0){
					d[i][j] += d[i][j-1];
				}
			}
		}
		while(true){
			String s = in.next();
			String t = s.substring(0,s.length()-3)+s.substring(s.length()-2);
			int i = Integer.parseInt(t)/5;
			if(i==0){
				break;
			}
			System.out.print(string_pad_left(s,6,' '));
			System.out.println(string_pad_left(String.valueOf(d[i][10]),17,' '));
		}
	}
	public static String string_pad_left(String s, int n, char c){
		char[] t = new char[n];
		for(int i=0;i<n-s.length();i++){
			t[i] = c;
		}
		char[] p = s.toCharArray();
		for(int i=n-p.length;i<n;i++){
			t[i] = p[i-(n-p.length)];
		}
		return String.valueOf(t);
	}
}
