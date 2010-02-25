import java.util.*;
public class pc110801 {
	static int[][] a = new int[8][65];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n,k;
        for(n=1;n<9;n++){
        	for(k=0;k<=n*n;k++){
        		if(k==0){
        			a[n-1][k]=1;
        			continue;
        		}
            	int[][] b1 = new int[n][n];
            	int[][] b2 = new int[n][n];
            	if(n%2==1){
            		for(int j=0;j<n;j++){
            			b1[n/2][j] = 1;
            		}
            	}
            	for(int i=0;i<n/2;i++){
            		int t = i*2 + 1;
            		int l =  (n-1)/2-i;
            		for(int j=l; j<l+t;j++){
            			b1[i][j] = 1;
            			b1[n-i-1][j] = 1;
            		}
            	}
            	for(int i=0;i<n/2;i++){
            		int t = i*2 + 2;
            		int l =  (n-1)/2-i;
            		for(int j=l; j<l+t;j++){
            			b2[i][j] = 1;
            			b2[n-i-1][j] = 1;
            		}
            	}
            	if(n%2==0){
            		for(int j=0;j<n;j++){
            			b2[n/2][j] = 0;
            		}
            	}
            	int c=0;
            	for(int i=0;i<=k;i++){
            		c+= count(b1,i,0) * count(b2,k-i,0);
            	}
            	if(c==0){
            		break;
            	}else{
            		a[n-1][k]=c;
            	}
        	}
        }
        n = in.nextInt();
        k = in.nextInt();
        while(n!=0){
        	System.out.println(a[n-1][k]);
        	n = in.nextInt();
        	k = in.nextInt();
        }
    }
    
    static int[][] clone(int[][] a){
    	int[][] b = new int[a.length][a.length];
    	for(int i=0;i<a.length;i++){
    		b[i] = a[i].clone();
    	}
    	return b;
    }

    static int count(int[][] z, int k, int t){
    	if(k==0){
    		return 1;
    	}
    	int[][] b = clone(z);
    	int c=0;
    	for(int i=t/b.length;i<b.length;i++){
    		for(int j=0;j<b.length;j++){
    			if(!(i==t/b.length && j<t%b.length)){
	    			if(b[i][j]==1){
	    				b = put(b,i,j);
	    				c+= count(b,k-1,i*b.length+j);
	    				b=clone(z);
	    			}
    			}
    		}
    	}
    	return c;
    }
    
    static int[][] put(int[][] b, int i, int j){
    	for(int x = 0;x<b.length;x++){
    		b[i][x] = 0;
    		b[x][j] = 0;
    	}
    	return b;
    }
}
