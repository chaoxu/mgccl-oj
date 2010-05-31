// TLE
import java.util.*;
public class poj1166 {
	static int[][] m;
	static int[] a = new int[9];
	static int min=999;
	static int[] sol = new int[9];
	public static void main(String args[]) {
    	Scanner in = new Scanner(System.in);

    	for(int i=0;i<9;i++){
    		a[i] = in.nextInt();
    	}
    	m = new int[9][9];
 /*   	A0,B1,C2,D3,E4,F5,G6,H7,I8
    	0	 0134
    	1	 012
    	2	 1245
    	3	 036
    	4	 13457
    	5	 258
    	6	 3467
    	7	 678
    	8	 4578*/
    	m[8][4] = 1;
    	m[8][5] = 1;
    	m[8][7] = 1;
    	m[8][8] = 1;
    	
    	m[7][6] = 1;
    	m[7][7] = 1;
    	m[7][8] = 1;
    	
    	m[6][3] = 1;
    	m[6][4] = 1;
    	m[6][6] = 1;
    	m[6][7] = 1;
    	
    	m[5][2] = 1;
    	m[5][5] = 1;
    	m[5][8] = 1;
    	
    	m[4][1] = 1;
    	m[4][3] = 1;
    	m[4][4] = 1;
    	m[4][5] = 1;
    	m[4][7] = 1;
    	
    	m[3][0] = 1;
    	m[3][3] = 1;
    	m[3][6] = 1;
    	
    	m[0][0] = 1;
    	m[0][1] = 1;
    	m[0][3] = 1;
    	m[0][4] = 1;
    	
    	m[1][0] = 1;
    	m[1][1] = 1;
    	m[1][2] = 1;
    	
    	m[2][1] = 1;
    	m[2][2] = 1;
    	m[2][4] = 1;
    	m[2][5] = 1;

		g(new int[9],0);
    	int f = 0;
    	for(int j=0;j<9;j++){
			for(int i=0;i<sol[j];i++){
				if(f==0){
					System.out.print(j+1);
					f=1;
				}else{
					System.out.print(" "+(j+1));
				}
			}
		}
    	System.out.println();
	}
	
	public static void g(int[] k, int j){
		if(j!=9){
			for(int i=0;i<4;i++){
				k[j] = i;
				g(k,j+1);
			}
			return;
		}
		int[] c = new int[9];
		for(int i=0;i<9;i++){
			c[i] = a[i];
		}
		int sum = 0;
		for(int t=0;t<9;t++){
			for(int i=0;i<9;i++){
				c[i] = (c[i]+m[t][i]*k[t])%4;
			}
			sum+=k[t];
		}
		if(sum>min){
			return;
		}
		for(int i=0;i<9;i++){
		    if(c[i]!=0){
				return;
			}
		}
		sol = Arrays.copyOf(k,9);
		min = sum;
	}
}
