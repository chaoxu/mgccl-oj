/*
ID: mgcclx1
LANG: JAVA
TASK: hamming 
*/
import java.util.*;
import java.io.*;
public class hamming {
	static ArrayList<Integer> s = new ArrayList<Integer>();
	static int n;
	static int d = 0;
	static int b=0;
	static ArrayList[][] m = new ArrayList[256][8];
	public static void main(String args[]) throws IOException{
    	Scanner in = new Scanner(new File("hamming.in"));
    	FileWriter fstream = new FileWriter("hamming.out");
        BufferedWriter out = new BufferedWriter(fstream);
		for(int i=0;i<256;i++){
			for(int j=0;j<8;j++){
				m[i][j] = new ArrayList();
			}
			for(int j=0;j<256;j++){
				int t = Math.min(7,d(i,j));
				for(int z=0;z<=t;z++){
					m[i][z].add(j);
				}
			}
		}
		n = in.nextInt();
		b = 1 << in.nextInt();
		d = in.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		b(a);
		for(int i=0;i<a.size();i++){
			out.write(String.valueOf(a.get(i)));
			if(i!=a.size()-1&&i%10!=9){
				out.write(" ");
			}else{
				out.write("\n");
			}
		}
		out.close();
	}
	public static int d(int a, int b){
		int c = 0;
		while(Math.max(a,b)>0){
			if(a%2 != b%2){
				c++;
			}
			a/=2;
			b/=2;
		}
		return c;
	}
	public static void b(ArrayList<Integer> a){
		if(a.size()==n){
			s = a;
		}
		int t = a.get(a.size()-1);
		for(int i=0;i<m[t][d].size();i++){
			Integer z = (Integer) m[t][d].get(i);
			if(z>t&&z<b){
				boolean y = true;
				for(int j=0;j<a.size();j++){
					if(!m[a.get(j)][d].contains(z)){
						y = false;
						break;
					}
				}
				if(y){
					a.add(z);
					b(a);
					break;
				}
			}
		}
	}
}

