/*
ID: mgcclx1
LANG: JAVA
TASK: milk3
*/
import java.util.*;
import java.io.*;
public class usaco_milk3 {
	static int[] u = new int[3];
	static boolean[][] g;
	static int m;
	public static void main(String args[]) throws IOException{
    	Scanner in = new Scanner(new File("milk3.in"));
    	FileWriter fstream = new FileWriter("milk3.out");
        BufferedWriter out = new BufferedWriter(fstream);
        //We have A = 0,B=1,C= w/e in A and b.
		int[] s = new int[3];
        u[0] = in.nextInt();
        u[1] = in.nextInt();
        m = in.nextInt();
        s[2] = m;
        u[2] = m;
        g = new boolean[m+1][m+1];
        dfs(s);
        ArrayList<Integer> so = new ArrayList<Integer>();
        for(int i=m;i>=0;i--){
        	if(g[0][i]){
        		so.add(m-i);
        	}
        }
        out.write(String.valueOf(so.get(0)));
        for(int i=1;i<so.size();i++){
        	out.write(" "+so.get(i));
        }
        out.write("\n");
        out.close();
	}
	public static void dfs(int[] s){
		if(g[s[0]][s[1]]){
			return;
		}
		g[s[0]][s[1]]=true;
		dfs(pour(0,1,s));
		dfs(pour(0,2,s));
		dfs(pour(1,0,s));
		dfs(pour(1,2,s));
		dfs(pour(2,0,s));
		dfs(pour(2,1,s));
	}
	public static int[] pour(int a, int b, int[] t){
		int[] s = new int[3];
		s[0] = t[0];
		s[1] = t[1];
		s[2] = t[2];
		if(s[a]<u[b]-s[b]){
			s[b] = s[b]+s[a];
			s[a] = 0;
		}else{
			s[a] = s[a] - (u[b]-s[b]);			
			s[b] = u[b];
		}
		return s;
	}
}
