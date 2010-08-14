import java.util.*;
public class TheCoffeeTimeDivTwo{
	public static int find(int n, int[] t){
		Arrays.sort(t);
		int c=0;
		int[] d = new int[n-t.length];
		int k=0;
		for(int i=1;i<=n;i++){
			if(!in(t,i)){
				d[k] = i;
				k++;
			}
		}
		//trips
		int tea_trip = t.length/7;
		int coffee_trip = d.length/7;
		if(t.length%7!=0){
			tea_trip+=1;
		}
		if(d.length%7!=0){
			coffee_trip+=1;
		}
		int tm = (7-t.length%7)%7;
		int dm = (7-d.length%7)%7; 
		c+= 75*(tea_trip+coffee_trip)-(tm+dm)*4+rev(t)+rev(d);
		return c;
	}
	public static int orz (int[] t){
		int d=0,z;
		if(t.length%7==0){
			z = t.length/7;
		}else{
			z = t.length/7+1;
		}
		for(int i=0;i<z;i++){
			d+= t[7*i];
		}
		return d;
	}
	public static int rev (int[] t){
		int[] g = new int[t.length];
		for(int i=0;i<t.length;i++){
			g[i] = t[t.length-1-i];
		}
		return 2*orz(g);
	}
	public static boolean in(int[] t, int j){
		for(int i=0;i<t.length;i++){
			if(t[i]==j){
				return true;
			}
			if(t[i]>j){
				return false;
			}
		}
		return false;
	}
}

