import java.util.*;
public class pc111103 {
	static int[] w,c,u;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] w2 = new int[5607];
        int[] c2 = new int[5607];
        int i=0;
        while(in.hasNextLine()){
        	w2[i] = in.nextInt();
        	c2[i] = in.nextInt();
        	in.nextLine();
        	i++;
        }
        w = new int[i];
        c = new int[i];
        u = new int[i];
        int n=i;
        for(i=0;i<n;i++){
        	c[i] = c2[i] - w2[i];
        	w[i] = w2[i];
        }
        int max = 2147483647;
        for(i=0;i<c.length;i++){
        	max = find_max(max);
        	if(max==-1){
        		break;
        	}
        }
        System.out.println(i);
    }   
    
    public static int find_max(int max){
    	int n=-1;
    	int p=0;
    	for(int i=0;i<c.length;i++){
    		if(u[i]!=1){
    			if(max-w[i]>0){
    				int t =Math.min(max-w[i], c[i]);
    				if(t>n){
    					n = t;
    					p = i;
    				}
    			}
    		}
    	}
    	u[p]=1;
    	return n;
    }
}
