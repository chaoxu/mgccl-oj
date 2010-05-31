/*
  ID: mgcclx1
  LANG: JAVA
  TASK: pprime
 */
import java.util.*;
import java.io.*;
public class usaco_pprime { 
	static BufferedWriter out;
    public static void main(String args[]) throws IOException{
		Scanner in = new Scanner(new File("pprime.in"));
	    FileWriter fstream = new FileWriter("pprime.out");
		out = new BufferedWriter(fstream);
		int a = in.nextInt();
		int b = in.nextInt();
		//Generate a table of them ALL.
		ArrayList<Integer> s = new ArrayList<Integer>();
		s.add(2);
		s.add(3);
		s.add(5);
		s.add(7);
		s.add(11);
		int t=0;
		for(int d1 = 0;d1 <10;d1++){
			t = 100+d1*10+1;
			if(is_prime(t)){    s.add(t);}
			t = 300+d1*10+3;
			if(is_prime(t)){    s.add(t);}
			t = 700+d1*10+7;
			if(is_prime(t)){    s.add(t);}
			t = 900+d1*10+9;
			if(is_prime(t)){    s.add(t);}
			t = 1000+d1*100+d1*10+1;
			if(is_prime(t)){    s.add(t);}
			t = 3000+d1*100+d1*10+3;
			if(is_prime(t)){    s.add(t);}
			t = 7000+d1*100+d1*10+7;
			if(is_prime(t)){    s.add(t);}
			t = 9000+d1*100+d1*10+9;
			if(is_prime(t)){    s.add(t);}
			for(int d2 = 0; d2<10; d2++){
				t = 10000 + d1*1000+d2*100+d1*10+1;
				if(is_prime(t)){    s.add(t);}
				t = 30000 + d1*1000+d2*100+d1*10+3;
				if(is_prime(t)){    s.add(t);}
				t = 70000 + d1*1000+d2*100+d1*10+7;
				if(is_prime(t)){    s.add(t);}
				t = 90000 + d1*1000+d2*100+d1*10+9;
				if(is_prime(t)){    s.add(t);}
				t = 100000 + d1*10000+d2*1000+d2*100+d1*10+1;
				if(is_prime(t)){    s.add(t);}
				t = 300000 + d1*10000+d2*1000+d2*100+d1*10+3;
				if(is_prime(t)){    s.add(t);}
				t = 700000 + d1*10000+d2*1000+d2*100+d1*10+7;
				if(is_prime(t)){    s.add(t);}
				t = 900000 + d1*10000+d2*1000+d2*100+d1*10+9;
				if(is_prime(t)){    s.add(t);}

				for(int d3 = 0; d3<10; d3++){
					t = 10000000 + d1*1000000 + d2*100000 + d3*10000 + d3*1000 + d2*100 + d1*10 + 1;
					if(is_prime(t)){	s.add(t);}
					t = 30000000 + d1*1000000 + d2*100000 + d3*10000 + d3*1000 + d2*100 + d1*10 + 3;
					if(is_prime(t)){	s.add(t);}
					t = 70000000 + d1*1000000 + d2*100000 + d3*10000 + d3*1000 + d2*100 + d1*10 + 7;
					if(is_prime(t)){	s.add(t);}
					t = 90000000 + d1*1000000 + d2*100000 + d3*10000 + d3*1000 + d2*100 + d1*10 + 9;
					if(is_prime(t)){	s.add(t);}
					t = 1000000 + d1*100000 + d2*10000 + d3*1000 + d2*100 + d1*10 + 1;
					if(is_prime(t)){	s.add(t);}
					t = 3000000 + d1*100000 + d2*10000 + d3*1000 + d2*100 + d1*10 + 3;
					if(is_prime(t)){	s.add(t);}
					t = 7000000 + d1*100000 + d2*10000 + d3*1000 + d2*100 + d1*10 + 7;
					if(is_prime(t)){	s.add(t);}
					t = 9000000 + d1*100000 + d2*10000 + d3*1000 + d2*100 + d1*10 + 9;
					if(is_prime(t)){	s.add(t);}
				}
			}
		}
		Integer[] l = new Integer[s.size()];
		s.toArray(l);
		Arrays.sort(l);
		int j=Arrays.binarySearch(l,a);
		if(j<0){
			j = -j-1;
		}
		int k=Arrays.binarySearch(l,b);
		if(k<0){
			k = -k-2;
		}
		for(int i=j;i<=k;i++){
			out.write(String.valueOf(l[i])+"\n");
		}
		out.close();
	}
	public static boolean is_prime(int d){
		int s = (int) Math.sqrt(d);
		for(int i=2;i<=s;i++){
			if(d%i==0){
				return false;
			}
		}
		return true;
	}
}
