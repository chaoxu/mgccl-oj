import java.io.*;
public class timus1048{
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i=n-1;i>=0;i--){
			String s = in.readLine();
			a[i] = Integer.parseInt(s.substring(0,1));
			b[i] = Integer.parseInt(s.substring(2));
		}
		for(int i=0;i<n-1;i++){
			int t = a[i] + b[i];
			a[i] = t%10;
			a[i+1] +=t/10;
		}
		a[n-1] = a[n-1]+b[n-1];
		for(int i=n-1;i>=0;i--){
			System.out.print(a[i]);
		}
		System.out.println();
	}
}
