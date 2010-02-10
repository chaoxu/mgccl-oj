import java.util.*;
import java.io.*;

public class uva10150 {
      public static Map<String,ArrayList<String>> s;
      public static void main(String[] args) throws IOException{
              Scanner in = new Scanner(System.in);
              String str;
              String s1,s2;
              s = new HashMap<String,ArrayList<String>>();
              //construct list of words
              char[] c;
              while(in.hasNext()){
                      str = in.nextLine();
                      if(str.length()>0){
                    	  for(int i =0;i<str.length();i++){
                    		  c = str.toCharArray();
                    		  c[i] = '0';
                    		  String ns = String.valueOf(c);
                    		  if(!s.containsKey(ns)){
                    			  s.put(ns, new ArrayList<String>());
                    		  }
                    		  if(!s.get(ns).contains(str)){
                    			  s.get(ns).add(str);
                    		  }
                    	  }
                      }else{
                              break;
                      }
              }
              int k=0;
              while(in.hasNext()){
                      s1 = in.next();
                      s2 = in.next();
                      if(k!=0){
                          System.out.println();
                      }
                      boolean no = true;
                      if(s1.length()==s2.length()){
                    	  if(s.containsKey("0".concat(s1.substring(1)))){
                    		  if(s.get("0".concat(s1.substring(1))).contains(s1)){
                    			  no = search(s1,s2);
                    		  }
                    	  }
                      }
                      if(no){
                    	  System.out.println("No solution.");
                      }
                      k++;
              }
      }
      
      public static boolean search(String s1,String s2){
    	  Set<String> done = new HashSet<String>();
    	  String[] g;
    	  if(s1.compareTo(s2)==0){
    		  g = generate_diff(s1);
    		  for(int i =0;i<g.length;i++){
    			  if(s.containsKey(g[i])){
    				  for(int j=0;j<s.get(g[i]).size();j++){
    					  if(s.get(g[i]).get(j).compareTo(s1)!=0){
	        				  System.out.println(s1);
	        				  System.out.println(s.get(g[i]).get(j));
	        				  System.out.println(s1);
	        				  return false;
    					  }
    				  }
    			  }
    		  }
    	  }
    	  Queue<String[]> next = new LinkedList<String[]>();
    	  Stack<String[]> tested = new Stack<String[]>();
    	  String[] t = new String[2];
    	  t[0] = s1;
    	  String[] r = t.clone();
    	  next.add(t);
    	  boolean e = false;
    	  while(next.size()>0){
    		  t = next.poll();
			  tested.add(t);
			  done.add(t[0]);
    		  g = generate_diff(t[0]);
    		  for(int i =0;i<g.length;i++){
    			  if(s.containsKey(g[i])){
    				  String[] pos = new String[s.get(g[i]).size()];
    				  pos = s.get(g[i]).toArray(pos);
    				  for(int j =0;j<pos.length;j++){
    					  if(done.contains(pos[j])==false){
    						  String[] tmp = new String[2];
    	    				  tmp[0] = pos[j];
    	    				  tmp[1] = t[0];
    	    				  next.add(tmp);
    	    				  if(pos[j].compareTo(s2)==0){
    	    					  r = tmp;
    	    					  e = true;
    	    				  }
    					  }
    				  }
    			  }
    		  }
    	  }
    	  if(e==true){
    		  ArrayList<String> out = new ArrayList<String>();
    		  String k = r[1];
    		  out.add(r[0]);
    		  while(tested.size()>0){
    			  r = tested.pop();
    			  if(r[0].compareTo(k)==0){
    				  out.add(r[0]);
    				  k = r[1];
    			  }
    		  }
    		  for(int i=out.size()-1;i>-1;i--){
    			  System.out.println(out.get(i));
    		  }
    		  return false;
    	  }
    		  return true;
      }
      public static String[] generate_diff(String a){
    	  String[] r = new String[a.length()];
    	  for(int i =0;i<a.length();i++){
    		  char[] c = a.toCharArray();
    		  c[i] = '0';
    		  r[i] = String.valueOf(c);
    	  }
    	  return r;
      }
}