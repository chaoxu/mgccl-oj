import java.util.*;
public class poj2609{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt()*100;
		int m = in.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		while(m!=0){
			a.add(m);
			m = in.nextInt();
		}
		int[][] d = new int[a.size()][n+1];
		for(int i=0;i<a.size();i++){
			d[i][0] = 0;
		}
		for(int i=0;i<n+1;i++){
			d[0][i] = 0;
		}
		for(int i=1;i<a.size();i++){
			for(int w = 0;w<n+1;w++){
				if(a.get(i)>w){
					d[i][w] = d[i-1][w];
				}else{
					d[i][w] = Math.max(a.get(i)+d[i-1][w-a.get(i)],d[i-1][w]);
				}
			}
		}
		int[] p = new int[a.size()];
		p[0] = a.get(0);
		for(int i=1;i<a.size();i++){
			p[i] = p[i-1]+a.get(i);
		}
		int t = d[a.size()-1][n];
		for(int i=a.size()-1;i>-1;i--){
			if(p[i]-d[i][n]<=n){
				t = i;
				break;
			}
		}
		Stack<String> s = new Stack<String>();
		for(int i=t;i>0;i--){
			if(d[i][n]!=d[i-1][n]){
				s.add("port");
				n = n-a.get(i);
			}else{
				s.add("starboard");
			}
		}
		System.out.println(t);
		while(s.size()>0){
			System.out.println(s.pop());
		}
	}
}
