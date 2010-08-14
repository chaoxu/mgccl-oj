import java.util.*;
public class pc110201 {
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			boolean[] a = new boolean[n];
			int x = in.nextInt();
			int y=0;
			for(int i=1;i<n;i++){
				y = in.nextInt();
				int d = Math.abs(x-y);
				x = y;
				if(d<n && d>0){
					a[d]=true;
				}
			}
			boolean b = true;
			for(int i=1;i<n;i++){
				if(!a[i]){
					b = false;
				}
			}
			if(b){
				System.out.println("Jolly");
			}else{
				System.out.println("Not jolly");
			}
		}
	}
}
