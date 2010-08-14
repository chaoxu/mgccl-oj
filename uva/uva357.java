import java.util.*;
public class uva357{
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		int n = 30000;
		int[] c = {1,5,10,25,50};
		long[][] d = new long[n+1][5];
		for(int i=0;i<5;i++){
			d[0][i] = 1;
		}
		for(int i=1;i<n+1;i++){
			for(int j=0;j<5;j++){
				if(i>=c[j]){
					d[i][j] += d[i-c[j]][j];
				}
				if(j>0){
					d[i][j] += d[i][j-1];
				}
			}
		}
		while(in.hasNext()){
			int i = in.nextInt();
			if(d[i][4]>1){
				System.out.println("There are "+d[i][4]+" ways to produce "+i+" cents change.");
			}else{
				System.out.println("There is only 1 way to produce "+i+" cents change.");
			}
		}
	}
}
