import java.util.*;


public class LIS {
	   //not tested, longest increasing subsequence
	   //strictly increasing? or just increasing?
	   static ArrayList<Integer> lis(ArrayList<Integer> l){
		   ArrayList<Integer> b = new ArrayList<Integer>();
		   for(int i=0;i<l.size();i++){
	           int a = l.get(i);
	           if(b.size()==0 || b.get(b.size()-1)<a){
	               b.add(a);
	           }else{
	               int t = Math.max(0,Math.abs(Collections.binarySearch(b, a))-1);
	               if(a<b.get(t)) b.set(t, a);
	           }
		   }
		   return b;
	   }
}
