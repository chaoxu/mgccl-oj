import java.util.*;
public class pc111101 {
	static int[][] m;
	static int[][] c;
	static int[] r;
	static ArrayList<Integer> s = new ArrayList<Integer>();
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        ArrayList<int[]> a = new ArrayList<int[]>();
        int o=0;
        while(in.hasNextInt()){
        	int[] t = new int[3];
        	t[0] = in.nextInt();
        	t[1] = in.nextInt();
        	t[2] = o;
        	o++;
        	a.add(t);
        }
        //The column
        c = new int[a.size()+1][];
        //The row
        r = new int[a.size()+1];
        c[0] = new int[3];
        Collections.sort(a,new sorttemplate());
        Set<Integer> ss = new HashSet<Integer>();
        for(int i=0;i<a.size();i++){
        	c[i+1] = a.get(i);
        	ss.add(a.get(i)[1]);
        }
        Integer[] p = new Integer[ss.size()];
        ss.toArray(p);
        r = new int[p.length+1];
        for(int i=0;i<p.length;i++){
        	r[i+1] = p[i];
        }
        Arrays.sort(r);
        
        //Got the column(sorted by IQ)
        m = new int[a.size()+1][r.length];
        for(int i=1;i<=a.size();i++){
        	for(int j=1;j<r.length;j++){
        		if(c[i][1]==r[j]){
        			m[i][j] = m[i-1][j-1]+1;
        		}else{
        			m[i][j] = Math.max(m[i][j-1],m[i-1][j]);
        		}
        	}
        }
        construct_path(a.size(),r.length-1);
        System.out.println(s.size());
        for(int i=0;i<s.size();i++){
        	System.out.println(s.get(i)+1);
        }
    }
    
    public static void construct_path(int x, int y){
    	if(m[x][y]==0){
    		return;
    	}
    	//Test which one is better
    	if(c[x][1]==r[y]){
    		s.add(c[x][2]);
			construct_path(x-1,y-1);
    	}else if(m[x-1][y]>m[x][y-1]){
    		construct_path(x-1,y);
    	}else{
    		construct_path(x,y-1);
    	}
    }
}
class sorttemplate implements Comparator<int[]>{

    public int compare(int[] o1, int[] o2) {
    	if(o1[0]>o2[0]){
    		return -1;
    	}
    	if(o1[0]<o2[0]){
    		return 1;
    	}
    	return 0;
    }
}
