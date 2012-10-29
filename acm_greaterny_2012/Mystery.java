import java.util.Scanner;


public class Mystery {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = Integer.parseInt(sc.nextLine());
		for (int i = 0;i < cases;i++) {
			int setNum = Integer.parseInt(sc.nextLine());
			String str = sc.nextLine();
			int numChar = Integer.parseInt(sc.nextLine());
			String[] split = sc.nextLine().split(" ");
			
			int cur = Integer.parseInt(split[0]);
			if (cur < 0) {
				cur = str.length() + cur;
			}
			if (cur >= str.length()) {
				cur %= str.length();
			}
			System.out.print(setNum + " " + str.charAt(cur));
			for (int j = 1;j < split.length;j++) {
				cur += Integer.parseInt(split[j]);
				while (cur < 0) {
					cur = str.length() + cur;
				}
				while (cur >= str.length()) {
					cur %= str.length();
				}
				System.out.print(str.charAt(cur));
			}
			System.out.println();
		}
	}
}
