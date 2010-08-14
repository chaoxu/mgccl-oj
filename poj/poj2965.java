// TLE
import java.util.*;
public class poj2965 {
	static boolean[][] m;
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	m = new boolean[4][4];
    	for(int i=0;i<4;i++){
    		String s = in.next();
    		for(int j=0;j<4;j++){
    			if(s.charAt(j)=='+'){
    				m[i][j] = false;
    			}else{
    				m[i][j] = true;
    			}
    		}
    	}
    	int max = 999;
    	int b = 0;
    	for(int i=0;i<65536;i++){
    		if(digit_count(i)<max){
	    		if(f(i)){
	    			max = digit_count(i);
	    			b = i;
	    		}
    		}
    	}
    	System.out.println(max);
    	int k = 0;
		while(b!=0){
			if(b%2==1){
				System.out.println((k%4+1)+" "+(k/4+1));
			}
			b/=2;
			k++;
		}
	}
	
	public static int digit_count(int n){
		int s = 0;
		while(n!=0){
			s+=n%2;
			n/=2;
		}
		return s;
	}
	
	public static boolean f(int n){
		boolean[][] c = new boolean[4][4];
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				c[i][j] = m[i][j];
			}
		}
		int b = 0;
		while(n!=0){
			if(n%2==1){
				c = g(b,c);
			}
			n/=2;
			b++;
		}
		//All opened
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(!c[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean[][] g(int p, boolean[][] b){
		int x = p%4;
		int y = p/4;
		for(int i=0;i<4;i++){
			b[x][i] = !b[x][i];
			b[i][y] = !b[i][y];
		}
		b[x][y] = !b[x][y];
		return b;
	}
	
}
