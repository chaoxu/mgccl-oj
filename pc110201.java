import java.util.*;
public class pc110201 {
	public static void main (String args[]){
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		Scanner t;
		int c,p,n,o;
		boolean b;
		int[] a;
		while(str.length()!=0){
			a = new int[3000];
			c = 0;
			t = new Scanner(str);
			p = t.nextInt();
			while(t.hasNextInt()){
				n = t.nextInt();
				o = Math.abs(n-p);
				if(o<3000 && o>0){
					a[o]=1;
				}
				p = n;
				c++;
			}
			b = true;
			for(int i=1;i<c;i++){
				if(a[i]!=1){
					b=false;
				}	
			}
			if(b){
				System.out.println("Jolly");
			}else{
				System.out.println("Not jolly");
			}
			str = s.nextLine();
		}
		
	}
}
