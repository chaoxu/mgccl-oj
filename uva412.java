// WA
import java.util.*;
import java.text.*;
public class uva412{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		NumberFormat num = NumberFormat.getInstance();
		num.setMaximumFractionDigits(6);
		num.setMinimumFractionDigits(6);
		num.setGroupingUsed(false);
		while(n!=0){
			int[] a = new int[n];
			//HashSet<Integer> h = new HashSet<Integer>();
			for(int i=0;i<n;i++){
				a[i] = in.nextInt();
			//	h.add(in.nextInt());
			}
			//Integer[] a = new Integer[h.size()];
			//h.toArray(a);
			int c = 0;
			int d = 0;
			for(int i=0;i<a.length;i++){
				for(int j=i+1;j<a.length;j++){
					if(gcd(a[i],a[j])!=1){
						c++;
					}
					d++;
				}
			}
			if(c==0){
				System.out.println("No estimate for this data set.");
			}else{
				double d1 = (double) d;
				double d2 = (double) (d-c);
				double pi = Math.sqrt(6.0 * d1 / d2);
				System.out.println(num.format(pi));
			}
			n = in.nextInt();
		}
	}
   static int gcd(int a, int b){
        if(a%b==0)
     	   return b;
        return gcd(b, a%b);
   }
}


