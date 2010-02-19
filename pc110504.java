import java.util.*;
public class pc110504 {
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int r=1,i=1;
			while((r%=n)!=0){
				r=r*10+1;
				i++;
			}
			System.out.println(i);
		}
	}
}
