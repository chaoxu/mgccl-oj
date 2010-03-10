import java.math.BigInteger;
import java.text.*;
import java.util.*;


public class commons {
	
	static void common_lines(){
	    NumberFormat num=NumberFormat.getInstance();
	    num.setMinimumFractionDigits(3);
	    num.setMaximumFractionDigits(3);
	    num.setGroupingUsed(false);
	}
    static int[] extended_gcd(int a, int b, int s1, int t1, int s2, int t2){		
        if(a*s1+b*t1==1){
        	int[] m = {s1,t1};
        	return m;
        }
        int r = (s2*a+t2*b)/(s1*a+t1*b);
        s2 = (s2-r*s1);
        t2 = (t2-r*t1);
        return extended_gcd(a, b, s2, t2, s1, t1);
   }
   static int gcd(int a, int b){
        if(a%b==0)
     	   return b;
        return gcd(b, a%b);
   }
   /*static int[] factor(int n){
	   //p is a list of prime numbers
		int k = n;
		//int[] f = new int[p.length];
		//for(int i=0;i<p.length;i++){
		//	while(k%p[i])==0){
		//		k = k/p[i];
		//		f[i]++;
		//	}
		//}
		//return f;
	}*/
   public static long pow_mod(int a,int e,int n){
   	long t = 1;
   	if(e==0){
   		return t;
   	}
   	long sq = pow_mod(a,e/2,n);
   	t = (sq*sq)%n;
	    if(e%2==1){
	    	t*=a;
	    }
	    return t%n;
   }
   public static double angle(double x, double y){
		if(x>0&&y>=0){
			return Math.atan(y/x);
		}
		if(x>0&&y<0){
			return Math.atan(y/x)+2.0*Math.PI;
		}
		if(x<0){
			return Math.atan(y/x)+Math.PI;
		}
		if(x==0&&y<0){
			return 1.5*Math.PI;
		}
		if(x==0&&y>0){
			return Math.PI*0.5;
		}
		return 0.0;
   }
   
}

class sorttemplate implements Comparator<int[]>{

    public int compare(int[] o1, int[] o2) {
    	if(o1[5]>o2[5]){
    		return -1;
    	}
    	if(o1[5]<o2[5]){
    		return 1;
    	}
    	return 0;
    }
}