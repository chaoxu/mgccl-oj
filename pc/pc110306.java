import java.util.*;

class stringsort implements Comparator<String>{

    public int compare(String o1, String o2) {
    	if(o1.length()>o2.length()){
    		return -1;
    	}
    	if(o1.length()<o2.length()){
    		return 1;
    	}
    	return o1.compareTo(o2);
    }
}

public class pc110306 {
	static Set<String> as;
	static String[] a;
	public static void main (String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		s.nextLine();
		for(int i=0;i<n;i++){
			if(i!=0){
				System.out.println();
			}
			as = new HashSet<String>();
			String str= s.nextLine();
			while(s.hasNextLine()){
				as.add(str);
				str = s.nextLine();
				if(str.length()==0){
					break;
				}
			}
			stringsort st = new stringsort();
			a = new String[as.size()];
			a = as.toArray(a);
			Arrays.sort(a,st);
			int p=0,q=a.length;
			
			if(a.length>1){
				String w,x,y,z;
				w = a[0];
				if(a[1].length()!=a[0].length()){
					x = a[0];
				}else{
					x = a[1];
				}
				z = a[a.length-1];
				if(a[a.length-2].length()!=a[a.length-1].length()){
					y = a[a.length-1];
				}else{
					y = a[a.length-2];
				}
				String[] pos = new String[8];
				pos[0] = w.concat(z);
				pos[1] = z.concat(w);
				pos[2] = w.concat(y);
				pos[3] = y.concat(w);
				pos[4] = x.concat(z);
				pos[5] = z.concat(x);
				pos[6] = x.concat(y);
				pos[7] = y.concat(x);
				for(int j=0;j<8;j++){
					if(test(pos[j])){
						System.out.println(pos[j]);
						break;
					}
				}
			}else{
				System.out.println(a[0]+a[0]);
			}
		}
	}
	static boolean test(String t){
		for(int i=0;i<a.length;i++){
			boolean b = false;
			if(t.substring(0,a[i].length()).compareTo(a[i])==0){
				String p = t.substring(t.length()-(t.length()-a[i].length()));
				if(as.contains(p)){
					b = true;
				}
			}
			if(t.substring(t.length()-a[i].length()).compareTo(a[i])==0){
				String p = t.substring(0,t.length()-a[i].length());
				if(as.contains(p)){
					b = true;
				}
			}
			if(b==false){
				return false;
			}
		}
		return true;
	}
}