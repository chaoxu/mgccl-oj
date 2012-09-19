import java.util.*;
//the exponential time algorithm. The. O(n 2^{n/2}) algorithm.
public class subsetsum {
	public static boolean run(int[] a, int x){
		int n = a.length/2;
		int m = a.length - n;
		ArrayList<Integer> l = new ArrayList<Integer>();
		ArrayList<Integer> u = new ArrayList<Integer>();
		s(Arrays.copyOfRange(a, 0, n),l,n-1,0);
		s(Arrays.copyOfRange(a, n, a.length),u,m-1,0);
		
		Collections.sort(l);
		Collections.sort(u,Collections.reverseOrder());
		int li=0, ui=0;
		while(li<l.size() && ui<u.size()){
			int t = l.get(li)+u.get(ui);
			if(t==x){
				return true;
			}
			if(t<x){
				li++;
			}else{
				ui++;
			}
		}
		return false;
	}
	public static void s(int[] a, ArrayList<Integer> l, int i, int sum){
		if(i==-1){
			l.add(sum);
			return;
		}
		s(a,l, i-1, sum+a[i]);
		s(a,l, i-1, sum);
	}
}
