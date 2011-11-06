import java.util.*;
import java.text.*;
public class p4563 {
	public static String xml = new String();
	public static Stack<String> st = new Stack<String>();
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			xml = in.nextLine();
			if(p(xml.toCharArray())&&st.size()==0){
				System.out.println("valid");
			}else{
				System.out.println("invalid");
			}
		}
	}
	
	public static boolean p(char[] s){
		st = new Stack<String>();
		for(int i=0;i<s.length;i++){
			//System.out.println(st+ " " + i);
			//special
			if(s[i]=='&'){
				int z = amp(s,i);
				if(amp(s,i)!=-1){
					i=z;
					continue;
				}else{
					return false;
				}
			}
			if(s[i]=='<'){
				//System.out.println(i+" "+ s[i]);
				int z = tag(s,i);
				if(z!=-1){
					i=z;
					continue;
				}else{
					return false;
				}
			}
			if(s[i]=='>'){
				return false;
			}
			if(((int) s[i])>=32 && (((int) s[i])<=127)){
				//System.out.println(s[i]);
			}else{
				return false;
			}
		}
		
		return true;
	}
	
	public static int amp(char[] s, int i){
		if(i+3>=s.length){
			return -1;
		}
		
		if(s[i+1]=='l'&&s[i+2]=='t'&&s[i+3]==';'){
			return i+3;
		}
		if(s[i+1]=='g'&&s[i+2]=='t'&&s[i+3]==';'){
			return i+3;
		}
		
		if(i+4>=s.length){
			return -1;
		}
		if(s[i+1]=='a'&&s[i+2]=='m'&&s[i+3]=='p'&&s[i+4]==';'){
			return i+4;
		}
		//must be hex
		if(s[i+1]=='x'){
			int j=1;
			for(j=2;j+i<s.length;j++){
				if(s[i+j]==';'){
					if(j%2==0){
						return i+j;
					}
					return -1;
				}
				if(!hex(s[i+j])){
					return -1;
				}
			}
		}
		return -1;
	}
	
	public static int tag(char[] s, int i){
		//System.out.println("tag");
		i++;
		boolean close = false;
		if(s[i]=='/'){
			close = true;
			i++;
		}
		int begin = i;
		while(i<s.length&&(s[i]!='>'&&s[i]!='/')){
			if(!alpha(s[i])){
				//System.out.println(s[i]);
				return -1;
			}
			i++;
		}
		if(i>=s.length){
			return -1;
		}
		//we have the word
		String tag = xml.substring(begin,i);
		//System.out.println(tag);
		if(close==true && s[i]=='>'){
			if(st.empty()){
				return -1;
			}
			if(st.peek().equals(tag)){
				st.pop();
				return i;
			}else{
				return -1;
			}
		}

		if(s[i] == '>'){
			st.push(tag);
			return i;
		}
		if(i+1<s.length&&s[i+1] == '>'){
			return i+1;
		}
		return -1;
	}
	
	public static boolean hex(char a){
		char[] z = "1234567890abcdefABCDEF".toCharArray();
		for(int i=0;i<z.length;i++){
			if(a==z[i]){
				return true;
			}
		}
		return false;
	}
	
	public static boolean alpha(char a){
		char[] z = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		for(int i=0;i<z.length;i++){
			if(a==z[i]){
				return true;
			}
		}
		return false;
	}
}
