import java.util.Scanner;

public class Hailstone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sets = Integer.parseInt(sc.nextLine());
		for (int c = 0;c < sets;c++) {
			String[] parse = sc.nextLine().split(" ");
			int setNumber = Integer.parseInt(parse[0]);
			int startVal = Integer.parseInt(parse[1]);
			long max = startVal;
			long sVal = startVal;
			while (sVal != 1) {
				long next = (sVal % 2 == 0 ? sVal / 2 : (3 * sVal) + 1);
				if (next > max) {
					max = next;
				}
				sVal = next;
			} 
			
			System.out.println(setNumber + " " + max);
		}
	}
}	


