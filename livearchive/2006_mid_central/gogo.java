import java.util.*;
class Node{
	int id;
	double x;
	double y; 
	double z;
	Node(int u,int a,int b,int c){
		id = u;
		x = a;
		y = b;
		z = c;
	}
	double dis(Node v){
		double t = (v.x-x)*(v.x-x)+(v.y-y)*(v.y-y)+(v.z-z)*(v.z-z);
		return Math.abs(t);
	}
	public String toString(){
		return id + " " + x + " " + y + " " + z;
	}
}
public class gogo {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double M = 10000.0*10000.0*10000.0*10000.0;
		
		while(n!=0){
			ArrayList<Node> a = new ArrayList<Node>();
			ArrayList<Integer> nodes = new ArrayList<Integer>();
			int[][] d = new int[1001][1001];
			for(int i=0;i<n;i++){
				Node v = new Node(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
				nodes.add(v.id);
				double min = M;
				int mini = 0;
				
				for(int j=0;j<i;j++){
					//System.out.println(a.get(j).dis(v)+" "+min);
					if(a.get(j).dis(v)<min){
						min = a.get(j).dis(v);
						mini = j;
					}
				}
				a.add(v);
				// connect mini and v
				for(int j=0;j<i;j++){
					//System.out.println(nodes.get(i)+" "+nodes.get(j)+" "+min);
					d[nodes.get(i)][nodes.get(j)] = 1 + d[nodes.get(mini)][nodes.get(j)];
					d[nodes.get(j)][nodes.get(i)] = d[nodes.get(i)][nodes.get(j)];
				}
			}
			//System.out.println(a);
			// pick the best position
			
			double rmin = M;
			int rmini = 0;
			
			for(int i=0;i<6;i++){
				for(int j=0;j<6;j++){
				//	System.out.print(d[i][j]+" ");
				}
				//System.out.println();
			}
			for(int i=0;i<nodes.size();i++){
				int b = nodes.get(i);
				double max = 0;
				for(int j=0;j<nodes.size();j++){
					max = Math.max(max, d[b][nodes.get(j)]);
				}
				if(max<rmin){
					rmin = max;
					rmini = i;
				}
			}
			ArrayList<Integer> o = new ArrayList<Integer> ();
			for(int i=0;i<nodes.size();i++){
				int b = nodes.get(i);
				double max = 0;
				for(int j=0;j<nodes.size();j++){
					max = Math.max(max, d[b][nodes.get(j)]);
				}
				//System.out.println(max + " " + rmin);
				if(max==rmin){
					o.add(nodes.get(i));
				}
			}
			Collections.sort(o);
			System.out.print(o.get(0));
			if(o.size()==2){
				System.out.println(" "+o.get(1));
			}else{
				System.out.println();
			}
			n = in.nextInt();
		}
	}
}
