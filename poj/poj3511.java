import java.util.*;
public class poj3511{
	static int[] p;
	static int[] c = new int[0];
	public static void main(String[] args){
		Scanner in= new Scanner(System.in);
		int l = in.nextInt();
		int u = in.nextInt();
		p = prime_seive(1000000);
		int[] pc = new int[1000001];
		int[] cc = new int[1000001];
		for(int i=1;i<1000001;i++){
			pc[i] = pc[i-1];
			cc[i] = cc[i-1];
			if(pc[i]<p.length&&p[pc[i]]==i){
				pc[i]++;
			}
			if(cc[i]<c.length&&c[cc[i]]==i){
				cc[i]++;
			}
		}
		while(!(l==-1&&u==-1)){
			System.out.print(l+" "+u+" ");
			l = Math.max(l,1);
			u = Math.max(u,1);
			System.out.println((pc[u]-pc[l-1])+" "+(cc[u]-cc[l-1]));
			l = in.nextInt();
			u = in.nextInt();
		}
	}
	public static int[] prime_seive(int n){
		ArrayList<Integer> p = new ArrayList<Integer>();
		ArrayList<Integer> p2 = new ArrayList<Integer>();
		boolean[] a = new boolean[n+1];
		for (int i=2;i<=n;i++){
			if (!a[i]){
				p.add(i);
				if((i-1)%4==0||i==2){
					p2.add(i);
				}
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
		c = new int[p2.size()];
		for(int i=0;i<c.length;i++){
			c[i] = p2.get(i);
		}
		return b;
	}
}
