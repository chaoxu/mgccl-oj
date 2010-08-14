import java.util.*;
import java.io.*;
public class poj2503 {
	public static void main (String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashMap<String,String> h = new HashMap<String,String>();
		while(true){
			String s = in.readLine();
			if(s.length()==0){
				break;
			}
			st = new StringTokenizer(s);
			String a = st.nextToken();
			String b = st.nextToken();
			h.put(b,a);
		}

		while(in.ready()){
			String s = in.readLine();
			if(h.containsKey(s)){
				s = h.get(s);
			}else{
				s = "eh";
			}
			System.out.println(s);
		}
	}
}
