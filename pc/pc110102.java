import java.util.Scanner;
public class pc110102 {
		 public static void main(String args[]){
		        Scanner s = new Scanner(System.in);
		        int x = s.nextInt();
		        int y = s.nextInt();
		        int t=0;
		        while(x!=0&&y!=0){
		        	t++;
		        	int[][] m;
		        	m = new int[x][y];
		        	s.nextLine();
		        	for(int i =0;i<x;i++){
		        		String str = s.nextLine();
		        		for(int j = 0;j<y;j++){
		        			if(str.charAt(j)=='*'){
		        				m[i][j]=-100000;
		        				if(i-1>=0){
		        					if(j-1>=0){
		        						m[i-1][j-1]+=1;
		        					}
		        					m[i-1][j]+=1;
		        					if(j+1<y){
		        						m[i-1][j+1]+=1;
		        					}
		        				}
		        				if(j-1>=0){
		        					m[i][j-1]+=1;
		        				}
		        				if(j+1<y){
		        					m[i][j+1]+=1;
		        				}
		        				if(i+1<x){
		        					if(j-1>=0){
		        						m[i+1][j-1]+=1;
		        					}
		        					m[i+1][j]+=1;
		        					if(j+1<y){
		        						m[i+1][j+1]+=1;
		        					}
		        				}
		        			}
		        		}
		        	}
		        	if(t!=1){
		        		System.out.println("");
		        	}
		        	System.out.println("Field #"+t+":");
	        		for(int i =0;i<x;i++){
		        		for(int j = 0;j<y;j++){
		        			if(m[i][j]>=0){
		        				System.out.print(m[i][j]);
		        			}else{
		        				System.out.print("*");
		        			}
		        		}
		        		System.out.println("");
		        	}
		        	x = s.nextInt();
		        	y = s.nextInt();
		        }
		 }
}
