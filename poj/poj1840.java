import java.util.*;
public class poj1840 {
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		int[] a = new int[5];
		for(int i=0;i<5;i++){
			a[i] = in.nextInt();
		}
		int c=0;
		HashMap<Integer,Integer> h = new HashMap<Integer, Integer>();
		for(int i=-50;i<=50;i++){
			for(int j=-50;j<=50;j++){
				if(i==0||j==0){
					continue;
				}
				int t = a[0]*i*i*i+a[1]*j*j*j;
				if(h.containsKey(t)){
					h.put(t,h.get(t)+1);
				}else{
					h.put(t,1);
				}
			}
		}
	
		for(int i=-50;i<=50;i++){
			for(int j=-50;j<=50;j++){
			    for(int k=-50;k<=50;k++){
					if(i==0||j==0||k==0){
						continue;
					}
					int t = 0-(a[2]*i*i*i+a[3]*j*j*j+a[4]*k*k*k);
					if(h.containsKey(t)){
						c+=h.get(t);
					}
				}
			}
		}
		System.out.println(c);
	}
}
