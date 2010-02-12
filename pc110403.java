import java.util.*;
public class pc110403 {
	static int sum;
	static ArrayList<Integer[]> a;
	static ArrayList<Integer> l;
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		int[] m;
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			if(i!=0){
				System.out.println();
			}
			m = new int[in.nextInt()];
			for(int j=0;j<m.length;j++){
				m[j] = in.nextInt();
			}
			Arrays.sort(m);
			a = new ArrayList<Integer[]>();
			l = new ArrayList<Integer>();
			for(int j=0;j<m.length;j++){
				l.add(m[j]);
			}
			sum = 0;
			Integer[] t;
			
			while(l.size()>=4){
				if(l.get(l.size()-2)+l.get(0)>+2*l.get(1)){
					do_one();
				}else{
					do_two();
				}
			}
			switch(l.size()){
				case 3:
					sum+= l.get(0)+l.get(1)+l.get(2);
					t = new Integer[2];
					t[0] = l.get(0);
					t[1] = l.get(2);
					a.add(t);
					t = new Integer[1];
					t[0] = l.get(0);
					a.add(t);
					t = new Integer[2];
					t[0] = l.get(0);
					t[1] = l.get(1);
					a.add(t);
					break;
				case 2:
					t = new Integer[2];
					t[0] = l.get(0);
					t[1] = l.get(1);
					sum+= t[1];
					a.add(t);
					break;
				case 1:
					t = new Integer[1];
					t[0] = l.get(0);
					sum+= t[0];
					a.add(t);
					break;
			}
			System.out.println(sum);
			for(int j=0;j<a.size();j++){
				t = a.get(j);
				if(t.length<2){
					System.out.println(t[0]);
				}else{
					System.out.println(t[0]+" "+t[1]);
				}
			}
		}
	}
	
	static void do_one(){
		//AB + A + YZ + B
		sum+= l.get(l.size()-1)+2*l.get(1)+l.get(0);
		Integer[] t = new Integer[2];
		t[0] = l.get(0);
		t[1] = l.get(1);
		a.add(t);
		t = new Integer[1];
		t[0] =  l.get(0);
		a.add(t);
		t = new Integer[2];
		t[0] =  l.get(l.size()-2);
		t[1] =  l.get(l.size()-1);
		l.remove(l.size()-1);
		l.remove(l.size()-1);
		a.add(t);
		t = new Integer[1];
		t[0] = l.get(1);
		a.add(t);
	}
	static void do_two(){
		//AZ + A + AY + A
		sum+= l.get(l.size()-1)+l.get(l.size()-2)+2*l.get(0);
		Integer[] t = new Integer[2];
		t[0] = l.get(0);
		t[1] = l.get(l.size()-1);
		l.remove(l.size()-1);
		a.add(t);
		t = new Integer[1];
		t[0] =  l.get(0);
		a.add(t);
		t = new Integer[2];
		t[0] =  l.get(0);
		t[1] =  l.get(l.size()-1);
		l.remove(l.size()-1);
		a.add(t);
		t = new Integer[1];
		t[0] = l.get(0);
		a.add(t);
	}
}
