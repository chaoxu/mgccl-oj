import java.util.*;
public class poj1753 {
	static boolean[][] m;
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	m = new boolean[6][6];
    	for(int i=1;i<5;i++){
    		String s = in.next();
    		for(int j=0;j<4;j++){
    			if(s.charAt(j)=='w'){
    				m[i][j+1] = true;
    			}else{
    				m[i][j+1] = false;
    			}
    		}
    	}
    	int max = 999;
    	for(int i=0;i<65536;i++){
    		if(digit_count(i)<max){
	    		if(f(i)){
	    			max = digit_count(i);
	    		}
    		}
    	}
    	if(max == 999){
    		System.out.println("Impossible");
    	}else{
    		System.out.println(max);
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
		boolean[][] c = new boolean[6][6];
		for(int i=1;i<6;i++){
			for(int j=1;j<6;j++){
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
		//All 0?
		boolean win = true;
		for(int i=1;i<5;i++){
			for(int j=1;j<5;j++){
				if(!c[i][j]){
					win = false;
					break;
				}
			}
			if(win==false){
				break;
			}
		}
		if(win==true){
			return true;
		}
		
		for(int i=1;i<5;i++){
			for(int j=1;j<5;j++){
				if(c[i][j]){
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static boolean[][] g(int p, boolean[][] b){
		int x = p%4+1;
		int y = p/4+1;
		
		b[x][y] = !b[x][y];
		b[x-1][y] = !b[x-1][y];
		b[x+1][y] = !b[x+1][y];
		b[x][y-1] = !b[x][y-1];
		b[x][y+1] = !b[x][y+1];
		
		return b;	
	}
}
