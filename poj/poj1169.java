import java.util.*;
public class poj1169 {
	static int min = 1000000;
	static ArrayList<int[]> a = new ArrayList<int[]>();
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int[][] r = new int[4][2];
		for(int i=0;i<4;i++){
			r[i][0] = in.nextInt();
			r[i][1] = in.nextInt();
		}
        f(r,0);
		System.out.println(min);
		Collections.sort(a,new sorttemplate());
		int p = -1;
		for(int i=1;i<a.size();i++){
			if(a.get(i)[0]!=p){
				p = a.get(i)[0];
				System.out.println(a.get(i)[0]+" "+a.get(i)[1]);
			}
		}
	}
	public static void f(int[][] r, int c){
		int[][] r2 = new int[4][2];
		for(int i=0;i<4;i++){
			r2[i][0] = r[i][0];
			r2[i][1] = r[i][1];
		}
		if(c==4){
			for(int i0=0;i0<2;i0++){
				r2[0] = r(r2[0]);
				for(int i1=0;i1<2;i1++){
					r2[1] = r(r2[1]);
					for(int i2=0;i2<2;i2++){
						r2[2] = r(r2[2]);
						g(r2);
						r2[3] = r(r2[3]);
						g(r2);
					}
				}
			}
		}
		for(int i=c;i<4;i++){
			for(int j=c;j<4;j++){
				r2[j][0] = r[j][0];
				r2[j][1] = r[j][1];
			}
			r2[c][0] = r[i][0];
			r2[c][1] = r[i][1];
			r2[i][0] = r[c][0];
			r2[i][1] = r[c][1];
			f(r2, c+1);
		}
		
	}
	public static int[] r(int[] a){
		int t = a[0];
		a[0] = a[1];
		a[1] = t;
		return a;
	}

	public static void g(int[][] r){
		int[] s = new int[2];
		//case 1
		s[0] = r[0][0]+r[1][0]+r[2][0]+r[3][0];
        s[1] = Math.max(Math.max(r[0][1],r[1][1]),Math.max(r[2][1],r[3][1]));
		h(s);
		//case 2
		s[0] = Math.max(r[0][0]+r[1][0]+r[2][0],r[3][0]);
		s[1]= r[3][1]+Math.max(Math.max(r[0][1],r[1][1]),r[2][1]);
		h(s);
		//case 3
		s[0] = Math.max(r[0][0]+r[1][0],r[3][0])+r[2][0];
		s[1] = Math.max(Math.max(r[0][1],r[1][1])+r[3][1],r[2][1]);
		h(s);
		//case 4,5
		s[0] = r[0][0]+Math.max(r[1][0],r[2][0])+r[3][0];
		s[1] = Math.max(Math.max(r[0][1],r[3][1]),r[1][1]+r[2][1]);
		h(s);
		//case 6
		s[0] = Math.max(r[2][0],r[3][0]);
		s[0] = Math.max(s[0],r[0][0]+r[1][0]);
		if(r[0][1]<r[1][1]){
			s[0] = Math.max(s[0],r[2][0]+r[1][0]);
		}
		if(r[0][1]+r[2][1]>r[1][1]){
			s[0] = Math.max(s[0],r[2][0]+r[3][0]);
		}
		if(r[1][1]<r[0][1]){
			s[0] = Math.max(s[0],r[0][0]+r[3][0]);
		}
		s[1] = Math.max(r[0][1]+r[2][1], r[1][1]+r[3][1]);
		h(s);
	}
	
	public static void h(int[] s){
		if(s[0]>s[1]){
			s=r(s);
		}
		if(s[0]*s[1]<min){
			min = s[0]*s[1];
			a.clear();
		}
		if(s[0]*s[1]==min){
			int[] p = new int[2];
			p[0] = s[0];
			p[1] = s[1];
			a.add(p);
		}
	}
}
class sorttemplate implements Comparator<int[]>{
    public int compare(int[] o1, int[] o2) {
    	if(o1[0]>o2[0]){
    		return 1;
    	}
    	if(o1[0]<o2[0]){
    		return -1;
    	}
    	return 0;
    }
}
