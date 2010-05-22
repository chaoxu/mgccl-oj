import java.util.*;
public class pc110208 {
	static int[][] t;
	static int[] p;
	static int[] r;
	static int[][] s;
	static int c=0;
	static int[][] a;
	static int[] maxr;
	static int max;
	public static void main (String args[]){
		a = new int[1716][6];
		Scanner in = new Scanner(System.in);
		int[] array = new int[6];
		pick(13,6,array);
		while(in.hasNextInt()){
			max = 0;
			t = new int[13][6];
			s = new int[13][6];
			for(int i=0;i<13;i++){
				int ts=0;
				for(int j=0;j<5;j++){
					t[i][j] = in.nextInt();
					ts += t[i][j];
				}
				t[i][5] = ts;
				Arrays.sort(t[i]);
			}
			
			intsort intso = new intsort();
			Arrays.sort(t,intso);
			for(int i=0;i<13;i++){
				for(int j=0;j<6;j++){
					s[i][j] = sum_all_k(t[i],j+1);
				}
			}
			for(int i=0;i<1716;i++){
				p = new int[13];
				r = new int[13];
				for(int j=0;j<6;j++){
					p[a[i][j]]=1;
				}
				int maxt = 0;
				for(int j=0;j<6;j++){
					maxt+=t[a[i][j]][5];
				}
				if(maxt>63){
					maxt+=35;
				}
				
				int d2 = do_two();
				if(d2+maxt>max){
					int d1 = do_one(a[i]);
					int o = d1+d2;
					if(o>max){
						maxr = r.clone();
						max = o;
					}
				}
				
			}
			for(int i=0;i<13;i++){
				System.out.print(maxr[i]+" ");
			}
			int q = maxr[0]+maxr[1]+maxr[2]+maxr[3]+maxr[4]+maxr[5];
			if(q>=63){
				System.out.print(35+" ");
			}else{
				System.out.print(0+" ");
			}
			System.out.println(max);
		}
	}
	
	static int do_one(int[] a){
		int[] seq = {0,1,2,3,4,5};
		int[] ar = new int[6];
		int[] maxr = new int[6];
		int m = 0;
		int sum=0;
		for(int i=0;i<720;i++){
			int[] perm = perm(seq,i);
			sum = 0;
			for(int j=0;j<6;j++){
				ar[j]= s[a[perm[j]]][j];
				sum += ar[j];
			}
			if(sum>m){
				m = sum;
				maxr = ar.clone();
			}
		}
		if(m>=63){
			m += 35;
		}
		for(int i=0;i<6;i++){
			r[i] = maxr[i];
		}
		return m;
	}
	
	static int sum_all_k(int[] t, int k){
		int sum=0;
		for(int i=0;i<5;i++){
			if(t[i]==k){
				sum+=k;
			}
		}
		return sum;
	}
	static int[] perm(int[] s2,int k){
		int[] s = s2.clone();
		for(int i = 2; i<=s.length;i++){
			int tmp;
			tmp = s[(k%i)];
			s[(k%i)] = s[i-1];
			s[i-1] = tmp;
			k = k/i;
		}
		return s;
	}
	static int do_two(){
		int sum=0;
		for(int i=12;i>=0;i--){
			if(p[i]==0){
				if(five_of_a_kind(t[i])&&r[9]==0){
					p[i] = 1;
					r[9] = 50;
					sum+=50;
				}else if(full_house(t[i])&&r[12]==0){
					p[i] = 1;
					r[12] = 40;
					sum+= 40;
				}else if(long_straight(t[i])&&r[11]==0){
					p[i] = 1;
					r[11] = 35;
					sum+=35;
				}else if(short_straight(t[i])&&r[10]==0){
					p[i] = 1;
					r[10] = 25;
					sum+=25;
				}
			}
		}
		for(int i=0;i<13;i++){
			if(p[i]==0){
				if(four_of_a_kind(t[i])&&r[8]==0){
					p[i] = 1;
					r[8]=t[i][5];
					sum+= t[i][5];
				}else if(three_of_a_kind(t[i])&&r[7]==0){
					p[i] = 1;
					r[7]=t[i][5];
					sum+=t[i][5];
				}else if(r[6]==0){
					p[i]=1;
					r[6] = t[i][5];
					sum+=t[i][5];
				}
			}
		}
		return sum;
	}
	static boolean five_of_a_kind(int[] d){
		int count=0;
		for(int i=1;i<5;i++){
			if(d[i]==d[0]){
				count++;
			}
		}
		if(count==4){
			return true;
		}
		return false;
	}
	
	static boolean four_of_a_kind(int[] d){
		if(d[0]==d[3]||d[1]==d[4]){
			return true;
		}
		return false;
	}
	
	static boolean three_of_a_kind(int[] d){
		if(d[0]==d[2]||d[1]==d[3]||d[2]==d[4]){
			return true;
		}
		return false;
	}
	
	static boolean full_house(int[] d){
		if((d[0]==d[2] && d[3]==d[4])||(d[0]==d[1] && d[2]==d[4])){
			return true;
		}
		return false;
	}
	
	static boolean long_straight(int[] d){
		if(d[0]<d[1]&&
			d[1]<d[2]&&
			d[2]<d[3]&&
			d[3]<d[4]&&
			d[0]+4==d[4]){
			return true;
		}
		return false;
	}
	
	static boolean short_straight(int[] d){
		int[] c = new int[7];
		for(int i=0;i<5;i++){
			c[d[i]]=1;
		}
		if(c[1]==1&&
				c[2]==1&&
				c[3]==1&&
				c[4]==1){
			return true;
		}
		if(c[2]==1&&
				c[3]==1&&
				c[4]==1&&
				c[5]==1){
			return true;
		}
		if(c[3]==1&&
				c[4]==1&&
				c[5]==1&&
				c[6]==1){
			return true;
		}
		return false;
	}
	
	static void pick(int k, int l,int[] array){
		int[] array2 = array.clone();
		if(k==0){
			a[c]= array2;
			c++;
			return;
		}
		if(k>l){
			pick(k-1,l,array2);
		}
		int[] array3 = array.clone();
		if(k>=l&&l>0){
			array3[l-1]=k-1;
			pick(k-1,l-1,array3);
		}
	}
	
}

class intsort implements Comparator<int[]>{

    public int compare(int[] o1, int[] o2) {
    	if(o1[5]>o2[5]){
    		return -1;
    	}
    	if(o1[5]<o2[5]){
    		return 1;
    	}
    	return 0;
    }
}
