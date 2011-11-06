import java.util.*;
public class p4906 {
	static char[][] b;
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int v = in.nextInt();
		int o = in.nextInt();
		int m = in.nextInt();
		int c = 1;
		while(v!=0||o!=0||m!=0){
			b = new char[101][101];
			for(int i=0;i<101;i++){
				for(int j=0;j<101;j++){
					b[i][j]=' ';
				}
			}
			int[] x = new int[v];
			int[] y = new int[v];
			for(int i=0;i<v;i++){
				x[i] = in.nextInt();
				y[i] = in.nextInt();
				b[x[i]][y[i]] = 'v';
			}
			for(int i=0;i<o;i++){
				b[in.nextInt()][in.nextInt()] = 'M';
			}
			for(int i=0;i<m;i++){
				set(in.next().charAt(0),in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
			}
			
			System.out.println("Case "+c+":");
			c++;
			boolean none = true;
			for(int i=0;i<v;i++){
				
				boolean e=false,n=false,s=false,w=false;
				//test for west
				for(int z=x[i];z>-1;z--){
					if(b[z][y[i]]=='M'||
						b[z][y[i]]=='S'||
						b[z][y[i]]=='N'||
						b[z][y[i]]=='W'){
						break;
					}
					if(b[z][y[i]]=='E'){
						w=true;
						break;
					}
				}
				
				//test for north
				for(int z=y[i];z>-1;z--){
					if(b[x[i]][z]=='M'||
						b[x[i]][z]=='S'||
						b[x[i]][z]=='W'||
						b[x[i]][z]=='E'){
						break;
					}
					if(b[x[i]][z]=='N'){
						s=true;
						break;
					}
				}
				//test for south
				
				for(int z=y[i];z<101;z++){
					if(b[x[i]][z]=='M'||
						b[x[i]][z]=='N'||
						b[x[i]][z]=='W'||
						b[x[i]][z]=='E'){
						break;
					}
					if(b[x[i]][z]=='S'){
						n=true;
						break;
					}
				}
				
				//test for east
				for(int z=x[i];z<101;z++){
					if(b[z][y[i]]=='M'||
						b[z][y[i]]=='S'||
						b[z][y[i]]=='N'||
						b[z][y[i]]=='E'){
						break;
					}
					if(b[z][y[i]]=='W'){
						e=true;
						break;
					}
				}
				
				if(e||n||s||w){
					if(none){
						none=false;
						//System.out.println();
					}
					System.out.print("vampire "+(i+1));
					if(e){
						System.out.print(" east");
					}
					if(n){
						System.out.print(" north");
					}
					if(s){
						System.out.print(" south");
					}
					if(w){
						System.out.print(" west");
					}
					System.out.println();
				}
			}
			if(none){
				System.out.println("none");
			}
			v = in.nextInt();
			o = in.nextInt();
			m = in.nextInt();
		}
	}
	
	public static void set(char c, int x1, int y1, int x2, int y2){
		if(x1==x2){
			int a = Math.min(y1, y2);
			int d = Math.max(y1, y2);
			for(int i=a;i<=d;i++){
				b[x1][i] = c;
			}
		}else{
			int a = Math.min(x1, x2);
			int d = Math.max(x1, x2);
			for(int i=a;i<=d;i++){
				b[i][y1] = c;
			}
		}
	}
}
