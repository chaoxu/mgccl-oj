import java.io.*;
import java.util.*;
public class uva11678 {
	public static void main(String[] args){
		BufferedInputStream in = new BufferedInputStream(System.in);
		int n = nextInt(in);
		int m = nextInt(in);
		while(n!=0){
			HashSet<Integer> ha = new HashSet<Integer>();
			HashSet<Integer> hb = new HashSet<Integer>();
			for(int i=0;i<n;i++){
				ha.add(nextInt(in));
			}
			for(int i=0;i<m;i++){
				hb.add(nextInt(in));
			}
			int x = ha.size();
			int y = hb.size();
			hb.retainAll(ha);
			int z = hb.size();			
			System.out.println(Math.min(x-z,y-z));
			n = nextInt(in);
			m = nextInt(in);
		}
	}

	public static int nextInt(InputStream in){
	    int ret = 0;
	    boolean dig = false;

	    try {
			for (int c = 0; (c = in.read()) != -1; ) {
			    if (c >= '0' && c <= '9') {
			        dig = true;
			        ret = ret * 10 + c - '0';
			    } else if (dig) break;
			}
		} catch (IOException e) {}
	    return ret;
	}
	
}
