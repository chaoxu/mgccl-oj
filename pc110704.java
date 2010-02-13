import java.util.*;
public class pc110704 {
	static ArrayList<Integer> p = new ArrayList<Integer>();
	public static void main (String args[]){
		for(int i=2;i<46340;i++){
			boolean prime = true;
			for(int j=2;j<=Math.sqrt(i);j++){
				if(i%j==0){
					prime = false;
				}
			}
			if(prime){
				p.add(i);
			}
		}
		Scanner in = new Scanner(System.in);
		while(in.hasNext())
			divide(in.nextInt(),in.nextInt());	
	}
	
	static void divide(int f, int n){
		
	}
	
	static int[] factor(int n){
		int k = n;
		int[] f = new int[p.size()];
		for(int i=0;i<p.size();i++){
			while(k%i==0){
				k = k/i;
				f[i]++;
			}
		}
		return f;
	}
}
