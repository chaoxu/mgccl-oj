import java.util.*;
import java.io.*;
public class poj2479{
	public static void main(String args[]) throws IOException{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int nz = Integer.parseInt(in.readLine());
		for(int z=0;z<nz;z++){
			in.readLine();
			int n = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			int[] a = new int[n];
			int[] d1 = new int[n];
			int[] d2 = new int[n];
			for(int i=0;i<n;i++){
				a[i]  = Integer.parseInt(st.nextToken());
			}
			d1[0] = a[0];
			int s = Math.max(d1[0],0);
			for(int i=1;i<n;i++){
				d1[i] = Math.max(a[i]+s,d1[i-1]);
				s+=a[i];
				s = Math.max(Math.max(a[i],s),0);
			}
			d2[n-1] = a[n-1];
			s = Math.max(a[n-1],0);
			for(int i=n-2;i>=0;i--){
				d2[i] = Math.max(a[i]+s,d2[i+1]);
				s+=a[i];
				s = Math.max(Math.max(a[i],s),0);
			}
			int max = -9999999;
			for(int i=0;i<n-1;i++){
				if(d1[i]+d2[i+1]>max){
					max = d1[i]+d2[i+1];
				}
			}
			System.out.println(max);
		}
	}
}
