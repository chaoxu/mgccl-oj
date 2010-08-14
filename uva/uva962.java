import java.util.*;
public class uva962 {
	static int[] c = new int[1001];
    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	//Precompute all cubes
    	for(int i=1;i<1001;i++){
    		c[i] = i*i*i;
    	}
    	//Find all possible sums
    	HashSet<Integer> h = new HashSet<Integer>();
    	HashSet<Integer> t = new HashSet<Integer>();
    	for(int i=1;i<1001;i++){
        	for(int j=i;j<1001;j++){
        		int k = c[i]+c[j];
        		if(k>1000100001){
        			break;
        		}
        		if(h.contains(k)){
        			t.add(k);
        		}else{
        			h.add(k);
        		}
        	}
    	}
    	//Create a sorted array from t.
    	Integer[] a = new Integer[t.size()];
    	t.toArray(a);
    	Arrays.sort(a);
    	while(in.hasNext()){
    		int n = in.nextInt();
    		int r = in.nextInt();
    		int i = Arrays.binarySearch(a, n);
    		if(i<0){
    			i= Math.abs(i)-1;
    		}
    		int count = 0;
    		while(i<a.length && a[i]<=n+r){
        		System.out.println(a[i]);
        		i++;
        		count++;
        	}
    		if(count==0){
    			System.out.println("None");
    		}
    	}
    }
}
