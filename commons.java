
public class commons {
    static int[] extended_gcd(int a, int b, int s1, int t1, int s2, int t2){		
        if(a*s1+b*t1==1){
        	int[] m = {s1,t1};
        	return m;
        }
        int r = (s2*a+t2*b)/(s1*a+t1*b);
        s2 = (s2-r*s1);
        t2 = (t2-r*t1);
        return extended_gcd(a, b, s2, t2, s1, t1);
   }
   static int gcd(int a, int b){
        if(a%b==0)
     	   return b;
        return gcd(b, a%b);
   }
}
