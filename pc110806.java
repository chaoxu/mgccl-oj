import java.util.*;
public class pc110806 {
	public static int[] r = new int[8];
	public static int[] s;
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
        	gen_rule(in.nextInt());
        	in.nextInt();
        	String str = in.next();
        	s = to_bin_array(str);
        	int[] t = new int[str.length()];
        	if(find_origin(t,0)){
        		System.out.println("REACHABLE");
        	}else{
        		System.out.println("GARDEN OF EDEN");
        	}
        }
    }
    public static boolean find_origin(int[] p, int n) {
    	//initialize
    	if(n==0){
        	if(find_origin(p,1)){
        		return true;
        	}
        	p[1] = 1;
        	if(find_origin(p,1)){
        		return true;
        	}
        	p[0] = 1;
        	if(find_origin(p,1)){
        		return true;
        	}
        	p[1] = 0;
        	if(find_origin(p,1)){
        		return true;
        	}
        	return false;
    	}
    	if(n==s.length-1){
    		//end condition
    		if(r[p[n-1]*4+p[n]*2+p[0]] == s[n]&&
    			r[p[n]*4+p[0]*2+p[1]] == s[0]){
    			return true;
    		}
    		return false;
    	}
    	//check if put down 0 is ok.
    	if(r[p[n-1]*4+p[n]*2] == s[n]){
    		p[n+1] = 0;
    		if(find_origin(p, n+1)){
    			return true;
    		}
    	}
    	if(r[p[n-1]*4+p[n]*2+1] == s[n]){
    		p[n+1] = 1;
    		if(find_origin(p, n+1)){
    			return true;
    		}
    	}
    	return false;
    }
    
	public static int[] to_bin_array(String s){
		int[] t = new int[s.length()];
		for(int i=0;i<s.length();i++){
			t[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
		}
		return t;
	}
    public static void gen_rule(int n){
    	for(int i=0;i<8;i++){
    		r[i] = n%2;
    		n/=2;
    	}
    }
}
