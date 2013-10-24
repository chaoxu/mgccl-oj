import java.util.*;
import java.io.*;

public class linear {

	static char[] m;
	
	public static void main(String[] args) throws Exception {
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("linear.in"));
		
		String line = in.nextLine();
		
		while (!line.equals("#")) {
			int n = line.length();
			
			m = new char[n+2];
			m[0] = '.';
			m[n+1] = '.';
			
			for (int i=1; i<=n; i++) {
				m[i] = line.charAt(i-1);
			}
			
			int sum = 0;
			for (int i=1; i<=n; i++) {
				sum += drop(i);
			}
			
			System.out.println(sum/n);
			
			line = in.nextLine();
		}

	}
	
	static int drop(int l) {
		char t = m[l];
		if (t == '.') return 100;
		else if (t == '_') return 0;
		else if (t == '/') return roll(l-1, -1);
		else if (t == '\\') return roll(l+1, 1);
		else return (roll(l-1, -1) + roll(l+1, 1))/2;
	}
	
	static int roll(int l, int d) {
		char t = m[l];
		if (t == '.') return 100;
		else if (t == '_') return roll(l+d, d);
		else return 0;
	}

}
