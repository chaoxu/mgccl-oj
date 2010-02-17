import java.util.*;
public class pc110707 {
       public static void main(String[] args){
               Scanner in = new Scanner(System.in);
               int n = in.nextInt();
               while(n!=0){
                       int c1 = in.nextInt();
                       int n1 = in.nextInt();
                       int c2 = in.nextInt();
                       int n2 = in.nextInt();
                       int no = n;
                       int d = gcd(n1,n2);
                       //Find which box is less cost effective
                       int ln,mn,t=0;
                       if((((double) n1)/((double) c1))>(((double) n2)/((double) c2))){
                    	   t = 1;
                    	   ln = n2;
                    	   mn = n1;
                       }else{
                    	   ln=n1;
                    	   mn = n2;
                       }
                       boolean failed = true;
                       int j=0;
                       if(n%d==0&&(n>=ln||n>=mn)){
                    	   while(n%mn!=0&&n-ln>=0){
                    		   n-= ln;
                    		   j++;
                    	   }
                    	   if(n%mn==0){
                    		   failed = false;
                    	   }
                       }
                       if(failed){
                    	   System.out.println("failed");
                       }else{
	   	                   if(t==0){
	   	                	   System.out.println(j+ " " + n/mn);
		                   }else{
		                	   System.out.println(n/mn + " "+ j);
		                   }
                       }
                       n = in.nextInt();
               }
       }
       static int gcd(int a, int b){
               if(a%b==0)
            	   return b;
               return gcd(b, a%b);
       }
}