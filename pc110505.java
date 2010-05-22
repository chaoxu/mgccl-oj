import java.util.*;
public class pc110505 {
    public static void main(String[] args){
	    Scanner in = new Scanner(System.in);
	    while(in.hasNext()){
	    	long n = in.nextLong();
	    	long b=1;
	    	String s = "Stan";
	    	while(true){
	    		if(n<=(b*=9)){
	    			break;
	    		}
	    		if(n<=(b*=2)){
	    			s = "Ollie";
	    			break;
	    		}
	    	}
	    	System.out.println(s+" wins.");
	    }
    }
}
