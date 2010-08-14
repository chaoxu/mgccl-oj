import java.util.*;
public class poj2250{
	static String[] x;
	static String[] y;
	static int[][] d;
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			ArrayList<String> a = new ArrayList<String>();
			while(true){
				String s = in.next();
				if(s.compareTo("#")==0){
					break;	
				}
				a.add(s);
			}
			x= new String[a.size()+1];
			for(int i=0;i<a.size();i++){
				x[i+1] = a.get(i);
			}
			a.clear();
			while(true){
				String s = in.next();
				if(s.compareTo("#")==0){
					break;	
				}
				a.add(s);
			}
			y= new String[a.size()+1];
			for(int i=0;i<a.size();i++){
				y[i+1] = a.get(i);
			}
			d = new int[x.length][y.length];
			for(int i=1;i<x.length;i++){
				for(int j=1;j<y.length;j++){
					d[i][j] = Math.max(d[i-1][j],d[i][j-1]);
					if(x[i].compareTo(y[j])==0){
						d[i][j] = d[i-1][j-1]+1;
					}
				}
			}
			a = f(x.length-1,y.length-1);
			for(int i=0;i<a.size();i++){
				System.out.print(a.get(i));
				if(i!=a.size()-1){
					System.out.print(" ");
				}else{
					System.out.println();
				}
			}
		}
	}
	public static ArrayList<String> f(int i, int j){
		ArrayList<String> a = new ArrayList<String>();
		if(i==0||j==0){
			return a;
		}
		if(x[i].compareTo(y[j])==0){
			a = f(i-1,j-1);
			a.add(x[i]);
		}else if(d[i-1][j]>d[i][j-1]){
			a = f(i-1,j);
		}else{
			a = f(i,j-1);
		}
		return a;
	}
}


