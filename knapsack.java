public class knapsack {
	int[] f;
	int b;
	public int[] result(){
		return f;
	}
	knapsack(int[] c, int[] w, int[] m, int v){
		b = v;
		f = new int[b+1];
		for(int i=0;i<c.length;i++){
			p(c[i],w[i],m[i]);
		}
	}
	void z(int c, int w){
		for(int i=b;i>=c;i--)
			f[i] = Math.max(f[i],f[i-c]+w);
	}
	void p(int c, int w, int m){
		if(c>=b||c*m>=b){
			for(int i=c;i<=b;i++)
				f[i] = Math.max(f[i],f[i-c]+w);
			return;
		}
		for(int k=1;k<m;k*=2,m-=k)
			z(k*c,k*w);
		z(c*m,w*m);
	}
} 