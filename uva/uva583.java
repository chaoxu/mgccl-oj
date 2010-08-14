import java.util.*;
import java.io.*;
public class uva583{
	static int[] p;
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		p = prime_seive(46341);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		while(n!=0){
			out.write(n+" =");
			if(n<0){
				out.write(" -1 x");
				n = -n;
			}
			factor(n);
			out.write("\n");
			n = Integer.parseInt(in.readLine());
		}
		out.flush();
	}
   static void factor(int n) throws IOException{
		int k = n;
		int c = 0;
		for(int i=0;i<p.length&&k!=1&&p[i]*p[i]<=k;i++){
			while(k%p[i]==0){
				k = k/p[i];
				if(c==0){
					out.write(" "+p[i]);
					c++;
				}else{
					out.write(" x "+p[i]);
				}
			}
		}
		if(k!=1){
			if(c==0){
				out.write(" "+k);
			}else{
				out.write(" x "+k);
			}
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
