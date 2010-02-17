import java.util.*;

public class pc110405 {
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			if(i!=0){
				System.out.println();
			}
			int m = in.nextInt();
			double[][] s = new double[m][2];
			for(int j=0;j<m;j++){
				s[j][0] = (double) (j+1);
				s[j][1] = in.nextDouble()/in.nextDouble();
			}
			doublesort st = new doublesort();
			Arrays.sort(s,st);
			for(int j=0;j<m-1;j++){
				System.out.print((int) s[j][0]+" ");
			}
			System.out.println((int) s[m-1][0]);
		}
	}
}
class doublesort implements Comparator<double[]>{
    public int compare(double[] o1, double[] o2) {
    	if(o1[1]>o2[1]){
    		return 1;
    	}
    	if(o1[1]<o2[1]){
    		return -1;
    	}
    	if(o1[0]>o2[0]){
    		return 1;
    	}
    	return -1;
    }
}