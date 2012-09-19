//  874 11520 12369
import java.util.*;
public class uva11661 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		while(n!=0){
			char[] c = in.nextLine().toCharArray();
			int m = n;
			char lastSeen = '.';
			int p = 0;
			for(int i=0;i<n;i++){
				if(c[i]=='R'){
					if(lastSeen=='D'){
						m=Math.min(m,i-p);
					}
					lastSeen='R';
					p = i;
				}
				if(c[i]=='D'){
					if(lastSeen=='R'){
						m=Math.min(m,i-p);
					}
					lastSeen='D';
					p = i;
				}
				if(c[i]=='Z'){
					m=0;
					break;
				}
			}
			
			System.out.println(m);
			n = Integer.parseInt(in.nextLine());
		}
	}
}
