import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;


public class Windmill {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dataSets = Integer.parseInt(sc.nextLine());

		for (int c = 0; c < dataSets;c++) {

			String[] split = sc.nextLine().split(" ");
			int setNum = Integer.parseInt(split[0]);
			int numPoints = Integer.parseInt(split[1]);
			int numOutput = Integer.parseInt(split[2]);
			int initPoint = Integer.parseInt(split[3]);
			double startAng = Double.parseDouble(split[4]); //A - Start Angle - In Degrees!

			HashMap<Integer, Point2D> indexToPoint = new HashMap<Integer, Point2D>();
			HashMap<Point2D, Integer> pointToIndex = new HashMap<Point2D, Integer>();
			//Point2D[] points = new Point2D[numPoints + 1];
			//Point2D[] points = new Point2D[21];
			for (int i = 0;i < numPoints;i++) {
				String[] parse = sc.nextLine().split(" ");
				int index = Integer.parseInt(parse[0]);
				Point2D p = new Point2D.Double(Double.parseDouble(parse[1]), Double.parseDouble(parse[2]));
				//points[index] = p;
				pointToIndex.put(p, index);
				indexToPoint.put(index, p);
			}

			System.out.print(setNum);
			Point2D cur = indexToPoint.get(initPoint);
			Point2D startVec = new Point2D.Double(Math.cos(startAng * Math.PI / 180.0), Math.sin(startAng * Math.PI / 180.0));			
			Point2D prev = null;
			//System.out.println(cur);
			for (int i = 0;i < numOutput;i++) {
				Object[] ret = findNext(indexToPoint.values(), cur, prev, startVec);
				prev = cur;
				cur = (Point2D) ret[0];
				startVec = (Point2D) ret[1];
				//System.out.println(" " + (pointToIndex.get(cur) + 1) + " " + cur);
				System.out.print(" " + (pointToIndex.get(cur)));
			}
			System.out.println();
		}
	}

	static Point2D[] findNext(Collection<Point2D> points, Point2D start, Point2D prev, Point2D vector) {

		double maxAng = -2;
		Point2D nextPoint = null;
		Point2D nextvect = null;
		for (Point2D p : points) {
			if (p != null && !p.equals(start) && !p.equals(prev)) {
			//if (!points[i].equals(start) && !points[i].equals(prev)) {
				double xpt = p.getX()-start.getX();
				double ypt = p.getY()-start.getY();
				double xvect = vector.getX();
				double yvect = vector.getY();
				double costh = (xpt*xvect + ypt*yvect)/(Math.sqrt(xpt*xpt+ypt*ypt)*Math.sqrt(xvect*xvect+yvect*yvect));
				double cross = xpt*yvect - ypt*xvect;
				if(cross>0){
					costh = -costh;
				}
				if(costh>maxAng){
					maxAng = costh;
					nextPoint = p;
					nextvect = new Point2D.Double(xpt, ypt);
				}
			}
		}
		return new Point2D[] {nextPoint, nextvect}; //Return new point, and new angle
	}
}
