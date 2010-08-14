import java.util.*;
public class test{
	public static void main(String[] args){
		prime_seive(1000000000);
		//It means insert this number in, and it's index will become -result
	}
	public static void prime_seive(int n){
		ArrayList<Integer> p = new ArrayList<Integer>();
		boolean[] a = new boolean[n+1];
		for (int i=2;i<=n;i++){
			if (!a[i]){
				p.add(i);
			}
			for (int j=1;((j<=p.size()) && (i*p.get(j-1)<=n)); j++){
				a[i*p.get(j-1)] = true ;
				if (i%p.get(j-1) == 0) break;
			}
		}
	//	int[] b = new int[p.size()];
	//	for(int i=0;i<b.length;i++){
	//		b[i] = p.get(i);
	//	}
	//	return b;
	}	
}
