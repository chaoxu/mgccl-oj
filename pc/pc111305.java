import java.util.*;
public class pc111305 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt()*2;
        Random generator = new Random();
        while(n!=0){
        	int[][] t = new int[n][2];
        	for(int i=0;i<n;i++){
        		t[i][0]=in.nextInt();
        		t[i][1]=in.nextInt();
        	}
        	while(true){
        		int a = generator.nextInt(1001)-500;
        		int b = generator.nextInt(1001)-500;
        		int u = 0;
        		int v = 0;
        		boolean fail = false;
        		for(int i=0;i<n;i++){
        			if(a*t[i][0]+b*t[i][1]==0){
        				fail = true;
        				break;
        			}
        			if(a*t[i][0]+b*t[i][1]>0){
        				u++;
        			}
        			if(a*t[i][0]+b*t[i][1]<0){
        				v++;
        			}
        		}
        		if(u==v&&fail==false){
        			System.out.println(a+" "+b);
        			break;
        		}
        	}
        	n = in.nextInt()*2;
        }
    }
}
