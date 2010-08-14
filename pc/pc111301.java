import java.util.*;
public class pc111301 {
    public static void main(String[] args){
	    Scanner in = new Scanner(System.in);
	    while(in.hasNextLine()){
	    	int n = in.nextInt();
	    	double gx = in.nextDouble();
	    	double gy = in.nextDouble();
	    	double dx = in.nextDouble();
	    	double dy = in.nextDouble();
	    	boolean escape = false;
	    	for(int i=0;i<n;i++){
	    		String sx = in.next();
	    		String sy = in.next();
	    		double x = Double.parseDouble(sx);
    			double y = Double.parseDouble(sy);
	    		if(!escape){
	    			double d_g = (x-gx)*(x-gx)+(y-gy)*(y-gy);
	    			double d_d = (x-dx)*(x-dx)+(y-dy)*(y-dy);
	    			if(d_g<=d_d/4){
	    				System.out.println("The gopher can escape through the hole at ("+sx+","+sy+").");
	    				escape = true;
	    			}
	    		}
	    	}
	    	if(!escape){
	    		System.out.println("The gopher cannot escape.");
	    	}
	    	in.nextLine();
	    }
    }
}
