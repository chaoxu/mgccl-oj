import java.util.*;
public class uva10020 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int nz = in.nextInt();
		for(int z=0;z<nz;z++){
			int m = in.nextInt();
			ArrayList<int[]> v = new ArrayList<int[]>();
			int min=0;
			int max=0;
			int[] mi=new int[2];
			mi[0] = -1;
			mi[1] = -1;
			while(in.hasNext()){
				int[] b = new int[2];
				b[0] = in.nextInt();
				b[1] = in.nextInt();
				if(b[0]==0&&b[1]==0){
					break;
				}
				v.add(b);
			}
			Collections.sort(v,new sorttemplate());
			ArrayList<int[]> a = new ArrayList<int[]>();
			for(int i=0;i<v.size();i++){
				int[] b = v.get(i); 
				if(b[0]>min){
					if(max<b[0]){
						a.clear();
						break;
					}
					min = max;
					a.add(mi);
				}
				if(b[1]>=max){
					max = b[1];
					mi = b;
				}
				if(mi[1]>=m){
					a.add(mi);
					break;
				}
			}
			if(a.size()>0&&a.get(a.size()-1)[1]<m){
				a.clear();
			}
			System.out.println(a.size());
			for(int i=0;i<a.size();i++){
				System.out.println(a.get(i)[0] + " " + a.get(i)[1]);
			}
			System.out.println();
		}
	}
}
class sorttemplate implements Comparator<int[]>{
    public int compare(int[] o1, int[] o2) {
    	if(o1[0]>o2[0]){
    		return 1;
    	}
    	if(o1[0]<o2[0]){
    		return -1;
    	}
    	return 0;
    }
}
