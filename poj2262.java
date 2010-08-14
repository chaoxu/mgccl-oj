import java.util.*;
public class poj2262{
    static boolean[] a;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] p = prime_seive(1000000);
		a[0]=true;
		a[1]=true;
		int n = in.nextInt();
		while(n!=0){	
			for(int i=0;i<p.length;i++){
				if(!a[n-p[i]]){
					System.out.println(n+" = " + p[i]+" + "+(n-p[i]));
					break;
				}
			}
			n = in.nextInt();
		}
	}
	public static int[] prime_seive(int n){
		ArrayList<Integer> p = new ArrayList<Integer>();
		a = new boolean[n+1];
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
