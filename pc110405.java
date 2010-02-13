import java.util.*;
public class pc110405 {
	static int[] d;
	static int[][] s;
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			if(i!=0){
				System.out.println();
			}
			int m = in.nextInt();
			s = new int[m][2];
			d = new int[m];
			for(int j=0;j<m;j++){
				s[j][0] = in.nextInt();
				s[j][1] = in.nextInt();
			}
			find_next(m);
		}
	}
	
	static void find_next(int m){
		if(m==1){
			for(int i=0;i<s.length;i++){
				if(d[i]!=1){
					System.out.println(i+1);
					return;
				}
			}
		}
		for(int i=0;i<s.length;i++){
			if(d[i]!=1){
				//select as pivot
				boolean p = true;
				for(int j=i+1;j<s.length;j++){
					if(d[j]!=1){
						if(s[i][0]*s[j][1]>s[j][0]*s[i][1]){
							p = false;
							break;
						}
					}
				}
				if(p){
					System.out.print(i+1+" ");
					d[i]=1;
					find_next(m-1);
					return;
				}
			}
		}
	}
}