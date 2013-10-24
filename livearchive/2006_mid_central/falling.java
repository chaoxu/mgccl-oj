import java.util.*;
import java.io.*;

public class falling {

	public static void main(String[] args) throws Exception {
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("falling.in"));
		
		double eps = 0.00001;
		
		int w = in.nextInt();
		while (w != 0) {
			int n = in.nextInt();
			int[] d = new int[n];
			
			for (int i=0; i<n; i++) {
				d[i] = in.nextInt();
			}
			
			double[] x = new double[n];
			double[] y = new double[n];
			double[] r = new double[n];
			
			double[] a = new double[n];
			double[] b = new double[n];
			
			for (int i=0; i<n; i++) {
				r[i] = 0.5*d[i];
			}
			
			x[0] = r[0];
			y[0] = r[0];
			
			a[0] = 0;
			b[0] = d[0];
			
			for (int i=1; i<n; i++) {
				// find location of x_i, y_i
				ArrayList<Double> xt = new ArrayList<Double>();
				ArrayList<Double> yt = new ArrayList<Double>();

				//find candidates
				if (true) {
					int rm = 0;
					for (int j=1; j<i; j++) {
						if (Math.abs(y[j]-r[j]) < eps && x[j] > x[rm]) rm = j;
					}

					double yc = r[i];
					double xc = x[rm] + (r[i] + r[rm])*Math.cos(Math.asin((r[rm]-r[i])/(r[rm]+r[i])));

					xt.add(xc);
					yt.add(yc);
				}

				for (int j=0; j<i; j++) {
					// left wall
					if (a[j] < d[i]) {
						double xc = r[i];
						double yc = y[j] + Math.sqrt((r[j]+r[i])*(r[j]+r[i]) - (x[j]-xc)*(x[j]-xc));

						xt.add(xc);
						yt.add(yc);
					}
				}

				for (int j=0; j<i; j++) {
					// right wall
					if (w-b[j] < d[i]) {
						double xc = w - r[i];
						double yc = y[j] + Math.sqrt((r[j]+r[i])*(r[j]+r[i]) - (xc-x[j])*(xc-x[j]));

						xt.add(xc);
						yt.add(yc);
					}
				}

				for (int j=0; j<i; j++) {
					for (int k=0; k<j; k++) {
						// two balls
						int jj = j;
						int kk = k;

						if (x[kk] < x[jj]) {
							int tmp = kk;
							kk = jj;
							jj = tmp;
						}

						if (Math.sqrt((x[kk]-x[jj])*(x[kk]-x[jj]) + (y[kk]-y[jj])*(y[kk]-y[jj])) + eps < d[i] + r[jj] + r[kk]) {
							double ll = r[jj] + r[kk];
							double mm = r[jj] + r[i];
							double nn = r[kk] + r[i];

							double theta = Math.acos((ll*ll + mm*mm - nn*nn)/(2*ll*mm));
							double alpha = Math.atan((y[kk] - y[jj])/(x[kk] - x[jj]));
							double beta = theta + alpha;

							double xc = x[jj] + mm*Math.cos(beta);
							double yc = y[jj] + mm*Math.sin(beta);

							xt.add(xc);
							yt.add(yc);
						}
					}
				}

				//eliminate invalid candidates
				for (int j=0; j<yt.size(); j++) {
					double xc = xt.get(j);
					double yc = yt.get(j);

					double ac = xc-r[i];
					double bc = xc+r[i];

					boolean bad = false;
					//intersection
					for (int k=0; k<i && !bad; k++) {
						bad = (r[k]+r[i])*(r[k]+r[i]) - ((x[k]-xc)*(x[k]-xc) + (y[k]-yc)*(y[k]-yc)) > eps;
						bad = bad || (bc - w) > eps;
						bad = bad || ac < -eps;
						bad = bad || yc < r[i] + eps;
					}

					//interval overlap
					for (int k=0; k<i && !bad; k++) {
						if (yc > y[k]) continue;

						bad = ((a[k] + eps < ac && ac < b[k] - eps) || (a[k] + eps < bc && bc < b[k] - eps));
					}

					if (bad) {
						xt.remove(j);
						yt.remove(j);
						j--;
					}
				}

				double min = Double.MAX_VALUE;
				int imin = 0;
				for (int j=0; j<yt.size(); j++) {
					double yc = yt.get(j);
					if (yc < min) {
						min = yc;
						imin = j;
					}
				}

				x[i] = xt.get(imin);
				y[i] = yt.get(imin);

				a[i] = x[i]-r[i];
				b[i] = x[i]+r[i];
			}
			
			
			double max = 0;
			
			for (int i=0; i<n; i++) {
				//System.out.println(i+" "+x[i]+" "+y[i]);
				double h = y[i] + r[i];
				if (h > max) max = h;
			}
			
			System.out.printf("%.2f\n", max);
			
			w = in.nextInt();
		}

	}

}

//for (int i=1; i<n; i++) {
//	// find location of x_i, y_i
//	boolean fall = true;
//	for (int j=0; j<i && fall; j++) {
//		fall = fall && (w > x[j]+r[j]+d[i]);
//	}
//	
//	if (fall) {
//		int rm = 0;
//		for (int j=1; j<i; j++) {
//			if (Math.abs(y[j]-r[j]) < eps && x[j] > x[rm]) rm = j;
//		}
//		
//		y[i] = r[i];
//		x[i] = x[rm] + (r[i] + r[rm])*Math.cos(Math.asin((r[rm]-r[i])/(r[rm]+r[i])));
//		
//		a[i] = x[i]-r[i];
//		b[i] = x[i]+r[i];
//	}
//	else {
//		ArrayList<Double> xt = new ArrayList<Double>();
//		ArrayList<Double> yt = new ArrayList<Double>();
//		
//		//find candidates
//		int rm = 0;
//		for (int j=1; j<i; j++) {
//			if (Math.abs(y[j]-r[j]) < eps && x[j] > x[rm]) rm = j;
//		}
//		
//		double yc = r[i];
//		double xc = x[rm] + (r[i] + r[rm])*Math.cos(Math.asin((r[rm]-r[i])/(r[rm]+r[i])));
//		
//		xt.add(xc);
//		yt.add(yc);
//
//		for (int j=0; j<i; j++) {
//			// left wall
//			if (a[j] < d[i]) {
//				double xc = r[i];
//				double yc = y[j] + Math.sqrt((r[j]+r[i])*(r[j]+r[i]) - (x[j]-xc)*(x[j]-xc));
//				
//				xt.add(xc);
//				yt.add(yc);
//			}
//		}
//		
//		for (int j=0; j<i; j++) {
//			// right wall
//			if (w-b[j] < d[i]) {
//				double xc = w - r[i];
//				double yc = y[j] + Math.sqrt((r[j]+r[i])*(r[j]+r[i]) - (xc-x[j])*(xc-x[j]));
//				
//				xt.add(xc);
//				yt.add(yc);
//			}
//		}
//		
//		for (int j=0; j<i; j++) {
//			for (int k=0; k<j; k++) {
//				// two balls
//				int jj = j;
//				int kk = k;
//				
//				if (x[kk] < x[jj]) {
//					int tmp = kk;
//					kk = jj;
//					jj = tmp;
//				}
//				
//				if (Math.sqrt((x[kk]-x[jj])*(x[kk]-x[jj]) + (y[kk]-y[jj])*(y[kk]-y[jj])) + eps < d[i] + r[jj] + r[kk]) {
//					double ll = r[jj] + r[kk];
//					double mm = r[jj] + r[i];
//					double nn = r[kk] + r[i];
//					
//					double theta = Math.acos((ll*ll + mm*mm - nn*nn)/(2*ll*mm));
//					double alpha = Math.atan((y[kk] - y[jj])/(x[kk] - x[jj]));
//					double beta = theta + alpha;
//					
//					double xc = x[jj] + mm*Math.cos(beta);
//					double yc = y[jj] + mm*Math.sin(beta);
//					
//					xt.add(xc);
//					yt.add(yc);
//				}
//			}
//		}
//		
//		//eliminate invalid candidates
//		for (int j=0; j<yt.size(); j++) {
//			double xc = xt.get(j);
//			double yc = yt.get(j);
//			
//			double ac = xc-r[i];
//			double bc = xc+r[i];
//			
//			boolean bad = false;
//			//intersection
//			for (int k=0; k<i && !bad; k++) {
//				bad = (r[k]+r[i])*(r[k]+r[i]) - ((x[k]-xc)*(x[k]-xc) + (y[k]-yc)*(y[k]-yc)) > eps;
//				bad = bad || (bc - w) > eps;
//				bad = bad || ac < -eps;
//				bad = bad || yc < r[i] + eps;
//			}
//			
//			//interval overlap
//			for (int k=0; k<i && !bad; k++) {
//				if (yc > y[k]) continue;
//				
//				bad = ((a[k] + eps < ac && ac < b[k] - eps) || (a[k] + eps < bc && bc < b[k] - eps));
//			}
//			
//			if (bad) {
//				xt.remove(j);
//				yt.remove(j);
//				j--;
//			}
//		}
//		
//		double min = Double.MAX_VALUE;
//		int imin = 0;
//		for (int j=0; j<yt.size(); j++) {
//			double yc = yt.get(j);
//			if (yc < min) {
//				min = yc;
//				imin = j;
//			}
//		}
//		
//		x[i] = xt.get(imin);
//		y[i] = yt.get(imin);
//		
//		a[i] = x[i]-r[i];
//		b[i] = x[i]+r[i];
//	}
//}

