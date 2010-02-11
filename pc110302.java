import java.util.*;
public class pc110302 {
	static char m[][];
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i=0;i<n;i++){
			if(i!=0){
				System.out.println();
			}
			m =  new char[160][160];
			int h = in.nextInt();
			int w = in.nextInt();
			for(int j=0;j<h;j++){
				char[] c = in.next().toLowerCase().toCharArray();
				for(int k=0;k<w;k++){
					m[50+j][50+k] = c[k];
				}
			}
			int t = in.nextInt();
			ArrayList<String> s= new ArrayList<String>();
			for(int j=0;j<t;j++){
				s.add(in.next().toLowerCase());
			}
			boolean[] a = new boolean[t];
			for(int o=0;o<t;o++){
				for(int j=0;j<h;j++){
					for(int k=0;k<w;k++){
						if(search(s.get(o),50+j,50+k)){
							System.out.println((j+1)+" "+(k+1));
							a[o]=true;
							break;
						}
					}
					if(a[o]){
						break;
					}
				}
			}
		}
	}
	
	static boolean search(String s,int i, int j){
		int a[][] = new int[8][2];
		a[0][0]=0;
		a[1][0]=1;
		a[2][0]=1;
		a[3][0]=1;
		a[4][0]=0;
		a[5][0]=-1;
		a[6][0]=-1;
		a[7][0]=-1;
		
		a[0][1]=-1;
		a[1][1]=-1;
		a[2][1]=0;
		a[3][1]=1;
		a[4][1]=1;
		a[5][1]=1;
		a[6][1]=0;
		a[7][1]=-1;
		
		for(int k=0;k<8;k++){
			int x=0;
			int y=0;
			boolean t=true;
			for(int n=0;n<s.length();n++){
				if(m[x+i][y+j]!=s.charAt(n)){
					t = false;
					break;
				}
				x+=a[k][0];
				y+=a[k][1];
			}
			if(t){
				return true;
			}
		}
		return false;
	}
}
