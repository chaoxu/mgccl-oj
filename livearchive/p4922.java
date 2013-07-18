import java.util.*;
public class p4922 {
public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    while(n!=0){
        int g = in.nextInt();
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> v = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> d1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> d2 = new HashMap<Integer, Integer>();
        for(int i=0;i<g;i++){
            int k = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int s = in.nextInt();
            int t = in.nextInt();
            for(int j=0;j<k;j++){
                int qx = x + j*s;
                int qy = y + j*t;
                inc(h,qx);
                inc(v,qy);
                inc(d1,qx-qy);
                inc(d2,-qx-qy);
            }
        }
        System.out.println(s(h)+s(v)+s(d1)+s(d2));
        n = in.nextInt();
    }
}
public static void inc(HashMap<Integer,Integer> h, int i){
    if(h.containsKey(i)){
        h.put(i, h.get(i)+1);
    }else{
        h.put(i, 1);
    }
}
public static int s(HashMap<Integer,Integer> h){
    int s = 0;
    for(int i:h.values()){
        s+=i-1;
    }
    return s;
}
}
