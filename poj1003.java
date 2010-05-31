import java.util.*;
public class poj1003 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		double[] a = new double[300];
		a[0] = 0;
		for(int i=1;i<300;i++){
			a[i] = a[i-1] + 1.0/((double) (i+1));
		}
		while(in.hasNext()){
			double d = in.nextDouble();
			if(d==0){
				break;
			}
			int j = Arrays.binarySearch(a,d);
			if(j<0){
				j= -j -1;
			}
			System.out.println(j+" card(s)");
		}
	}
}
