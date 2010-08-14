import java.util.*;
public class pc110503 {
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		double log2 = Math.log10(2.0);
		while(in.hasNext()){
			double n = in.nextDouble();
			double lb = Math.log10(n)/log2;
			double ub = Math.log10(n+1.0)/log2;
			double i=Math.floor(Math.log10(n))+2;
			while(true){
				int nlb = (int) Math.ceil(lb+i/log2);
				int nub = (int) Math.floor(ub+i/log2);
				if(nlb==nub){
					System.out.println(nlb);
					break;
				}
				i+=1.0;
			}
		}
	}
}
