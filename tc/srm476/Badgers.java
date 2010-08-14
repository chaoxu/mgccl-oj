import java.util.*;
public class Badgers{
	public static int feedMost(int[] h, int[] g, int n){
		for(int i=1;i<=h.length;i++){
			int[] s = new int[h.length];
			for(int j=0;j<h.length;j++){
				s[j] = h[j] + (i-1)*g[j];
			}
			Arrays.sort(s);
			int n2 = n;
			for(int j=0;j<i;j++){
				n2 -= s[j];
			}
			if(n2<0){
				return i-1;
			}
		}
		return h.length;
	}
}

