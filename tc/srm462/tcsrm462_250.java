public class Archery {
	public static double expectedPoints(int N, int[] ringPoints){
		int sum = 0;
		N+=1;
		for(int r=1;r<=N;r++){
			sum += (r*r - (r-1)*(r-1))*ringPoints[r-1];
		}
		return ((double) sum/(double)(N*N));
	}
}

	

