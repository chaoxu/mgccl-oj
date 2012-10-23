import java.util.*;
import java.awt.geom.*;
public class geometry {
	public static ArrayList<Point2D> ConvexHull(ArrayList<Point2D> l){
		if(l.size()<=1){
			return l;
		}
		Collections.sort(l, new sortByX());
		ArrayList<Point2D> h = HalfConvexHull(l);
		Collections.reverse(l);
		h.addAll(HalfConvexHull(l));
		return h;
	}
	public static ArrayList<Point2D> HalfConvexHull(ArrayList<Point2D> l){
		ArrayList<Point2D> h = new ArrayList<Point2D>();
		for(Point2D p:l){
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
	public static double cross(Point2D o, Point2D a, Point2D b){
		return (a.getX()-o.getX()) * (b.getY() - o.getY()) - (a.getY()-o.getY()) * (b.getX() - o.getX());
	}
}

class sortByX implements Comparator<Point2D>{
    public int compare(Point2D o1, Point2D o2) {
    	if(o1.getX()<o2.getX()){
    		return -1;
    	}else if(o1.getX()>o2.getX()){
    		return 1;
    	}
		if(o1.getY()<o2.getY()){
    		return -1;
    	}else if(o1.getY()>o2.getY()){
    		return 1;
    	}
		return 0;
	}
}
