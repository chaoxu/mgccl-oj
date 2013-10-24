import java.util.*;
public class frugal {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			String s = in.nextLine();
			
			while(true){
				ArrayList<String> a = new ArrayList<String>();
				if(s.equals("#")){
					break;
				}
				while(true){
					if(s.equals("#")||s.equals("*")){
						break;
					}
					a.add(s);
					s = in.nextLine();
				}
				s = in.nextLine();
				Collections.sort(a);
				while(true){
					if(s.equals("**")){
						break;
					}
					// break to terms
					int n = a.size();
					String[] terms = s.split("\\|");
					ArrayList<String> b = new ArrayList<String>();
					for(String t : terms){
						for(int i=0;i<n;i++){
							if(match(t, a.get(i))){
								b.add(a.get(i));
							}
						}
					}
					Collections.sort(b);
					if(b.size()==0){
						System.out.println("NONE");
					}else{
						System.out.println(b.get(0));
					}
					s = in.nextLine();
				}
				s = in.nextLine();
				System.out.println("$");
			}
		}
	}
	public static boolean match(String t, String s){
		char[] c = s.toCharArray();
		// parse string t
		HashSet<Character> pos = new HashSet<Character>();
		HashSet<Character> neg = new HashSet<Character>();
		HashSet<Character> other = new HashSet<Character>();
		HashSet<Character> all = new HashSet<Character>();
		for(int i=0;i<t.length();i++){
			char z = t.charAt(i);
			if(z=='+'){
				pos.add(t.charAt(i+1));
				i++;
			}else if(z=='-'){
				neg.add(t.charAt(i+1));
				i++;
			}else {
				other.add(t.charAt(i));
			}
		}
		
		for(char z: c){
			all.add(z);
		}
		boolean mp = all.containsAll(pos);
		for(char z: neg){
			if(all.contains(z)){
				return false;
			}
		}
		for(char z: other){
			if(all.contains(z)){
				return mp;
			}
		}
		return false;
	}
}
