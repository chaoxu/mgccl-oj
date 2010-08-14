import java.util.*;
public class timus1010 {
	public static void main(String args[]){
	    	Scanner in = new Scanner(System.in);
	    	int n = in.nextInt();
	    	long[] a = new long[n];
	    	for(int i=0;i<n;i++){
	    		a[i] = in.nextLong();
	    	}
	    	long m=Math.abs(a[0]-a[1]);
	    	int ma = 1;
	    	int mb = 2;
	    	for(int i=1;i<n-1;i++){
	    		long t = Math.abs(a[i]-a[i+1]);
	    		if(t>m){
	    			m = t;
	    			ma = i+1;
	    			mb = i+2;
	    		}
	    	}
	    	System.out.println(ma+" "+mb);
	}
}
