import java.util.*;
public class p4921 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String s = in.next();
    while(!s.equals("#")){
      int y=0,n=0,a=0;
      for(char c:s.toCharArray()){
        switch (c){
          case 'Y': y++; break;
          case 'N': n++; break;
          case 'A': a++; break;
        }
      }
      if(a*2>=s.length()){
        System.out.println("need quorum");
      }else if(n>y){
        System.out.println("no");
      }else if(y>n){
        System.out.println("yes");
      }else{
        System.out.println("tie");
      }
      s = in.next();  
    }
  }
}