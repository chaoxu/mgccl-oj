import java.util.*;
import java.text.*;
public class pc111207 {
    public static void main(String[] args){
	    Scanner in = new Scanner(System.in);
	    NumberFormat num=NumberFormat.getInstance();
	    num.setMinimumFractionDigits(3);
	    num.setMaximumFractionDigits(3);
	    num.setGroupingUsed(false);
	    while(in.hasNextLine()){
	    	int n = in.nextInt();
	    	int m = in.nextInt();
	    	in.nextLine();
	    	System.out.println(num.format(d(c(n),c(m))));	    	
	    }
    }   
    static long[] c(int n){
    	int s = (int) Math.sqrt(n);
    	int r = n - s*s;
    	long[] b = new long[2];
    	b[0] = s*3 + 1+(r+1)%2;
    	b[1] = -s+r;
    	return b;
    }

    static double d(long[] a, long[] b){
    	long x = (a[0]-b[0])*(a[0]-b[0]);
    	long y = (a[1]-b[1])*(a[1]-b[1]);
    	double o = (double) x;
    	double p = (double) y;
    	return Math.sqrt(o/12.0 + p/4.0);
    }
}
