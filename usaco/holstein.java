/*
ID: mgcclx1
LANG: JAVA
TASK: holstein 
*/
import java.util.*;
import java.io.*;
public class holstein{
	static int n;
	static int g;
	static int[][] m;
    static BufferedWriter out;
	static Stack<Integer> sol;
	public static void main(String args[]) throws IOException{
    	Scanner in = new Scanner(new File("holstein.in"));
    	FileWriter fstream = new FileWriter("holstein.out");
        out = new BufferedWriter(fstream);
		sol = new Stack<Integer>();
		n = in.nextInt();
		for(int i=n;i>0;i--){
			sol.push(i);
		}
		int[] v = new int[n];
		for(int i=0;i<n;i++){
			v[i] = in.nextInt();
		}
		g = in.nextInt();
		m = new int[g][n];
		for(int i=0;i<g;i++){
			for(int j=0;j<n;j++){
				m[i][j] = in.nextInt();
			}
		}
		dfs(v,g-1,new Stack<Integer>());
			System.out.print(sol.size());
			out.write(String.valueOf(sol.size()));
			while(sol.size()>0){
		//		System.out.print(" "+(sol.pop()+1));
				out.write(" "+(sol.pop()+1));
			}
			System.out.println();
			out.write("\n");
			out.close();
	}


	public static void dfs(int[] v,int c, Stack<Integer> s) throws IOException{
		if(c<0){
			return;
		}
		dfs(v, c-1, s);
		int cn = 0;
		for(int i=0;i<n;i++){
			v[i] -= m[c][i];
			if(v[i]<=0){
				cn++;
			}
		}
		s.push(c);
		if(cn==n){
			if(s.size()<=sol.size()){
				sol = (Stack<Integer>) s.clone();
			}
		}
		dfs(v, c-1,s);
		s.pop();
		for(int i=0;i<n;i++){
			v[i] += m[c][i];
		}
	}
}
