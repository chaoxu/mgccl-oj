import java.util.*;
import java.text.*;
public class D {
    public static void main(String[] args){
    	NumberFormat num = NumberFormat.getInstance();
    	num.setGroupingUsed(false);
    	num.setMaximumFractionDigits(4);
    	num.setMinimumFractionDigits(4);
        Scanner in = new Scanner(System.in);
        int oo = in.nextInt();
        
        for(int o=0;o<oo;o++){
                int z = in.nextInt();
                int n = in.nextInt();
                double l = in.nextDouble();
                double r = in.nextDouble();
                double N = 1.0-l-r;
                double[][] p = new double[n+1][2*n+2];
                p[0][0] = 1;
                for(int i=1;i<n+1;i++){
                	double s = 1;
                	for(int j=2;j<=n;j++){
                		s-=p[i-1][j];
                	}
                	p[i][0] = N*p[i-1][0] + l*s;
                	for(int j=1;j<n+1+i;j++){
                		
                		p[i][j] = l*p[i-1][j+1]+N*p[i-1][j];
                		if(j>=1){
                			p[i][j]+=r*p[i-1][j-1];
                		}
                	}
                }
                double a = p[n][n];
                for(int i=0;i<n+1;i++){
                	for(int j=0;j<n+1;j++){
                	//	System.out.print(p[i][j]+" ");
                	}
                //	System.out.println();
                }
                double sum = 0;
                for(int j=0;j<=n;j++){
                	sum+=((double) j)*p[n][j];
                }
                System.out.println(z+" "+num.format(sum));
        }
    }





}
