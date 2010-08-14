public class TheAirTripDivTwo{
	public static int find(int[] f, int u){
		for(int i=0;i<f.length;i++){
			u-= f[i];
			if(u<0){
				return i;
			}
		}
		return f.length;
	}
}

