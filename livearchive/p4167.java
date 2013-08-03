import java.util.*;
public class p4167 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    char[] c = in.nextLine().toCharArray();
    while(c[0]!='#'){
      int o=0;
      for(char v:c){
        switch(v){
          case '1':
            o++;
          case '0':
            System.out.print(v);
            break;
          case 'o':
            o++;
          case 'e':
            System.out.println(o%2);
            break;
        }
      }
      c = in.nextLine().toCharArray();
    }
  }
}