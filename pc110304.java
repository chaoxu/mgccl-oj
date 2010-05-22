import java.util.*;
public class pc110304 {
	static Map<Character, Character> m;
	public static void main (String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		s.nextLine();
		m = new HashMap<Character,Character>();
		m.put(' ',' ');
		String q = "the quick brown fox jumps over the lazy dog";
		for(int i=0;i<n;i++){
			if(i!=0){
				System.out.println();
			}
			ArrayList<String> as = new ArrayList<String>();
			String str= s.nextLine();
			while(s.hasNextLine()){
				as.add(str);
				str = s.nextLine();
				if(str.length()==0){
					break;
				}
			}
			boolean sol = false;
			for(int j=0;j<as.size();j++){
				if(matches(q,as.get(j))){
					char[] dc =as.get(j).toCharArray();
					char[] sc =q.toCharArray();
					for(int k=0;k<dc.length;k++){
						m.put(sc[i], dc[i]);
						sol = true;
					}
				}
			}
			if(sol){
				for(int j=0;j<as.size();j++){
					if(matches(q,as.get(j))){
						char[] dc =as.get(j).toCharArray();
						char[] sc =q.toCharArray();
						for(int k=0;k<dc.length;k++){
							m.put(dc[k], sc[k]);
						}
					}
				}
				for(int j=0;j<as.size();j++){
					System.out.println(decode(as.get(j)));
				}
			}else{
				System.out.println("No solution.");
			}
		}
	}
	
	static String decode(String s){
		char[] sc = s.toCharArray();
		for(int i=0;i<s.length();i++){
			if(m.containsKey(sc[i])){
				sc[i] = m.get(sc[i]);
			}
		}
		return String.valueOf(sc);
	}
	
	static Map<Character, Character> generate_map(String d, String s){
		Map<Character, Character> m = new HashMap<Character, Character>();
		char[] dc =d.toCharArray();
		char[] sc =s.toCharArray();
		for(int i=0;i<dc.length;i++){
			m.put(sc[i], dc[i]);
		}
		return m;
	}
	
	static boolean matches(String a, String b){
		if(a.length()==b.length()){
			if(orz(a).compareTo(orz(b))==0){
				return true;
			}
		}
		return false;
	}
	
	static String orz(String a){
		char[] ac = a.toCharArray();
		char t='0';
		int c=0;
		for(int i=0;i<a.length();i++){
			if(ac[i]>96 && ac[i]<123){
				t = ac[i];
				c++;
			}
			for(int j=0;j<a.length();j++){
				if(ac[j]==t){
					ac[j] = (char) (64+c);
				}
			}
		}
		return String.valueOf(ac);
	}
}
