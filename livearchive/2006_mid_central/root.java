import java.util.*;
import java.io.*;

public class root {

	public static void main(String[] args) throws Exception {
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("root.in"));
		
		int b = in.nextInt();
		int n = in.nextInt();
		
		while(!(b == 0&& n == 0)) {
			double la = Math.log10(b)/n;
			
			double a1 = Math.floor(Math.pow(10, la));
			double a2 = Math.ceil(Math.pow(10, la));
			
			double b1 = Math.pow(a1, n);
			double b2 = Math.pow(a2, n);
			
			long aa1 = Math.round(a1);
			long aa2 = Math.round(a2);

			if (Math.abs(b2-b) > Math.abs(b-b1)) System.out.println(aa1);
			else System.out.println(aa2);
			
			b = in.nextInt();
			n = in.nextInt();
		}

	}

}
