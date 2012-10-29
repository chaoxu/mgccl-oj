import java.util.*;
public class C {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int N = 10001;
        int[] t = new int[2*N+1];
    	for(int c=1;c<N/3+1;c++){
    		for(int b=c;b<(N-c)/2+1;b++){
        		for(int a=b;a<N/2+1;a++){
        			int m = a+b+c;
        			//if(a+b+c==n&&b+c>a){
        			if(b+c>a){
        				if(a>b&&b>c){
        					t[m]++;
        					//count++;
        				}
        				t[m]++;
        				//count++;
        			//}
        			}
        		}
        	}
    	}
    	/*for(int i=0;i<=N;i++){
    		if(i%10==0){
    		//	System.out.println();
    		}
    		//System.out.print(t[i]+", ");
    	}*/
    	
    	int oo = in.nextInt();
        for(int o=0;o<oo;o++){
        	int z = in.nextInt();
        	int n = in.nextInt();
        	int count = 0;
        	System.out.println(z+" "+t[n]);
        }
    }
}
