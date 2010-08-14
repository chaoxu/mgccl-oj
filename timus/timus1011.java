import java.util.*;
public class timus1011 {
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	double p = in.nextDouble()/100.0;
    	double q = in.nextDouble()/100.0;
    	double epsilon = 0.0000001;
    	int k = 0;
    	double kp = 3.0;
    	double kq = 1.0;
    	while(true){
    		k++;
    		kp = ((double) k)*p;
    		kq = ((double) k)*q;
    		if(Math.ceil(kp) <= Math.floor(kq)){
    			if(Math.ceil(kp) == Math.floor(kq)){
        			if(Math.ceil(kp)-kp<epsilon || kq-Math.floor(kq)<epsilon){
            			continue;
            		}
    			}
    			if(Math.ceil(kp)+1 == Math.floor(kq)){
        			if(Math.ceil(kp)-kp<epsilon && kq-Math.floor(kq)<epsilon){
            			continue;
            		}
    			}
    			break;
    		}
    	}
    	System.out.println(k);
	}
}
