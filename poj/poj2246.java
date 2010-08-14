import java.util.*;
public class poj2246{
	static HashMap<Character, int[]> h = new HashMap<Character, int[]>();
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			Character t = in.next().toCharArray()[0];
			int[] a = new int[3];
			a[0] = 0;
			a[1] = in.nextInt();
			a[2] = in.nextInt();
			h.put(t,a);
		}
		while(in.hasNext()){
			String s = in.next();
			int[] t = f(s);
			if(t[0]==-1){
				System.out.println("error");
			}else{
				System.out.println(t[0]);
			}
		}
	}
	public static int[] f(String s){
		int p = s.length();
		int[] a;
		int[] b;
		if(s.charAt(0)!='('){
			char c = s.charAt(0);
			a = h.get(c);
			if(s.substring(1).length()==0){
				return a;
			}
			b = f(s.substring(1,p));
		}else{
			int d = 1;
			for(int i=1;i<s.length();i++){
				if(s.charAt(i)==')'){
					d--;
					if(d==0){
						p = i;
						break;
					}
				}
				if(s.charAt(i)=='('){
					d++;
				}
			}
			a = f(s.substring(1,p));
			if(p==s.length()-1){
				return a;
			}
			b = f(s.substring(p+1));
		}
		int[] t = new int[3];
		if(b[0]==-1||a[0]==-1||a[2]!=b[1]){
			t[0] = -1;
		}else{
			t[0] = a[1]*a[2]*b[2]+a[0]+b[0];
		}
		t[1] = a[1];
		t[2] = b[2];
		return t;
	}
}
