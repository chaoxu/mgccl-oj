import java.util.*;
public class pc110106 {
	public static int[] m;
	 public static int[] r;
	 public static int count;
	 public static int p;
	 public static void main(String args[]){
	        
		 	Scanner s = new Scanner(System.in);
	        int n = s.nextInt();
	        String str;
	        s.nextLine();
	        s.nextLine();
	        for(int z=0;z<n;z++){
	        	m = new int[1000];
	        	r = new int[10];
	        	count = 0;
	        	str = s.nextLine();
	        	int i=0;
	        	while(str.length()!=0&&s.hasNext()){
	        		m[i] = Integer.valueOf(str);
	        		str = s.nextLine();
	        		i++;
	        	}
	        	p=0;
	        	count = 1;
	        	while(eval(m[p]/100, (m[p]%100)/10, m[p]%10)){
	        		count++;
	        	}
	        	System.out.println(count);
	        	if(z!=n-1){
	        		System.out.println("");
	        	}
	        }
	 }
	 
	 static boolean eval(int a, int b, int c){
		 p++;
		 if(a==1){
			 return false;
		 }
		 if(a==2){
			 r[b] = c;
		 }
		 if(a==3){
			r[b] += c; 
		 }
		 if(a==4){
			 r[b]*= c;
		 }
		 if(a==5){
			r[b] = r[c]; 
		 }
		 if(a==6){
			 r[b] += r[c];
		 }
		 if(a==7){
			 r[b] *= r[c];
		 }
		 if(a==8){
			 r[b] = m[r[c]];
		 }
		 if(a==9){
			 m[r[c]] = r[b];
		 }
		 if(a==0&& r[c]!=0){
			 p= r[b];
		 }
		 r[b] = r[b]%1000;
		 m[r[c]] = m[r[c]]%1000;
		 return true;
	 }
}

