import java.util.*;
// also add the rational class
public class p4927 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    long a = in.nextLong();
    long b = in.nextLong();
    while(a!=0&&b!=0){
      ArrayList<Integer> ar = new ArrayList<Integer>();
      Rational r = new Rational(a,b);
      int i=1;
      while(r.num!=0){
        while(true){
          Rational v = new Rational(1,i);
          if(r.num*v.den>=r.den){
            Rational r2= r.sub(v);
            if(r2.den <=1000000){
              ar.add(i);
              r = r2;
              break;
            }
          }
          i++;
        }
      }
      p(ar);
      a = in.nextLong();
      b = in.nextLong();
    }
  }
  static void p(ArrayList<Integer> a){
    for(int i=0;i<a.size()-1;i++){
      System.out.print(a.get(i)+" ");
    }
    System.out.println(a.get(a.size()-1));
  }
}