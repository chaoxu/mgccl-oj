// WA
import java.util.*;
public class uva114 {
	static int my;
	public static int f(int y){
		return my-1-y;
	}
    public static void main(String args[]){
    	int totalsum = 0;
    	Scanner in = new Scanner(System.in);
    	int mx =  in.nextInt();
    	my = in.nextInt();
    	int[][] c = new int[mx][my];
    	int[][] b = new int[mx][my];
    	int[][] v = new int[mx][my];
    	int wc = in.nextInt();
    	int bn = in.nextInt();
    	for(int i=0;i<bn;i++){
    		int xc = in.nextInt()-1;
    		int yc = f(in.nextInt()-1);
    		v[xc][yc] = in.nextInt();
    		c[xc][yc] = in.nextInt();
    		b[xc][yc] = 1;
    	}
    	for(int i=0;i<my;i++){
    		b[0][i] = 1;
    		b[mx-1][i] = 1;
    		c[0][i] = wc;
    		c[mx-1][i] = wc;
    	}
    	for(int i=0;i<mx;i++){
    		b[i][0] = 1;
    		b[i][my-1] = 1;
    		c[i][0] = wc;
    		c[i][my-1] = wc;
    	}
    	while(in.hasNext()){
    		int sum = 0;
    		int x = in.nextInt()-1;
    		int y = f(in.nextInt()-1);
    		int d = in.nextInt();
    		int l = in.nextInt();
    		//System.out.println(x+ " " + y);
    		while(l>0){
    			//take step
    			l--;
    			int nx =x;
    			int ny =y;
    			if(d==0){
    				nx+=1;
    			}
    			if(d==1){
    				ny-=1;
    			}
    			if(d==2){
    				nx-=1;
    			}
    			if(d==3){
    				ny+=1;
    			}
    			
    			if(b[nx][ny]==1){
    				if(l>0){
    					sum += v[nx][ny];
    				}
    				l-= c[nx][ny];
    				
    				nx = x;
    				ny = y;
    				d = (d+3) % 4;
    			}
    			x = nx;
    			y = ny;
    		}
    		System.out.println(sum);
    		totalsum += sum;
    	}
    	System.out.println(totalsum);
    }
}
