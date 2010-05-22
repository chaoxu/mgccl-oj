import java.util.Scanner;

public class pc110103 {
	 public static void main(String args[]){
	        Scanner s = new Scanner(System.in);
	        int n = s.nextInt();
	        String str;
	        while(n!=0){
	        	int sum= 0;
	        	int[] a = new int[n];
	        	for(int i=0;i<n;i++){
	        		str = s.next();
	        		a[i] = Integer.valueOf(str.substring(0,str.length()-3))*100+Integer.valueOf(str.substring(str.length()-2));
	        		sum+= a[i];
	        	}
	        	int average;
	        	int f1=0;
	        	int f2=0;
	        	average = sum/n;
        		for(int i=0;i<n;i++){
        			if(a[i]<average){
        				f1 += average-a[i];
        			}
        		}
	        	average = sum/n+1;
        		for(int i=0;i<n;i++){
        			if(a[i]>average){
        				f2 += a[i]-average;
        			}
        		}
        		f1 = Math.max(f1, f2);
        		
	        	if(f1%100==0){
	        		System.out.println("$"+f1/100+".00");
	        	}else{
	        		System.out.println("$"+f1/100+"."+f1%100);
	        	}
	        
	        	n = s.nextInt();
	        }
	   }
}

