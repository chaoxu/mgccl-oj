import java.util.*;
public class pc110401 {
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for(int i=0;i<n;i++){
			Scanner w = new Scanner(in.nextLine());
			int m = w.nextInt();
			int[] l= new int[m];
			for(int j=0;j<m;j++){
				l[j] = w.nextInt();
			}
			Arrays.sort(l);
			int p = l[l.length/2];
			int s=0;
			for(int j=0;j<m;j++){
				s += Math.abs(l[j]-p);
			}
			System.out.println(s);
		}
	}
}
