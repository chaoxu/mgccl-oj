import java.util.*;
public class B{
        public static void main(String[] args){
                Scanner in = new Scanner(System.in);
                int n = in.nextInt();
                for(int o=0;o<n;o++){
                        int z = in.nextInt();
                        int m = in.nextInt();
                        char[] t = in.next().toCharArray();
                        int a = toBase(t, m);
                        System.out.println(z+" "+a);
                }
        }
        public static int toBase(char[] c, int base){
                int b = 1;
                int m = base-1;
                int sum = 0;
                for(int i=c.length-1;i>-1;i--){
                        b=(b*base)%m;
                        sum+=(Integer.parseInt(String.valueOf(c[i]))*b%m)%m;
                }
                return sum%m;
        }
}