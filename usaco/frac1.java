/*
ID: mgcclx1
LANG: JAVA
TASK: frac1 
*/
import java.util.*;
import java.io.*;
public class frac1{
    static BufferedWriter out;
	public static void main(String args[]) throws IOException{
    	Scanner in = new Scanner(new File("frac1.in"));
    	FileWriter fstream = new FileWriter("frac1.out");
        out = new BufferedWriter(fstream);
		int n = in.nextInt();
		ArrayList<int[]> a = new ArrayList<int[]>();
		for(int i=1;i<=n;i++){
			for(int j=0;j<=i;j++){
				if(gcd(j,i)==1){
					int[] t = new int[2];
					t[0] = j;
					t[1] = i;
					a.add(t);
				}
			}
		}
		Collections.sort(a, new sorttemplate());
		for(int i=0;i<a.size();i++){
			out.write(a.get(i)[0]+"/"+a.get(i)[1]+"\n");
		}
		out.close();
	}
   static int gcd(int a, int b){
        if(a%b==0)
     	   return b;
        return gcd(b, a%b);
   }
}
class sorttemplate implements Comparator<int[]>{
    public int compare(int[] o1, int[] o2) {
    	if(o1[0]*o2[1]>o2[0]*o1[1]){
    		return 1;
    	}
    	return -1;
    }
}
