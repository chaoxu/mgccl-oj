/*
ID: mgcclx1
LANG: JAVA
TASK: checker
*/
import java.util.*;
import java.io.*;
public class usaco_checker {
	static int n = 0;
	static int c = 0;
	static BufferedWriter out;
	public static void main(String args[]) throws IOException{
    	//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("checker.in"));
    	FileWriter fstream = new FileWriter("checker.out");
        out = new BufferedWriter(fstream);
		n = in.nextInt();
		boolean[] t = new boolean[n];
		for(int i=0;i<n;i++){
			t[i]=true;
		}
		r(new int[n],0,t,new boolean[n*2], new boolean[n*2]);
		
		if(n==13){
			c=c*2;
			int[] o = new int[n];
			o[0] = 6;
			t = new boolean[n];
			for(int i=0;i<n;i++){
				 t[i]=true;
			}
			t[6]=false;
			boolean[] sum = new boolean[26];
			boolean[] sub = new boolean[26];
			sum[6] = true;
			sub[6+n] = true;
			r(o,1,t,sum,sub);
		}
		//System.out.println(c);
		out.write(String.valueOf(c));
		out.write("\n");
		out.close();
	}

	public static void r(int[] p, int k, boolean[] t, boolean[] sum, boolean[] sub) throws IOException{
		if(k==p.length){
			//solution
			if(c<3){
				//System.out.print(p[0]+1);
				out.write(String.valueOf(p[0]+1));
				for(int i=1;i<p.length;i++){
				//	System.out.print(" "+(p[i]+1));
					out.write(" "+String.valueOf(p[i]+1));
				}
				out.write("\n");
				//System.out.println();
			}
			c++;
			return;
		}
		int z=n;
		if(k==0&&n==13){
			z=6;
		}
		for(int i=0;i<z;i++){
			if(t[i]){
				p[k] = i;
				if(sum[p[k]+k]||sub[p[k]-k+n]){
					continue;
				}
				t[i] = false;
				sum[p[k]+k] = true;
				sub[p[k]-k+n] = true;
				r(p,k+1,t,sum,sub);
				t[i] = true;
				sum[p[k]+k] = false;
				sub[p[k]-k+n] = false;
			}
		}
	}
}
