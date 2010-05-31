import java.util.*;
public class poj1002{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		HashMap<String,Integer> h = new HashMap<String,Integer>();
		for(int z=0;z<n;z++){
			char[] a = in.next().toCharArray();
			char[] b = new char[7];
			int p=0;
			for(int i=0;i<a.length;i++){
				char t = f(a[i]);
				if(t!='-'){
					b[p] = t;
					p++;
				}
			}
			String s = String.valueOf(b);
			if(!h.containsKey(s)){
				h.put(s,1);
			}else{
				h.put(s,h.get(s)+1);
			}
		}
		String[] l = new String[h.size()];
		h.keySet().toArray(l);
		Arrays.sort(l);
		boolean d=true;
		for(int i=0;i<l.length;i++){
			if(h.get(l[i])>1){
				d=false;
				System.out.println(l[i].substring(0,3)+"-"+l[i].substring(3)+" "+h.get(l[i]));
			}
		}
		if(d){
			System.out.println("No duplicates.");
		}
		
	}
	
	public static char f(char c){
		if(c<81&&c>64){
			c = (char) ((((int)c)-65)/3 + 50);
		}
		if(c>81&&c<90){
			if(c=='R'||c=='S'){
				c= '7';
			}else if(c=='T'||c=='U'||c=='V'){
				c='8';
			}else{
				c='9';
			}

		}
		return c;
	}
}
