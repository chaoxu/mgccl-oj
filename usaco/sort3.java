/*
ID: mgcclx1
LANG: JAVA
TASK: sort3
*/
import java.util.*;
import java.io.*;
public class sort3 {
	static int c;
	public static void main(String args[]) throws IOException{
    	Scanner in = new Scanner(new File("sort3.in"));
    	FileWriter fstream = new FileWriter("sort3.out");
        BufferedWriter out = new BufferedWriter(fstream);
		int n = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[4];
		for(int i=0;i<n;i++){
			a[i] = in.nextInt();
			b[a[i]]++;
		}
		for(int i=b[1];i<b[2]+b[1];i++){
			if(a[i]==1){
				if(next_k(a,2)<b[1]){
					a = s(a,i,next_k(a,2));
				}else{
					a = s(a,i,next_k(a,3));
				}
			}
		}
		for(int i=b[2]+b[1];i<n;i++){
			if(a[i]==1){
				if(next_k(a,3)<b[1]){
					a = s(a,i,next_k(a,3));
				}else{
					a = s(a,i,next_k(a,2));
				}
			}
		}
		//switch the 2s
		for(int i=b[1]+b[2];i<n;i++){
			if(a[i]==2){
				for(int j=b[1];j<n;j++){
					if(a[j]==3){
						a = s(a,i,j);
						break;
					}
				}
			}
		}
		out.write(c+"\n");
		for(int i=0;i<n;i++){
			//System.out.println(a[i]);
		}
		out.close();
	}
	public static int[] s(int[] a, int i, int j){
		c++;
		int t = a[i];
		a[i] = a[j];
		a[j] =t;
		//System.out.println(i+" "+j);
		return a;
	}
	public static int next_k(int[] a, int j){
		for(int i=0;i<a.length;i++){
			if(a[i] == j){
				return i;
			}
		}
		return 0;
	}
}
