import java.util.*;
public class poj3274 {
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[][] p = new int[n+1][k];
		for(int i=1;i<n+1;i++){
			int t = in.nextInt();
			for(int j=0;j<k;j++){
				p[i][j] = p[i-1][j]+(t%2);
				t/=2;
			}
		}
		int[][] s = new int[n+1][k+1];
		for(int i=0;i<n+1;i++){
			for(int j=0;j<k;j++){
				s[i][j] = p[i][j] - p[i][0];
			}
			s[i][k] = i;
		}
		Arrays.sort(s,new sorttemplate());
		int max = 0;
		int i=0;
		while(i<s.length){
			int j = i+1;
			while(j<s.length){
				if(!f(s[i],s[j])){
					break;
				}
				j++;
			}
			max = Math.max(s[j-1][k]-s[i][k],max);
			i=j;
		}
		System.out.println(max);
	}

	public static boolean f(int[] a, int[] b){
		for(int i=0;i<a.length-1;i++){
			if(a[i]!=b[i]){
				return false;
			}
		}
		return true;
	}
}
class sorttemplate implements Comparator<int[]>{
    public int compare(int[] o1, int[] o2) {
    	for(int i=0;i<o1.length;i++){
			if(o1[i]>o2[i]){
    			return 1;
    		}
    		if(o1[i]<o2[i]){
    			return -1;
    		}
		}
		return 0;
	}
}
