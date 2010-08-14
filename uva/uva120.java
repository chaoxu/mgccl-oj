import java.util.*;
public class uva120 {
	public static void main(String args[]){
    	Scanner orz = new Scanner(System.in);
		while(orz.hasNext()){
			String o = orz.nextLine();
			System.out.println(o);
			Scanner in = new Scanner(o);
			ArrayList<Integer> a = new ArrayList<Integer>();
			
			while(in.hasNext()){
				a.add(in.nextInt());
			}
			int[] s = new int[a.size()];
			for(int i=0;i<a.size();i++){
				s[i] = a.get(i);
			}
			for(int i=0;i<s.length;i++){
				int max = 0;
				for(int j=0;j<s.length-i;j++){
					if(s[j]>s[max]){
						max = j;
					}
				}
				if(max!=s.length-i-1){
					if(max!=0){
						s= f(s,max);
						System.out.print((s.length-max)+" ");
					}
					s= f(s,s.length-1-i);
					System.out.print((i+1)+" ");
				}
			}
			System.out.println("0");
		}
	}
	public static int[] f(int[] a, int j){
		int[] b = new int[a.length];
		for(int i=0;i<a.length;i++){
			b[i] = a[i];
		}
		for(int i=0;i<=j;i++){
			a[i] = b[j-i];
		}
		return a;
	}
}
