import java.util.*;
public class quicksum {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			char[] c = in.nextLine().toCharArray();
			if(c[0]=='#'){
				break;
			}
			int sum = 0;
			for(int i=0;i<c.length;i++){
				char t = c[i];
				if(t!=' '){
					sum += (((int) t)-((int) 'A')+1)*(i+1);
				}
			}
			System.out.println(sum);
		}
	}
}
