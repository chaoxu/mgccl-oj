import java.util.*;
public class poj1042 {
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			if(n==0){
				break;
			}
			int h = in.nextInt()*12;
			int[] f = new int[n];
			int[] d = new int[n];
			int[] t = new int[n];
			for(int i=0;i<n;i++){
				f[i] = in.nextInt();
			}
			for(int i=0;i<n;i++){
				d[i] = in.nextInt();
			}
			for(int i=1;i<n;i++){
				t[i] = in.nextInt();
			}
			int h2 = h;
			int max = -1;
			int[] sol = new int[n];
			for(int i=0;i<n;i++){
				h2-=t[i];
				int[] f2 = Arrays.copyOf(f,i+1);
				int[] a = new int[n];
				int sum = 0;
				for(int j=0;j<h2;j++){
					int p = pick(f2);
					sum += f2[p];
					f2[p]=Math.max(f2[p] - d[p],0);
					a[p]++;
				}
				if(sum>max){
					sol = a;
					max = sum; 
				}
			}
			System.out.print(5*sol[0]);
			for(int i=1;i<n;i++){
				System.out.print(", "+5*sol[i]);
			}
			System.out.println();
			System.out.println("Number of fish expected: "+max);
			System.out.println();
		}
	}
	public static int pick(int[] a){
		int max = 0;
		int pick = 0;
		for(int i=0;i<a.length;i++){
			if(a[i]>max){
				pick = i;
				max = a[i];
			}
		}
		return pick;
	}
}
