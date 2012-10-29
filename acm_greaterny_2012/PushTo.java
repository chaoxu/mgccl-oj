import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


public class PushTo {
	
	static double[] cross(double[] a, double[] b){
		double[] x = new double[3];
		x[0]=a[1]*b[2]-a[2]*b[1];
		x[1]=a[2]*b[0]-a[0]*b[2];
		x[2]=a[0]*b[1]-a[1]*b[0];  
		return x;
	}
	
	static double dot(double[] a, double[] b){
		double sum = 0;
		for(int i=0;i<3;i++){
			sum+=a[i]*b[i];
		}
		return sum;
	}
	
	static double[] diff(double[] x, double[] y){
		double[] ans = {x[0]-y[0],x[1]-y[1],x[2]-y[2]};
		return ans;
	}
	
	static double[] quad(double[] x){
		double a = x[0];
		double b = x[1];
		double c = x[2];
		
		double det = Math.sqrt(b*b - 4.0*a*c);
		double[] r = new double[2];
		r[0] = (-b-det)/(2.0*a);
		r[1] = (-b+det)/(2.0*a);
		return r;
	}
	
	public static double sqdist3D(double[] pt1, double[] pt2){
		double ans = 0;
		for(int i=0; i<3; i++){
			ans+=(pt1[i]-pt2[i])*(pt1[i]-pt2[i]);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("0.0");
		double earthRot = Math.PI * 2 * 1.0027379093 / 86400.0; //radians / sec
		
		Scanner sc = new Scanner(System.in);
		String[] parse = sc.nextLine().split(" ");
		int numCat = Integer.parseInt(parse[0]);
		int numDataSet = Integer.parseInt(parse[1]);
		
		
		HashMap<Integer, Point2D> catalog = new HashMap<Integer, Point2D>();
		
		for (int i = 0;i < numCat;i++) {
			String[] split = sc.nextLine().split(" ");
			int index = Integer.parseInt(split[0]);
			double rightAscen = Double.parseDouble(split[1]) * Math.PI / 180.0; //Radians
			double declin = Double.parseDouble(split[2]) * Math.PI / 180.0; //Radians
			catalog.put(index, new Point2D.Double(rightAscen, declin));
		}
		
		for (int i = 0;i < numDataSet;i++) {
			String[] split = sc.nextLine().split(" ");
			int probNum = Integer.parseInt(split[0]);
			int numStars = Integer.parseInt(split[1]);
			
			String[] setup1 = sc.nextLine().split(" ");
			String[] setup2 = sc.nextLine().split(" ");
			
			
			// Setup. Calibration.
			int star1time = Integer.parseInt(setup1[0]), star2time = Integer.parseInt(setup2[0]);
			int star1Index = Integer.parseInt(setup1[1]), star2Index = Integer.parseInt(setup2[1]);
			//All Radians.
			double star1azi = Double.parseDouble(setup1[2]) * Math.PI / 180.0, star2azi = Double.parseDouble(setup2[2]) * Math.PI / 180.0;
			double star1elev = Double.parseDouble(setup1[3]) * Math.PI / 180.0, star2elev = Double.parseDouble(setup2[3]) * Math.PI / 180.0;
			
			double[] coords1 = {Math.cos(star1azi)*Math.cos(star1elev),Math.sin(star1azi)*Math.cos(star1elev),Math.sin(star1elev)};
			double[] coords2 = {Math.cos(star2azi)*Math.cos(star2elev),Math.sin(star2azi)*Math.cos(star2elev),Math.sin(star2elev)};
			
			Point2D star1 = catalog.get(star1Index), star2 = catalog.get(star2Index);
			double star1ra = star1.getX(), star2ra = star2.getX();
			double star1dec = star2.getY(), star2dec = star2.getY();
			
			/*Need to get coordinates to match up!*/
			star1ra = star1ra - star1time*earthRot;
			star2ra = star2ra - star2time*earthRot;
			
			double[] rotFrame1 = {Math.cos(star1ra)*Math.cos(star1dec),Math.sin(star1ra)*Math.cos(star1dec),Math.sin(star1dec)};
			double[] rotFrame2 = {Math.cos(star2ra)*Math.cos(star2dec),Math.sin(star2ra)*Math.cos(star2dec),Math.sin(star2dec)};
			
			
			System.out.println(probNum + " " + numStars);
			
			double[] zero = {0,0,0};
			
			for (int j = 0;j < numStars;j++) {
				String[] star = sc.nextLine().split(" ");
				int subProblemNum = Integer.parseInt(star[0]);
				int starTime = Integer.parseInt(star[1]);
				int starIndex = Integer.parseInt(star[2]);
				
				Point2D starP = catalog.get(starIndex);
				double rightAscen = starP.getX();
				double declin = starP.getY();
				
				/* Conversion code here. */
				//Rotated coordinates:
				rightAscen = rightAscen-starTime*earthRot;
				double[] thisStar = {Math.cos(rightAscen)*Math.cos(declin),Math.sin(rightAscen)*Math.cos(declin),Math.sin(declin)};
				double sql1 = sqdist3D(thisStar,rotFrame1);
				double sql2 = sqdist3D(thisStar,rotFrame2);
				double RHS1 = 0.5*(1-sql1-sqdist3D(coords1,zero));
				double RHS2 = 0.5*(1-sql2-sqdist3D(coords2,zero));
				double[] sol1 = new double[3];
				double[] sol2 = new double[3];
				if(coords1[0]!=0){
					if(coords1[0]*coords2[2]-coords1[2]*coords2[0]!=0){
						//z = A+By
						double A = (coords1[0]*RHS2-coords2[0]*RHS1)/(coords1[0]*coords2[2]-coords1[2]*coords2[0]);
						double B = -(coords1[0]*coords2[1]-coords1[1]*coords2[0])/(coords1[0]*coords2[2]-coords1[2]*coords2[0]);
						//x = C+Dy
						double C = (RHS1-A*coords1[2])/coords1[0];
						double D = -(coords1[1]+B*coords1[2])/coords1[0];
						double[] coeffs = {B*B+D*D+1,2*A*B+2*C*D,A*A+C*C-1};
						double[] roots = quad(coeffs);
						sol1 = new double[] {C+D*roots[0],roots[0],A+B*roots[0]};
						sol2 = new double[] {C+D*roots[1],roots[1],A+B*roots[1]};
						//System.out.println(sqdist3D(sol2,zero)+"");
					}
					else{
						System.out.println("I'll fix this if not accepted");
					}
				}
				else{
					System.out.println("I'll fix this if not accepted...2");
				}
				double[] vTelPrime = diff(sol1,coords1);
				double[] vTel = diff(coords2,coords1);
				double[] vRot = diff(rotFrame2,rotFrame1);
				double[] vRotPrime = diff(thisStar,rotFrame1);
				double[] inRot = cross(vRot,vRotPrime);
				double isOutRot = dot(inRot,rotFrame1);
				double[] inTel = cross(vTel,vTelPrime);
				double isOutTel = dot(inTel,coords1);
				if(isOutTel*isOutRot>0){
					double phi = Math.asin(sol1[2]);
					double cosphi = Math.cos(phi);
					double theta = 0;
					//Assuming cosphi!=0
					if(phi<0){
						System.out.println(subProblemNum + " NOT VISIBLE");
					}
					else{
						double costh = sol1[0]/cosphi;
						double sinth = sol1[1]/cosphi;
						if(costh>=0&&sinth>=0){
							theta = Math.asin(sinth);
						}
						else if(costh<0&&sinth>=0){
							theta = Math.PI - Math.asin(sinth);
						}
						else if(costh>=0 && sinth<0){
							theta = Math.asin(sinth)+2*Math.PI;
						}
						else{
							theta = Math.PI - Math.asin(sinth);
						}
						phi *= 180/Math.PI;
						theta *= 180/Math.PI;
						System.out.println(subProblemNum + " " + df.format(theta)+" "+df.format(phi));
					}
					
				}
				else{
					double phi = Math.asin(sol2[2]);
					double cosphi = Math.cos(phi);
					double theta = 0;
					//Assuming cosphi!=0
					if(phi<0){
						System.out.println(subProblemNum + " NOT VISIBLE");
					}
					else{
						double costh = sol2[0]/cosphi;
						double sinth = sol2[1]/cosphi;
						if(costh>=0&&sinth>=0){
							theta = Math.asin(sinth);
						}
						else if(costh<0&&sinth>=0){
							theta = Math.PI - Math.asin(sinth);
						}
						else if(costh>=0 && sinth<0){
							theta = Math.asin(sinth)+2*Math.PI;
						}
						else{
							theta = Math.PI - Math.asin(sinth);
						}
						phi *= 180/Math.PI;
						theta *= 180/Math.PI;
						System.out.println(subProblemNum + " " + df.format(theta)+" "+df.format(phi));
					}
				}
				
				
				
				
				//OUTPUT NEEDS TO BE IN DEGREES
				//df.format(1.01323f); //Formats the decimals properly - "1.0"
			}
			
		}
	}

}
