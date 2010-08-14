import java.util.*;
public class uva10192{
	static char[] x,y;
	static int[][] d;
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		int c = 1;
		while(in.hasNextLine()){
			char[] a = in.nextLine().toCharArray();
			if((a.length>0)&&a[0]=='#'){

				break;
			}
			x= new char[a.length+1];
			for(int i=0;i<a.length;i++){
				x[i+1] = a[i];
			}
			a = in.nextLine().toCharArray();
			y= new char[a.length+1];
			for(int i=0;i<a.length;i++){
				y[i+1] = a[i];
			}
			d = new int[x.length][y.length];
			for(int i=1;i<x.length;i++){
				for(int j=1;j<y.length;j++){
					d[i][j] = Math.max(d[i-1][j],d[i][j-1]);
					if(x[i]==y[j]){
						d[i][j] = d[i-1][j-1]+1;
					}
				}
			}
			System.out.println("Case #"+(c++)+": you can visit at most "+d[x.length-1][y.length-1]+" cities.");
		}
	}
	public static HashSet<Character> f(int i, int j){
		if(i==0||j==0){
			return (new HashSet<Character>());
		}
		if(x[i]==y[j]){
			HashSet<Character> h = f(i-1,j-1);
			h.add(x[i]);
			return h;
		}
		if(d[i-1][j]>d[i][j-1]){
			return f(i-1,j);
		}
		return f(i,j-1);
	}
}


