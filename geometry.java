import java.util.*;

public class geometry {
	public static ArrayList<P> ConvexHull(ArrayList<P> l){
		if(l.size()<=1){
			return l;
		}
		Collections.sort(l);
		ArrayList<P> h = HalfConvexHull(l);
		Collections.reverse(l);
		h.addAll(HalfConvexHull(l));
		return h;
	}
	public static ArrayList<P> HalfConvexHull(ArrayList<P> l){
		ArrayList<P> h = new ArrayList<P>();
		for(P p:l){
			int n = h.size();
			while(n >= 2 && cross(h.get(n-2), h.get(n-1), p) <= 0){
			     h.remove(n-1);
			     n = h.size();
			}
			h.add(p);
		}
		h.remove(h.size()-1);
		return h;
	}
	public static double cross(P o, P a, P b){
		return (a.x-o.x) * (b.y - o.y) - (a.y-o.y) * (b.x - o.x);
	}
}

class P implements Comparable{
	double x;
	double y;
	P(double a, double b){
		x=a;
		y=b;
	}
	public int compareTo(Object o2){
		P o = (P) o2;
		if(x<o.x){
			return -1;
		}else if(x>o.x){
			return 1;
		}
		
		if(y<o.y){
			return -1;
		}else if(y>o.y){
			return 1;
		}
		return 0;
	}
	public String toString(){
		return "("+String.valueOf(x)+","+String.valueOf(y)+")";
	}
}
