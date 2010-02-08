import java.util.*;
public class pc110204 {
	static String[] d;
	static Map<Character, Character> map;
	public static void main (String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		d = new String[n];
		for(int i=0;i<n;i++){
			d[i]= s.next();
		}
		Map<Character, Character> m = new HashMap<Character, Character>();
		map = null;
		stringsort st = new stringsort();
		Arrays.sort(d,st);
		
		s.nextLine();
		do{
			String str= s.nextLine();
			Scanner s2 = new Scanner(str);
			if(str.length()!=0){
				map = null;
				int c = 0;
				while(s2.hasNext()){
					s2.next();
					c++;
				}
				s2 = new Scanner(str);
				String[] text = new String[c];
				for(int i=0;i<c;i++){
					text[i] = s2.next();
				}
				Arrays.sort(text,st);
				generate_table(text, 0, m);
				
			}
			System.out.println(decode(str));
			
		}while(s.hasNextLine());
	}
	
	static boolean generate_table(String[] t, int j, Map<Character, Character> m){
		for(int i=0;i<d.length;i++){
			if(matches(d[i],t[j])){
				Map<Character, Character> mtemp = generate_map(d[i], t[j]);
				Map<Character, Character> m2 = update_table(m,mtemp);
				if(m2!=null){
					if(j!= t.length-1){
						if(generate_table(t,j+1,m2)==true){
							return true;
						}
					}else{
						map = m2;
						return true;
					}
				}
			}
		}
		return false;
	}
	static String decode(String s){
		char[] sc = s.toCharArray();
		if(map==null){
			for(int i=0;i<sc.length;i++){
				if(sc[i]>96 && sc[i]<123){
					sc[i] = '*';
				}
			}
		}else{
			for(int i=0;i<s.length();i++){
				if(map.containsKey(sc[i])){
					sc[i] = map.get(sc[i]);
				}
			}
		}
		return String.valueOf(sc);
	}
	static Map<Character, Character> update_table(Map<Character, Character> m2, Map<Character, Character> mtemp){
		Map<Character, Character> m = new HashMap<Character, Character>(m2);
		for(int i = 97; i<123;i++){
			char c= (char) i;
			if(m.containsKey(c)){
				if(mtemp.containsKey(c)){
					if(m.get(c).compareTo(mtemp.get(c))!=0){
						return null;
					}
				}
			}else{
				if(mtemp.containsKey(c)){
					m.put(c,mtemp.get(c));
				}
			}
		}
		
		for(int i = 97; i<123;i++){
			char c= (char) i;
			if(m.containsKey(c)){
				char d = m.get(c);
				for(int j = 97; j<123;j++){
					char e= (char) j;
					if(m.containsKey(e)&&e!=c){
						if(m.get(e).compareTo(d)==0){
							return null;
						}
					}
				}
			}
		}
		return m;
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

class stringsort implements Comparator<String>{

    public int compare(String o1, String o2) {
    	if(o1.length()>o2.length()){
    		return -1;
    	}
    	if(o1.length()<o2.length()){
    		return 1;
    	}
    	return o1.compareTo(o2);
    }
}