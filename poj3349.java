// RE
import java.util.*;
public class poj3349 {
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		int nz = in.nextInt();
		HashMap<String, ArrayList> h = new HashMap<String, ArrayList>();
		String out = "No two snowflakes are alike.";
		for(int z=0;z<nz;z++){
			int[] a = new int[6];
			int[] b = new int[6];
			for(int j=0;j<6;j++){
				a[j] = in.nextInt();
				b[j] = a[j];
			}
			Arrays.sort(a);
			String s = arraytostring(a);
			if(h.containsKey(s)){
				ArrayList t = h.get(s);
				boolean d = false;
				for(int j=0;j<t.size();j++){
					a = (int[]) t.get(j);
					if(f(a,b)){
						out = "Twin snowflakes found.";
						d = true;
						break;
					}
				}
				if(d){
					break;
				}else{
					t.add(b);
					for(int i=0;i<6;i++){
						a[i] = b[5-i];
					}
					t.add(a);
				}
			}else{
				ArrayList t = new ArrayList();
				t.add(b);
				for(int i=0;i<6;i++){
					a[i] = b[5-i];
				}
				t.add(a);
				h.put(s,t);
			}
		}
		System.out.println(out);
	}

	public static String arraytostring(int[] a){
		String s = "";
		for(int i=0;i<a.length;i++){
			s  =  s + String.valueOf(a[i])+"|";
		}
		return s;
	}

	public static boolean f(int[] a, int[] b){
		int[] a2 = new int[12];
		for(int i=0;i<6;i++){
			a2[i] = a[i];
		}
		for(int i=6;i<12;i++){
			a2[i] = a[i-6];
		}
		for(int i=0;i<6;i++){
			boolean orz = true;
			for(int j=0;j<6;j++){
				if(a2[i+j]!=b[j]){
					orz = false;
					break;
				}
			}
			if(orz==true){
				return true;
			}
		}
		return false;
	}
}
