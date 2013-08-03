import java.util.*;
class Interval{
  int begin;
  int end;
  String value;
  Interval(int a, int b, String c){
    begin = a;
    end = b;
    value = c;
  }
  public String toString(){
    if(begin>=end){
      return "EMPTY";
    }
    return String.valueOf(begin)+" "+String.valueOf(Math.max(end-1,begin))+value;
  }
}
public class p4172 {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();

    while(!s.equals("END")){
      System.out.println(s);
      int b = in.nextInt();
      ArrayList<Interval> col = new ArrayList<Interval>();
      while(b!=0){
        Interval next = new Interval(b,in.nextInt()+1,in.nextLine());
        insert(next,col);
        reduce(col);
        b = in.nextInt();
      }
      in.nextLine();
      for(Interval i:col){
        System.out.println(i);
      }
      s = in.nextLine();
    }
  }
  public static void reduce(ArrayList<Interval> a){
    // remove empty
    for(int i=0;i<a.size();i++){
      if(a.get(i).begin>=a.get(i).end){
        a.remove(i);
        i--;
      }
    }
    // combine
    for(int i=0;i<a.size()-1;i++){
      if(a.get(i).end==a.get(i+1).begin && 
          a.get(i).value.equals(a.get(i+1).value)){
        a.get(i+1).begin = a.get(i).begin;
        a.remove(i);
        i--;
      }
    }
  }
  public static void insert(Interval t, ArrayList<Interval> a){
    // maintain the invariant that it is always a disjoint set of intervals.
    for(int i=0;i<a.size();i++){
      Interval s = a.get(i);
      if(t.end<=s.begin){ 
        a.add(i,t);
        return;
      }
      if(t.begin>=s.end){
        continue;
      }
      if(t.begin>=s.begin && t.end <= s.end){
        Interval u = new Interval(t.end, s.end, s.value);
        s.end = t.begin;
        a.add(i+1,t);
        a.add(i+2,u);
        return;
      }
      if(t.begin <= s.begin && t.end<=s.end){
          s.begin = t.end;
          a.add(i,t);
          return;
      }
      if(t.begin <= s.begin && t.end>=s.end){
        a.remove(i);
        i--;
        continue;
      }
      if(t.begin >= s.begin && t.end>=s.end){
        Interval a1 = new Interval(t.begin, s.end, t.value);
        int m = t.begin;
        t = new Interval(s.end, t.end, t.value);
        s.end = m;
        a.add(i+1,a1);
        continue;
      }
    }
    a.add(t);
  }
}