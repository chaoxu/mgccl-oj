import java.util.*;
public class pc110101 {
	    public static void main(String args[]){
	        Scanner s = new Scanner(System.in);
	        while(s.hasNext()){
		        int i = s.nextInt();
		        int t1=i;
		        int n = s.nextInt();
		        int t2 = n;
		        if(i>n){
		        	int t=n;
		        	n=i;
		        	i=t;
		        }
		        int m=0,k=0;
		        for(;i<=n;i++){
		        	k=calc(i,1);
		        	if(k>m){
		        		m=k;
		        	}
		        }
		        System.out.println(t1+" "+t2+" "+m);
	        }
	    }
	    
	    public static int calc(long n, int c){
	    	if(n==1){
	    		return c;
	    	}
	    	if(n%2==0){
	    		return calc(n/2,c+1);
	    	}
	    	return calc(n*3+1,c+1);
	    }
}
