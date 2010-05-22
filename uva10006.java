import java.util.*;
public class uva10006 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] p = new int[65001];
		for(int i=2;i<65001;i++){
			boolean prime = true;
			for(int j=2;j<=Math.sqrt(i);j++){
				if(i%j==0){
					prime = false;
					break;
				}
			}
			if(prime){
				p[i] = 1;
			}
		}
        int n = in.nextInt();
        while(n!=0){
        	boolean is = true;
        	if(p[n]==1){
        		is = false;
        	}
        	if(is){
	        	for(int i=2;i<n;i++){
	        		if(pow_mod(i,n,n)!=i){
	        			is = false;
	        			break;
	        		}
	        	}
        	}
        	if(is){
        		System.out.println("The number "+n+" is a Carmichael number.");
        	}else{
        		System.out.println(n+" is normal.");
        	}
        	n = in.nextInt();
        }
    }
    
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
}
