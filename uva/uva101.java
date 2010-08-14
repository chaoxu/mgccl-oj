//The Blocks Problem
import java.util.*;
public class uva101 {
    public static void main(String args[]){
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	ArrayList[] m= new ArrayList[n];
    	for(int i=0;i<n;i++){
    		m[i] = new ArrayList<Integer>();
    		m[i].add(i);
    	}
    	while(true){
    		String s = in.next();
    		if(s.equals("quit")){
    			break;
    		}
    		int a = in.nextInt();
    		String s2 = in.next();
    		int b = in.nextInt();
    		ArrayList alist=new ArrayList(),blist=new ArrayList();
    		for(int i=0;i<n;i++){
    			if(m[i].contains(a)){
    				alist = m[i];
    			}
    			if(m[i].contains(b)){
    				blist = m[i];
    			}  			
    		}
    		if(alist==blist||a==b){
    			continue;
    		}
    		if(s.equals("move")){
    			while(true){
    				int t = (Integer) alist.remove(alist.size()-1);
    				if(t==a){
    					break;
    				}
    				m[t].add(t);
    			}
    			if(s2.equals("onto")){
    				while(true){
        				int t = (Integer) blist.remove(blist.size()-1);
        				if(t==b){
        					blist.add(b);
        					break;
        				}
        				m[t].add(t);
        			}
    			}
    			blist.add(a);
    		}
    		if(s.equals("pile")){
    			if(s2.equals("onto")){
    				while(true){
        				int t = (Integer) blist.remove(blist.size()-1);
        				if(t==b){
        					blist.add(b);
        					break;
        				}
        				m[t].add(t);
        			}
    			}
    			int i=alist.indexOf(a);
    			while(alist.size()>i){
    				blist.add(alist.remove(i));
    			}
    		}
    	}
    	for(int i=0;i<n;i++){
    		System.out.print(i);
    		System.out.print(":");
    		for(int j=0;j<m[i].size();j++){
    			System.out.print(" "+m[i].get(j));
    		}
    		System.out.println();
    	}
    }
}
