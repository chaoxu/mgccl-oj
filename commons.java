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