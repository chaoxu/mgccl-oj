import java.util.*;
public class uva10887 {
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		int nz = in.nextInt();
		for(int z = 0;z<nz;z++){
			int m = in.nextInt();
			int n = in.nextInt();
			String[] a = new String[m];
			String[] b = new String[n];
			in.nextLine();
			for(int i=0;i<m;i++){
				a[i] = in.nextLine();
			}
			for(int i=0;i<n;i++){
				b[i] = in.nextLine();
			}
			HashSet<String> s = new HashSet<String>();
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					s.add(a[i]+b[j]);
				}
			}
			System.out.println("Case "+(z+1)+": "+s.size());
		}
	}
}
