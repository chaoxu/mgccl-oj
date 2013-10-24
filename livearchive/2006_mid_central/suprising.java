import java.util.*;
public class suprising {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String s = in.nextLine();
			if(s.equals("*")){
				break;
			}
			int sum = 0;
			char[] c = s.toCharArray();
			boolean u = true;
			for(int i=1;i<c.length;i++){
				Set<String> h = new HashSet<String>();
				for(int j=0;j<c.length-i;j++){
					String t = String.valueOf(c[j])+String.valueOf(c[j+i]);
					//System.out.println(t+" "+i);
					if(h.contains(t)){
						u = false;
					}else{
						h.add(t);
					}
				}
			}
			if(u){
				System.out.println(s+" is surprising.");
			}else{
				System.out.println(s+" is NOT surprising.");
			}
		}	
	}
}
