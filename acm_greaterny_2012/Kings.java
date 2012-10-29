import java.util.Scanner;


public class Kings {

	public static void main(String[] args){
		long[][][] vals = new long[21][21][2];
		long[] tot = new long[21];
		tot[1]=1;
		vals[1][1][0] = 1;
		vals[1][1][1] = 1;
		for(int n=2; n<=20; n++){
			for(int k=1; k<=n; k++){
				for(int d=0; d<=1; d++){
					if(d==0){
						for(int i=1;i<=k-1;i++){
							vals[n][k][d]=vals[n][k][d]+vals[n-1][i][1];
							tot[n]=tot[n]+vals[n-1][i][1];
						}
					}
					else{
						for(int i=k;i<=n-1;i++){
							vals[n][k][d]=vals[n][k][d]+vals[n-1][i][0];
							tot[n]=tot[n]+vals[n-1][i][0];
						}
					}
				}
			}
		}
		/*for(int i=1; i<=20; i++){
			System.out.println(tot[i]+"");
		}*/
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		for(int i=1; i<=cases; i++){
			int num = scan.nextInt();
			int other = scan.nextInt();
			System.out.println(num+" "+tot[other]);
		}
	}
	
}
