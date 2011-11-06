
import java.util.*;
class rational{
	long n;
	long d;
	public rational(long a, long b){
		n=a;
		d=b;
		long g = (gcd(n,d));
		n/=g;
		d/=g;
	}
	public String toString(){
		return String.valueOf(n)+"/"+String.valueOf(d);
	}
	public rational and(rational b){
		long a = n*(b.d)+d*(b.n);
		long z = d*(b.d);
		return new rational(a,z);
	}
	public rational or(rational b){
		long a = n*b.n;
		long z = d*b.n + n*b.d;
		return new rational(a,z);
	}
	public long gcd(long a, long b){
		if(b==0) return a;
		return gcd(b, a%b);
	}
}
class Tree{
	ArrayList<Tree> edges;
	token t;
	int end;
	public Tree(){
		edges = new ArrayList<Tree>();
	}
	public Tree(token k){
		edges = new ArrayList<Tree>();
		t = k;
	}
	public boolean isLeaf(){
		if(edges.size()==0){
			return true;
		}
		return false;
	}
	
	public void add(Tree ta){
		edges.add(ta);
	}
	
	public String toString(){
		if(isLeaf()){
			return t.toString();
		}else{
			return edges.toString();
		}
	}
}
class token{
	char t;
	rational r;
	token(char a){
		t = a;
	}
	token(rational a){
		r = a;
	}
	public boolean isop(){
		if(r==null){
			return true;
		}
		return false;
	}
	public String toString(){
		String s = "";
		if(r==null){
			s = String.valueOf(t);
		}else{
			s = r.toString();
		}
		return s;
	}

}
public class p4566 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			Scanner in = new Scanner(sc.nextLine());
			ArrayList<token> t = new ArrayList<token>();
			while(in.hasNext()){
				String s = in.next();
				char[] c = s.toCharArray();
				if(c[0]=='&'||c[0]=='|'){
					t.add(new token(c[0]));
				}else{
					int i = 0;
					while(c[i]=='('){
						t.add(new token('('));
						i++;
					}
					
					ArrayList<token> t2 = new ArrayList<token>();
					int j =s.length()-1;
					while(c[j]==')'){
						t2.add(new token(')'));
						j--;
					}
					rational r = parse(s.substring(i,j+1));
					t.add(new token(r));
					t.addAll(t2);
				}
			}
			Tree z = tree(t,0);
			System.out.println(solve(z));		
		}
	}
	public static rational solve(Tree z){
		if(z.isLeaf()){
			return z.t.r;
		}
		rational r = solve(z.edges.get(0));
		for(int i=2;i<z.edges.size();i+=2){
			r = operate(z.edges.get(i-1).t.t,r,solve(z.edges.get(i)));
		}
		return r;
	}
	
	public static rational operate(char o, rational a, rational b){
		if(o=='&'){
			return a.and(b);
		}
		return a.or(b);
	}
	public static Tree tree(ArrayList<token> t, int i){
		Tree tr = new Tree();
		while(i<t.size()){
			if(t.get(i).isop()){
				if(t.get(i).t=='('){
					//build subtree
					Tree t2 = tree(t,i+1);
					tr.add(t2);
					i = t2.end;
				}else if(t.get(i).t==')'){
					tr.end = i;//no +1
					return tr;
				}else{
					tr.add(new Tree(t.get(i)));
				}
			}else{
				tr.add(new Tree(t.get(i)));
			}
			i++;
		}
		return tr;
	}
	public static rational parse(String s){
		int z = s.indexOf((int)'/'); 
		long a = Long.parseLong(s.substring(0,z));
		long b = Long.parseLong(s.substring(z+1));
		return new rational(a,b);
	}
}
