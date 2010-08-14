import java.math.*;
public class MatrixShiftings{
	public static int minimumShifts(String[] matrix, int value){
		char[][] m = new char[matrix.length][matrix[0].length()];
		for(int i=0;i<matrix.length;i++){
			m[i] = matrix[i].toCharArray();
		}
		int min = 200;
		char v = String.valueOf(value).charAt(0);
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m[0].length;j++){
				if(v==m[i][j]){
					min = Math.min(dis(i, j, m.length, m[0].length),min);
				}
			}
		}
		if(min==200){
			min=-1;
		}
		return min;
	}
	public static int dis(int i, int j, int n, int m){
		//move to 0 0,
		int min = i+j;
		//move to n,0;
		min = Math.min(n-i + j,min);
		//move to n,m;
		min = Math.min(n-i + m-j, min);
		//move to 0,m
		min = Math.min(i + m-j,min);
		return min;
	}
}

