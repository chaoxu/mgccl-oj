import java.util.*;
import java.text.*;
public class uva10034 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int nz = in.nextInt();
		NumberFormat num = NumberFormat.getInstance();
		num.setMaximumFractionDigits(2);
		num.setMinimumFractionDigits(2);
		num.setGroupingUsed(false);
		for(int z=0;z<nz;z++){
			int n = in.nextInt();
			double[][] m = new double[n][2];
			for(int i=0;i<n;i++){
				m[i][0] = in.nextDouble();
				m[i][1] = in.nextDouble();
			}
			double[][] g = new double[n][n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					g[i][j]= Math.sqrt((m[i][0] - m[j][0])*(m[i][0] - m[j][0])+(m[i][1] - m[j][1])*(m[i][1] - m[j][1]));
				}
			}
			HashSet<Integer> t = new HashSet<Integer>();
			ArrayList<Integer> t2 = new ArrayList<Integer>();
			double sum = 0;
			t.add(0);
			t2.add(0);
			while(t.size()<n){
				//pick the minimum edge
				double min = 9999999;
				int pick = 0;
				for(int i=0;i<t2.size();i++){
					int v = t2.get(i);
					for(int j=0;j<n;j++){
						if(!t.contains(j)){
							if(g[v][j]<min){
								min = g[v][j];
								pick = j;
							}
						}
					}
				}
				sum+= min;
				t.add(pick);
				t2.add(pick);
			}
			System.out.println(num.format(sum));
			if(z!=nz-1){
				System.out.println();
			}
		}
	}
}

