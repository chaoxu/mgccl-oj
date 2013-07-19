import java.util.*;
public class p4924 {
  static int m = 36;
  static Set<Long> s1;
  static Set<Long> s2;
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    HashMap<Character, Set<BitSet>> block = new HashMap<Character, Set<BitSet>>();
    
    BitSet A = new BitSet(m);
    A.flip(0);A.flip(1);A.flip(2);A.flip(3);
    BitSet B = new BitSet(m);
    B.flip(0);B.flip(1);B.flip(2);B.flip(6);
    BitSet C = new BitSet(m);
    C.flip(0);C.flip(1);C.flip(2);C.flip(7);
    BitSet D = new BitSet(m);
    D.flip(0);D.flip(1);D.flip(2);D.flip(8);
    BitSet E = new BitSet(m);
    E.flip(0);E.flip(1);E.flip(7);E.flip(8);
    BitSet F = new BitSet(m);
    F.flip(0);F.flip(1);F.flip(6);F.flip(7);
    BitSet G = new BitSet(m);  
    G.flip(1);G.flip(2);G.flip(6);G.flip(7);
    block.put('A', r(A));
    block.put('B', r(B));
    block.put('C', r(C));
    block.put('D', r(D));
    block.put('E', r(E));
    block.put('F', r(F));
    block.put('G', r(G));

    int z = in.nextInt();
    for(int y=0;y<z;y++){
        char[] a = in.next().toCharArray();
        ArrayList<Long> a1 = place(block.get(a[0]),block.get(a[1]),block.get(a[2]));
        a = in.next().toCharArray();
        ArrayList<Long> a2 = place(block.get(a[0]),block.get(a[1]),block.get(a[2]));
        
        int p1=0;
        int p2=0;
        BitSet b = null;
        while(p1<a1.size()&&p2<a2.size()){
            if(a1.get(p1)>a2.get(p2)){
                p1++;
            }else if(a1.get(p1)<a2.get(p2)){
                p2++;
            }else{
                b = new BitSet(36);
                for(int i=0;i<36;i++){
                    if((a1.get(p1) >> (36-i)) % 2==1){
                        b.flip(i);
                    }
                }
                break;
            }
        }
        System.out.println(y+1);
        if(b!=null){
            p(b);
        }else{
            System.out.println("No solution");
        }
    }
    
  }
  static Set<BitSet> r(BitSet A){
    Set<BitSet> s = new HashSet<BitSet>();
    s.add(A);
    s.add(Rotate(A));
    s.add(Rotate(Rotate(A)));
    s.add(Rotate(Rotate(Rotate(A))));
    return s;
  }
  static void p(BitSet x){
    p(toBoard(x));
  }
  static void p(char[][] x){
    for(char[] c:x){
      System.out.println(c);
    }
  }
  static char[][] toBoard(BitSet x){
    char[][] z = new char[6][6];
    for(int i=0;i<6;i++){
      for(int j=0;j<6;j++){
        if(x.get(6*i+j)){
          z[i][j]='#';
        }else{
          z[i][j]='.';
        }
      }
    }
    return z;
  }
  static BitSet fromBoard(char[][] z){
    BitSet x = new BitSet(36);
    for(int i=0;i<6;i++){
      for(int j=0;j<6;j++){
        if(z[i][j]=='#'){
          x.flip(6*i+j);
        }
      }
    }
    return x;
  }
  static ArrayList<Long> place(Set<BitSet> x, Set<BitSet> y, Set<BitSet> z){
      s1 = new HashSet<Long>();
      for(BitSet a:x){
          for(BitSet b:y){
              for(BitSet c:z){
                  place(a,b,c);
              }
          }
      }
      ArrayList<Long> v = new ArrayList<Long>(s1);
      Collections.sort(v,Collections.reverseOrder());
      return v;
  }
  static void place(BitSet x, BitSet y, BitSet z){
    for(int ix=0;ix<6;ix++){
    for(int jx=0;jx<6;jx++){
        BitSet xp = shift(x,ix,jx);
    if(xp.cardinality()==4){
    for(int iy=0;iy<6;iy++){
    for(int jy=0;jy<6;jy++){
        BitSet yp = shift(y,iy,jy);
        yp.or(xp);
    if(yp.cardinality()==8){
    for(int iz=0;iz<6;iz++){
    for(int jz=0;jz<6;jz++){
        BitSet zp = shift(z,iz,jz);
        zp.or(yp);
        if(zp.cardinality()==12){
            s1.add(toLong(zp));
        }
    }}}}}}}}
  }
  static void place(BitSet x, BitSet y, BitSet z, int ix, int jx, int iy, int jy, int iz, int jz){
    BitSet s = new BitSet(m);
    s.or(shift(x,ix,jx));
    s.or(shift(y,iy,jy));
    s.or(shift(z,iz,jz));
    if(s.cardinality()==12){
      s1.add(toLong(s));
    }
  }
  static long toLong(BitSet x){
      long h = 0;
      for (int i=0;i<36;i++){
          if(x.get(i)){
              h|= (((long) 1) << (36-i));
          }
      }
      return h;
  }
  static BitSet shift(BitSet x, int a, int b){
    char[][] c = toBoard(x);
    char[][] c2 = new char[6][6];
    for(int i=0;i<6;i++){
      for(int j=0;j<6;j++){
        if(i-a>=0&&j-b>=0){
          c2[i][j] = c[i-a][j-b];
        }else{
          c2[i][j] = '.';
        }
      }
    }
    return fromBoard(c2);
  }
  static BitSet Rotate(BitSet x){
    char[][] z = toBoard(x);
    char [][] z2 = new char[6][6];
    for(int i=0;i<6;i++){
      for(int j=0;j<6;j++){
        z2[5-j][i] = z[i][j];
      }
    }
    z=z2;
    // clipping
    boolean clip = true;
    while(clip){
      for(int i=0;i<6;i++){
        if(z[i][0]!='.'){
          clip=false;
          break;
        }
      }
      if(clip){
        shiftUp(z);
      }
    }
    clip = true;
    while(clip){
       for(int j=0;j<6;j++){
         if(z[0][j]!='.'){
           clip=false;
           break;
         }
       }
       if(clip){
       shiftRight(z);
       }
     }
    return fromBoard(z);
  }
  
   static void shiftUp(char[][] x){
     for(int i=0;i<6;i++){
       for(int j=0;j<5;j++){
         x[i][j] = x[i][j+1];
       }
     }
     for(int i=0;i<6;i++){
       x[i][5] = '.';
     }
   }
   
   static void shiftRight(char[][] x){
     for(int i=0;i<6;i++){
       for(int j=0;j<5;j++){
         x[j][i] = x[j+1][i];
       }
     }
     for(int i=0;i<6;i++){
       x[5][i] = '.';
     }
   }
}
