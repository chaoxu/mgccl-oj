import java.util.*;
public class p4920 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    while(n!=0){
      ArrayList<Integer> a = new ArrayList<Integer>();
      int s = 0;
      for(int i=1;i<=n;i++){
        int c = in.nextInt();
        for(int j=0;j<c-s;j++){
          a.add(i);
        }
        s=c;
      }
      for(int i=0;i<a.size()-1;i++){
        System.out.print(a.get(i)+" ");
      }
      System.out.println(a.get(a.size()-1));
      n = in.nextInt();
    }
  }
}