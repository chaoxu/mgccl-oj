import java.util.*;

class State{
  Set<Integer> s;
  int[] pos;
  int d;
  State(Set<Integer> a,int[] b,int c){
    s=a;
    pos=b;
    d=c;
    Arrays.sort(pos);
  }
  public int hashCode() {
    return s.hashCode();
  }
  public boolean equals(Object aThat) {
    State b = (State) aThat;
    for(int i=0;i<pos.length;i++){
      if(pos[i]!=b.pos[i]){
        return false;
      }
    }
    return b.s.equals(s);
  }
  public String toString(){
    return s.toString()+" "+t()+" "+d;
  }
  public String t(){
    String s = "";
    for(int i:pos){
      s+=i+" ";
    }
    return s;
  }
}
public class p4925 {
  static int n;
  static int s;
  static Queue<State> q;
  static boolean[][] v;
  static ArrayList<Integer>[] e;
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    s = in.nextInt();
    while(s!=0){
      n=in.nextInt();
      int p=in.nextInt();      
      e = new ArrayList[s];
      for(int i=0;i<s;i++){
        e[i] = new ArrayList<Integer>(); 
      }
      for(int i=0;i<p;i++){
        char[] c = in.next().toCharArray();
        int x = ((int) c[0])-65;
        int y = ((int) c[1])-65;
        e[x].add(y);
        e[y].add(x);
      }
      q = new LinkedList<State>();
      v = new boolean[(int) Math.pow(2,s)][(int) Math.pow(s,n)];
      //bfs
      int[] pos = new int[n];
      Set<Integer> ns = new HashSet<Integer>();
      ns.add(0);
      bfs(new State(ns,pos,0), s);
      s = in.nextInt();
    }
    
  }
  static void bfs(State s, int m){
    q.offer(s);
    visit(s);
    while(true){
      s = q.poll();
      if(s==null){
        System.exit(0);
      }
      ArrayList<int[]> o = moves(s.pos);
      
      // compute set of moves
      for(int[] t:o){
        Set<Integer> s2 = new HashSet<Integer>(s.s);
        for(int i:t){
          s2.add(i);
        }
        State sp = new State(s2, t, s.d+1);
        if(!visited(sp)){          
          if(sp.s.size()==m){
            System.out.println(sp.d);
            return;
          }
          q.offer(sp);
          visit(sp);
          }
        }
      }
    }
  
  static boolean visited(State S){
    int j=0;
    for(int i: S.pos){
      j*=s;
      j+=i;
    }
    int i=0;
    for(int p:S.s){
      i |= (1<<p);
    }
    return v[i][j];
  }
  static void visit(State S){
    int j=0;
    for(int i: S.pos){
      j*=s;
      j+=i;
    }
    int i=0;
    for(int p:S.s){
      i |= (1<<p);
    }
    v[i][j] = true;
  }
  static ArrayList<int[]> moves(int[] p){
    ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
    for(int i:p){
      ArrayList<Integer> a = new ArrayList<Integer>();
      for(int v:e[i]){
        a.add(v);
      }
      b.add(a);
    }
    return cartesian_product(b,p,0);
  }
    static ArrayList<int[]> cartesian_product(ArrayList<ArrayList<Integer>> a, int[] p, int t){
      int[] d = p.clone();
      ArrayList<int[]> b = new ArrayList<int[]>();
      if(t==a.size()){
        b.add(d);
        return b;
      }
      for(int i : a.get(t)){
        d[t] = i;
        b.addAll(cartesian_product(a,d,t+1));
      }
      return b;
    }
}