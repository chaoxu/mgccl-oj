import java.util.*;
public class p4923 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String s = new StringBuffer(in.nextLine()).reverse().toString();
    while(!s.equals("#")){
      boolean succ = true;
      char[] v = new char[s.length()];
      for(int i=0;i<s.length();i++){
        char c = s.charAt(i);
        switch (c){
          case 'b': v[i]='d'; break;
          case 'd': v[i]='b'; break;
          case 'p': v[i]='q'; break;
          case 'q': v[i]='p'; break;
          case 'i':
          case 'o':
          case 'v':
          case 'w':
          case 'x':
            v[i]=c;
            break;
          default:
            succ = false;
        }
      }
      if(succ){
        System.out.println(v);
      }else{
        System.out.println("INVALID");
      }
      s = new StringBuffer(in.nextLine()).reverse().toString();
    }
  }
}