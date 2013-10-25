import java.awt.geom.Point2D;
import java.util.*;

public class Graphs {
	public static int[][] FloydWarshall(int[][] c){
		int n = c.length;
		int[][] d = new int[n][n];
		for(int i=0;i<n;i++){
			d[i] = c[i].clone();
		}
		for (int k = 0;k<n;k++)
		for (int i = 0;i<n;i++)
		for (int j = 0;j<n;j++)
			d[i][j] = Math.min( d[i][k] + d[k][j], d[i][j] );
		return d;
	}

	public static int minKey(int k[], boolean s[]){
	   int min = Integer.MAX_VALUE;
	   int i = 0;
	   for (int v = 0; v < k.length; v++){
	     if (s[v] == false && k[v] < min){
	         min = k[v];
	         i = v;
	     }
	   }
	   return i;
	}
	// didn't test, from here http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/
	public static int mst(int[][] c){
		 int n = c.length;
	     int[] p = new int[n];
	     int[] k = new int[n];
	     boolean[] s = new boolean[n];
	     Arrays.fill(k, Integer.MAX_VALUE);
	     k[0] = 0;
	     p[0] = -1;
	     for (int i = 0; i < n-1; i++){
	        int u = minKey(k, s);
	        s[u] = true;
	        for (int v = 0; v < n; v++){
	          // we assume c[u][v] = 0 if it's not an edge.
	          if (c[u][v] > 0 && !s[v] && c[u][v] <  k[v]){
	             p[v]  = u;
	             k[v] = c[u][v];
	          }
	        }
	     }
	     int cost = 0;
	     for(int i=1;i<n;i++){
	    	 cost += c[p[i]][i];
	     }
	     return cost;
	}
	
	public static void dijkstra(Graph g, Vertex s){
		for(Vertex v: g.Vertices){
			v.dis = Integer.MAX_VALUE;
			v.prev = null;
		} 
		s.dis = 0;// Distance from source to source
		
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>(g.order(),new sortBydis());
		q.add(s);
		while(!q.isEmpty()){
			Vertex u = q.poll();
			if(u.dis==Integer.MAX_VALUE){
				break;
			}
			for(Edge e: u.toedge){
				int alt = u.dis+e.weight;
				Vertex v = e.to;
				if(alt<v.dis){
					v.dis = alt;
					v.prev = u;
					q.remove(v);
					q.add(v);
				}
			}
		}
	}
}

class Graph{
	ArrayList<Vertex> Vertices;
	// int[][] EdgeDistance;
    // ArrayList<Edge> Edges;
	Graph(){
		Vertices = new ArrayList<Vertex>();
	}
	int order(){
		return Vertices.size();
	}
	
}
class Edge{
	Vertex from;
	Vertex to;
	int weight;
}
class Vertex{
	ArrayList<Edge> fromedge;
	ArrayList<Edge> toedge;
	int id;
	int dis;//useful if record distance
	Vertex prev;//useful if we want to trace back for dp
}

class sortBydis implements Comparator<Vertex>{
    public int compare(Vertex v, Vertex u) {
    	if(v.dis<u.dis){
    		return -1;
    	}
    	if(v.dis>u.dis){
    		return 1;
    	}
    	return 0;
	}
}
