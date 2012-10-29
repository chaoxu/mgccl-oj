import java.util.Arrays;
import java.util.Scanner;

public class Faulhaber {
	public static void main(String[] args) {
		Rational[][] f = new Rational[401][0];
		f[0] = new Rational[1];
		f[0][0] = new Rational(1,1);
		for (int r = 1;r < f.length;r++) {
			f[r] = new Rational[r + 1];
			Rational sum = new Rational(0, 1);
			for (int c = 1; c <= r; c++) {
				f[r][c] = (new Rational(r, c + 1)).mult(f[r - 1][c - 1]);
				sum = sum.add(f[r][c]);
			}
			f[r][0] = (new Rational(1,1)).sub(sum);
		}
		//for (int i = 0;i < 8;i++) {
		//	System.out.println(Arrays.toString(f[i]));
		//}
		Scanner sc = new Scanner(System.in);
		int dataSets = Integer.parseInt(sc.nextLine());
		for (int i = 0;i < dataSets;i++) {
			String[] split = sc.nextLine().split(" ");
			int caseNum = Integer.parseInt(split[0]);
			int rowNum = Integer.parseInt(split[1]);
			int colNum = Integer.parseInt(split[2]);
			System.out.println(caseNum + " " + f[rowNum][colNum - 1]);
		}
	}

	

	static class Rational {
		long a, b;
		Rational(long n, long d) {
			if (d == 0) {
				a = 0; d = 1;
			} else {
				long gcd = gcd(n, d);
				a = n/gcd; b = d/gcd;
			}
		}
		Rational add(Rational r) {
			return new Rational(a * r.b + b * r.a , b * r.b);
		}
		Rational sub(Rational r) {
			return new Rational(a * r.b - b * r.a , b * r.b);
		}
		Rational mult(Rational r) {
			return new Rational(a * r.a , b * r.b);
		}
		
		static long gcd(long a, long b) {
			if (b == 0) {
				return a;
			} else {
				return gcd(b, a % b);
			}
		}
		
		public String toString() {
			if (b == 1) {
				return Long.toString(a);
			}
			if (b < 0) {
				return -a + "/" + -b;
			} else {
				return a + "/" + b;
			}
		}
	}

	
}
