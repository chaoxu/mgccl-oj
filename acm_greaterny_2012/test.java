
public class test {
	static double[] cross(double[] a, double[] b){
		double[] x = new double[3];
		x[0]=a[1]*b[2]-a[2]*b[1];
		x[1]=a[2]*b[0]-a[0]*b[2];
		x[2]=a[0]*b[1]-a[1]*b[0];  
		return x;
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
	
	public static void main(String[] args){
		double[] x = {1,-2,1};
		System.out.println(quad(x)[0]);
		System.out.println(quad(x)[1]);
		double[] a = {0,0,1};
		double[] b = {1,0,0};
		System.out.println(cross(a,b)[0]);
		System.out.println(cross(a,b)[1]);
		System.out.println(cross(a,b)[2]);
	}
	
}
