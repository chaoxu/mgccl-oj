/*
ID: mgcclx1
LANG: JAVA
TASK: ariprog
*/
import java.util.*;
import java.io.*;
public class usaco_ariprog {
	public static void main(String args[]) throws IOException{
    	Scanner in = new Scanner(new File("ariprog.in"));
    	FileWriter fstream = new FileWriter("ariprog.out");
        BufferedWriter out = new BufferedWriter(fstream);
        int n = in.nextInt();
        int m = in.nextInt();
        int l = 2*m*m;
        boolean[] s = new boolean[l+1];
        for(int i=0;i<=m;i++){
        	for(int j=0;j<=m;j++){
        		s[i*i + j*j] = true;
        	}
        }
        boolean none = true;
       for(int d=1;d<(l/(n-1))+1;d++){
        	for(int a=0;a<(l-(n-1)*d)+1;a++){
        		boolean f = true;
        		for(int k=0;k<n;k++){
        			if(!s[a+k*d]){
        				f=false;
        				break;
        			}
        		}
        		if(f){
        			none = false;
        			out.write(a+" "+d+"\n");
        		}
        	}
        }
        if(none){
        	out.write("NONE\n");
        }
        out.close();
	}
}
