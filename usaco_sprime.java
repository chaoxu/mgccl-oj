/*
  ID: mgcclx1
  LANG: JAVA
  TASK: sprime
 */
import java.util.*;
import java.io.*;
public class usaco_sprime { 
    static int n = 0;
	static BufferedWriter out;
    public static void main(String args[]) throws IOException{
	    Scanner in = new Scanner(new File("sprime.in"));
	    FileWriter fstream = new FileWriter("sprime.out");
		out = new BufferedWriter(fstream);
		n = in.nextInt();
		bfs(0,0);
		out.close();
	}
	public static void bfs(int d, int k) throws IOException{
		
		if(k==0){
			bfs(2,1);
			bfs(3,1);
			bfs(5,1);
			bfs(7,1);
			return;
		}
		if(is_prime(d)){
			if(k==n){
				out.write(String.valueOf(d)+"\n");
				return;
			}
			bfs(d*10 + 1,k+1);
			bfs(d*10 + 3,k+1);
			bfs(d*10 + 7,k+1);
			bfs(d*10 + 9,k+1);
		}
	}
	public static boolean is_prime(int d){
		int s = (int) Math.sqrt(d);
		for(int i=2;i<=s;i++){
			if(d%i==0){
				return false;
			}
		}
		return true;
	}
}

