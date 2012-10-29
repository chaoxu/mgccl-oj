import java.util.*;
import java.text.*;

class Node{
	int[] a;
	Node prev;
	int depth;
	Node(int[] b, Node p, int d){
		a = b;
		prev = p;
		depth = d;
	}
	public boolean equals(Object o){
		Node p = (Node) o;
		for(int i=0;i<3;i++){
			if(p.a[i]!=a[i]){
				return false;
			}
		}
		return true;
	}
	public int hashCode(){
		return a[0]+a[1]*50+a[2]*50*50;
	}
	public String toString(){
		return depth+"| "+a[0]+" "+a[1]+" "+a[2];
	}
}
public class G {
	static HashSet<Node> h;
	static Queue<Node> q = new LinkedList<Node>();
	static int[][] m;
	static int MAX = 50;
	static int count = 0;
    public static Node bfs(Node e){
    	while(!q.isEmpty()){
    		
    		Node v = q.poll();
    		//System.out.println(v);
    		count++;

    		if(v.equals(e)){
    			return v;
    		}
    		//try all 3 cases
    		for(int i=0;i<3;i++){
    			//System.out.println(i);
    			add(move(i, true, v));
    			add(move(i, false,v));
    		}
    	}
    	return null;
    }
    public static void add(Node v){
    	if(v==null){
    		return;
    	}
    	if(h.contains(v)){
    		return;
    	}
    	h.add(v);
    	q.add(v);
    }
    public static Node move(int trans, boolean reverse, Node v){
    	int[] n = new int[3];
    	for(int i=0;i<3;i++){
			n[i] = v.a[i];
		}
    	if(!reverse){
    		for(int i=0;i<3;i++){
    			n[i]-=m[trans][i];
    		}
    		//System.out.println(reverse);
    		//p(n);
    		for(int i=0;i<3;i++){
    			if(n[i]<0){
    				return null;
    			}
    		}
    		n[trans]+=1;
    	}else{
    		if(n[trans]>0){
    			n[trans]--;
	    		for(int i=0;i<3;i++){
	    			n[i] +=m[trans][i];

	    		}
	    		//System.out.println(reverse);
	    		//p(n);
	    		for(int i=0;i<3;i++){
	    			if(n[i]>MAX){
	    				return null;
	    			}
	    		}
    		}else{
    			return null;
    		}
    	}
    	return (new Node(n,v,v.depth+1));
    }
    public static void p(int[] a){
    	System.out.println("("+a[0]+","+a[1]+","+a[2]+")");
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int oo = in.nextInt();
        
        for(int o=0;o<oo;o++){
        	int z = in.nextInt();
        	int n = in.nextInt();
        	//number of puzzles
        	m = new int[3][3];
        	for(int i=0;i<3;i++){
	        	for(int j=0;j<3;j++){
	        		m[i][j] = in.nextInt();
	        	}
        	}
        	System.out.println(z+" "+n);
        	for(int qq=0;qq<n;qq++){
	        	int z2 = in.nextInt();
	        	int[] start = new int[3];
	        	for(int i=0;i<3;i++){
	        		start[i] = in.nextInt();
	        	}
	        	int[] end = new int[3];
	        	for(int i=0;i<3;i++){
	        		end[i] = in.nextInt();
	        	}
	        	
	        	q = new LinkedList<Node>();
	        	Node s = new Node(start,null,0);
	        	Node s2 = new Node(start,null,0);
	        	q.add(s);
	        	h = new HashSet<Node>();
	        	h.add(s);
	        	
	        	Node v = bfs(new Node(end,null,0));
	        	
	        	if(v==null){
	        		System.out.println(z2+" NO SOLUTION");
	        	}else{
	        		System.out.println(z2+" "+v.depth+" "+build(v));
	        	}
	        	//System.out.println(h.size());
        	}
        	//System.out.println(h);
        	//start build the graph

            //System.out.println(z+" "+a);
        }
    }
    
    public static String rmove(Node v, Node u){
    	if(move(0, true, v)!=null && move(0, true, v).equals(u)){
    		return "a";
    	}
    	if(move(0, false, v)!=null && move(0, false, v).equals(u)){
    		return "A";
    	}
    	if(move(1, true, v)!=null && move(1, true, v).equals(u)){
    		return "b";
    	}
    	if(move(1, false, v)!=null && move(1, false, v).equals(u)){
    		return "B";
    	}
    	if(move(2, true, v)!=null && move(2, true, v).equals(u)){
    		return "c";
    	}
    	if(move(2, false, v)!=null && move(2, false, v).equals(u)){
    		return "C";
    	}
    	return "X";
    }
    public static String build(Node v){
    	if(v.prev!=null){
    		return build(v.prev)+rmove(v,v.prev);
    	}
    	return "";
    }

    public int[][] floyd(int[][] g){
    	int n = g.length;
    	for(int k=1;k<=n;k++){
    		for(int i=1;i<=n;i++){
        		for(int j=1;j<=n;j++){
        			int through = g[i][k]+g[k][j];
        			g[i][j] = Math.min(g[i][j],through);
        		}
    		}
    	}
    	return g;
    }
}
