import java.util.*;
public class poj2909{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] p = prime_seive(32768);
		int[] c = new int[32768];
		for(int i=0;i<p.length;i++){
			for(int j=i;j<p.length;j++){
				if(p[i]+p[j]>32767){
					break;
				}
				c[p[i]+p[j]]++;
			}
		}
		int n = in.nextInt();
		while(n!=0){
			System.out.println(c[n]);
			n = in.nextInt();
		}
	}
	public static int[] prime_seive(int n){
		ArrayList<Integer> p = new ArrayList<Integer>();
		boolean[] a = new boolean[n+1];
		for (int i=2;i<=n;i++){
			if (!a[i]){
				p.add(i);
			}
			for (int j=1;((j<=p.size()) && (i*p.get(j-1)<=n)); j++){
				a[i*p.get(j-1)] = true ;
				if (i%p.get(j-1) == 0) break;
			}
		}
		int[] b = new int[p.size()];
		for(int i=0;i<b.length;i++){
			b[i] = p.get(i);
		}
		return b;
	}
}
