import java.util.*;
public class uva10150 {
      public static Map<String,Set<String>> s;
      public static void main(String[] args){
              Scanner in = new Scanner(System.in);
              String str;
              String s1,s2;
              s = new HashMap<String,Set<String>>();
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
                    			  s.put(ns, new HashSet<String>());
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
                      if(s1.length()==s2.length()&&s.containsKey("0".concat(s1.substring(1)))&&s.get("0".concat(s1.substring(1))).contains(s1)){
                    		search(s1,s2);
                      }else{
                    	  System.out.println("No solution.");
                      }
                      k++;
              }
      }
      
      static void printr(ArrayList<String> s){
    	  for(int i=0;i<s.size();i++){
    		  System.out.println(s.get(i));
    	  }
      }
      public static void search(String s1, String s2){
    	  if(s1.compareTo(s2)==0){
    		  System.out.println(s1);
    		  return;
    	  }
    	  Set<String> visited = new HashSet<String>();
    	  Set<String> discovered = new HashSet<String>();
    	  Queue<ArrayList> next = new LinkedList<ArrayList>();
    	  ArrayList<String> t =new ArrayList<String>();
    	  String[] g;
    	  t.add(s1);
    	  
    	  next.add(t);
    	  discovered.add(t.get(t.size()-1));
    	  while(next.size()>0){
    		  t = next.poll();
       		  g = generate_diff(t.get(t.size()-1));
       		  visited.add(t.get(t.size()-1));
       		  for(int i=0;i<g.length;i++){
       			  if(s.containsKey(g[i])){
       				if(s.get(g[i]).contains(s2)){
       					t.add(s2);
       					printr(t);
       					return;
       				}else{
        				  String[] pos = new String[s.get(g[i]).size()];
        				  pos = s.get(g[i]).toArray(pos);
    					  for(int j =0;j<pos.length;j++){
        					  if(visited.contains(pos[j])==false){
        						  ArrayList<String> t2 = new ArrayList<String>(t);
        						  t2.add(pos[j]);
        						  if(!discovered.contains(pos[j])){
        							  next.add(t2);
        							  discovered.add(pos[j]);
        						  }
        					  }
        				  }
       				}
       			  }
       		  }
    	  }
    	  System.out.println("No solution.");
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
