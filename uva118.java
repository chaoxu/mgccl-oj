import java.util.*;
public class uva118 {
	public static int f(String a){
		if(a.equals("N")){
			return 3;
		}
		if(a.equals("S")){
			return 1;
		}
		if(a.equals("E")){
			return 2;
		}
		return 0;
	}
	
	public static String g(int a){
		if(a==3){
			return "N";
		}
		if(a==1){
			return "S";
		}
		if(a==2){
			return "E";
		}
		return "W";
	}
    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	int mx = in.nextInt();
    	int my = in.nextInt();
    	int[][] m = new int[mx+1][my+1];
    	int[][] r = new int[4][2];
    	r[0][0] = -1;
    	r[1][1] = -1;
    	r[2][0] = 1;
    	r[3][1] = 1;
    	while(in.hasNext()){
    		int x = in.nextInt();
    		int y = in.nextInt();
    		int d =f(in.next());
    		char[] c = in.next().toCharArray();
    		String l = "";
    		for(int i=0;i<c.length;i++){
    			if(c[i]=='F'){
    				int nx = x + r[d][0];
    				int ny = y + r[d][1];
    				if(nx>mx||ny>my||nx<0||ny<0){
    					if(m[x][y]==0){
	    					l = " LOST";
	    					m[x][y] = 1;
	    					break;
    					}
    					nx = x;
    					ny = y;
    				}
    				x = nx;
    				y = ny;
    			}
    			if(c[i]=='R'){
    				d = (d+3)%4;
    			}
    			if(c[i]=='L'){
    				d = (d+1)%4;
    			}
    		}
    		System.out.println(x + " " + y + " " + g(d) + l);
    	}
    }
}
