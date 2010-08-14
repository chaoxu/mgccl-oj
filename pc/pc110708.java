import java.util.*;
    
public class pc110708 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
    	int x,y,c;
        int n = in.nextInt();
        while(n!=0){
        	double[] t=new double[n];;
        	for(int i=0;i<n;i++){
        		x = in.nextInt();
        		y = in.nextInt();
        		c = in.nextInt();
        		x-=c;
        		y-=c;
        		t[i] = angle(x,y);
        	}
        	Arrays.sort(t);
        	String s = "Yes";
        	double p = t[0];
        	for(int i=0;i<n;i++){
        		t[i]-=p;
        	}
        	for(int i=0;i<n-1;i++){
        		if(t[i+1]-t[i]>Math.PI){
        			s = "No";
        			break;
        		}
        	}
        	if(t[n-1]<Math.PI){
        		s = "No";
        	}
        	System.out.println(s);
        	n = in.nextInt();
        }
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
