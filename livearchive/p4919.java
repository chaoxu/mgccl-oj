import java.util.*;

public class p4919 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int z = in.nextInt();
    for(int y=0;y<z;y++){
        int sh = in.nextInt();
        int sm = in.nextInt();
        int dh = in.nextInt();
        int dm = in.nextInt();
        System.out.println("------+---------");
        System.out.println(" time | elapsed");
        System.out.println("------+---------");
        int d = (dh*60+dm+sm)/60;
        for(int i=0;i<=d;i++){
          System.out.print(o(sh+i)+":XX | XX");
          int t = i*60-(sm);
          if(t>0){
            System.out.println(" + "+t);
          } else if(t<0){
            System.out.println(" - "+(-t));
          }else{
            System.out.println();
          }
        }
    }
  }
  static String o(int a){
    if(a%12==0){
      a=12;
    }else{
      a%=12;
    }
    if(String.valueOf(a).length()==1){
      return " "+String.valueOf(a);
    }else{
      return String.valueOf(a);
    }
  }
}