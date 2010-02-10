import java.util.*;
import java.io.*;

public class uva10150 {
      public static Set<String> s;
      public static void main(String[] args) throws IOException{
              Scanner in = new Scanner(System.in);
              String str;
              String s1,s2;
              s = new HashSet<String>();
              //construct list of words
              while(in.hasNext()){
                      str = in.nextLine();
                      if(str.length()>0){
                              s.add(str);
                      }else{
                              break;
                      }
              }
              int k=0;
              while(in.hasNext()){
                  if(k!=0){
                          System.out.println();
                  }
                      s1 = in.next();
                      s2 = in.next();
                      if(s1.length()==s2.length()){
                    	  if(k<1){
                    		  search(s1,s2);
                    	  }
                      }else{
                          System.out.println("No solution.");
                      }
                      k++;
              }
      }
      
      
      public static void search(String s1,String s2){
    	  Set<String> done = new HashSet<String>();
    	  Queue<String[]> next = new LinkedList<String[]>();
    	  Stack<String[]> tested = new Stack<String[]>();
    	  String[] t = new String[2];
    	  t[0] = s1;
    	  String[] r = t.clone();
    	  next.add(t);
    	  String[] g;
    	  boolean e = false;
    	  while(next.size()>0){
    		  t = next.poll();
    		  done.add(t[0]);
			  tested.add(t);
    		  g = generate_diff(t[0]);
    		  for(int i =0;i<g.length;i++){
    			  if(g[i]==null){
    				  break;
    			  }
    			  if(s.contains(g[i])&&done.contains(g[i])==false ){
    				  String[] tmp = new String[2];
    				  tmp[0] = g[i];
    				  tmp[1] = t[0];
    				  next.add(tmp);
    				  if(g[i].compareTo(s2)==0){
    					  r = tmp;
    					  e = true;
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
    	  }else{
    		  System.out.println("No solution.");
    	  }
      }
      
      public static String[] generate_diff(String a){
    	  String[] r = new String[a.length()*26];
    	  char[] c = a.toCharArray();
    	  char[] c2 = c.clone();
    	  int count = 0;
    	  for(int i=0;i<a.length();i++){
    		  for(int j=97;j<123;j++){
    			  if(c2[i]!= (char) j){
	    			  c2[i] = (char) j;
	    			  r[count] = String.valueOf(c2);
	    			  c2 = c.clone();
	    			  count++;
    			  }
    		  }
    	  }
    	  return r;
      }
      public static boolean diff(String a, String b){
              int c =0;
              char[] ac = a.toCharArray();
              char[] bc = b.toCharArray();
              for(int i=0;i<a.length();i++){
                      if(ac[i]!=bc[i]){
                              c++;
                              if(c>1){
                                      return false;
                              }
                      }
              }
              return true;
      }
      
      public static boolean diff(char[] ac, char[] bc){
    	  if(ac.length!=bc.length){
    		  return false;
    	  }
    	  int c=0;
          for(int i=0;i<ac.length;i++){
              if(ac[i]!=bc[i]){
                      c++;
                      if(c>1){
                              return false;
                      }
              }
      }
          return true;
      }
}


