// TLE
public class RectangularIsland{
	public static double[][] d;
	public double theProbablity(int width, int height, int x, int y, int steps){
		d = new double[width][height];
		double[][] b = new double[width][height];
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				d[i][j]=0.25;
			}
		}
		for(int s=0;s<=steps;s++){
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
					b = new double[width][height];
					if(i!=0){				b[i][j]+=d[i-1][j];
					}
					if(i!=d.length-1){
						b[i][j]+=d[i+1][j]*0.25;
					}
					if(j!=0){
						b[i][j]+=d[i][j-1]*0.25;
					}
					if(j!=d[0].length-1){
						b[i][j]+=d[i][j+1]*0.25;
					}
			}
		}	
		d = b;
		}
		return b[x][y];
	}
}
