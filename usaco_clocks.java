/*
ID: mgcclx1
LANG: JAVA
TASK: clocks
*/
import java.util.*;
import java.io.*;
public class usaco_clocks {
	static int[][] m;
	static int[] a = new int[9];
	public static void main(String args[]) throws IOException{
    	Scanner in = new Scanner(new File("clocks.in"));
    	FileWriter fstream = new FileWriter("clocks.out");
        BufferedWriter out = new BufferedWriter(fstream);

    	for(int i=0;i<9;i++){
    		a[i] = (in.nextInt()/3)%4;
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
    	int max = 999;
    	int b = 0;
    	for(int i=0;i<262144;i++){
    		int t = f(i);
    		if(t>=0 && t<max){
    			max = t;
    			b = i;
    		}
    	}
    	int z = 1;
    	int f = 0;
    	
    	while(b!=0){
			int t = b%4;
			b = b/4;
			for(int i=0;i<t;i++){
				if(f==0){
					out.write(String.valueOf(z));
					//System.out.print(z);
					f=1;
				}else{
					out.write(" "+z);
					//System.out.print(" "+z);
				}
			}
			z++;
		}
    	
    	//System.out.println();
    	out.write("\n");
    	out.close();
	}
	
	public static int f(int n){
		int[] c = new int[9];
		for(int i=0;i<9;i++){
			c[i] = a[i];
		}
		int b=0;
		int sum = 0;
		while(n!=0){
			int t = n%4;
			n = n/4;
			for(int i=0;i<9;i++){
				c[i] = (c[i]+m[b][i]*t)%4;
			}
			b++;
			sum+=t;
		}
		
		for(int i=0;i<9;i++){
			if(c[i]!=0){
				return -1;
			}
		}
		return sum;
	}
}
