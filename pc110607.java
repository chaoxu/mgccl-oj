import java.util.*;
public class pc110607 {
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		int n = 673366;
		int[] f = new int[n];
		int[] p = new int[n];
		f[1] = 1;
		f[2] = 2;
		p[1]=1;
		p[2]=3;
		int i,j;
		for(i=3;i<n;i++){
			int sum = 0;
			for(j=1;sum<i;j++){
				sum+=f[j];
			}
			f[i]= j-1;
			p[i] = p[i-1]+f[i];
		}
		i = in.nextInt();
		while(i!=0){
			int t = Arrays.binarySearch(p, i);
			if(t>0){
				System.out.println(t);
			}else{
				System.out.println(Math.abs(t)-1);
			}
			i=in.nextInt();
		}
	}
}
