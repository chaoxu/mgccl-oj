import java.util.*;
public class uva673 {
	public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
		int nz = in.nextInt();
		in.nextLine();
		for(int z=0;z<nz;z++){
			Stack<Character> s = new Stack<Character>();
			String out = "Yes";
			s.push('0');
			char[] c = in.nextLine().toCharArray();
			for(int i=0;i<c.length;i++){
				if(c[i]=='('||c[i]=='['){
					s.push(c[i]);
				}else if((c[i]==']' && s.peek()=='[') 
						|| (c[i]==')' && s.peek()=='(')){
					s.pop();
				}else{
					out = "No";
					break;
				}
			}
			if(s.size()>1){
				out = "No";
			}
			System.out.println(out);
		}
	}
}
