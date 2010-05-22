import java.util.*;

class sorter implements Comparator<Integer[]>{
    public int compare(Integer[] o1, Integer[] o2) {
    	if(o1[2]>o2[2]){
    		return 1;
    	}
    	if(o1[2]<o2[2]){
    		return -1;
    	}
    	return 0;
    }
}
public class pc110406 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();        
        int[] t;
        for(int i=0;i<n;i++){
        	if(i!=0){
        		System.out.println();
        	}
        	t = new int[24];
        	for(int j=0;j<24;j++){
        		t[j] = in.nextInt();
        	}
        	in.nextLine();
        	Map<String,ArrayList<Integer[]>> m = new HashMap<String,ArrayList<Integer[]>>();
        	String str = in.nextLine();
        	while(in.hasNextLine()){
        		Scanner s = new Scanner(str);
        		String plate = s.next();
        		String time = s.next();
        		time = time.replace(':', ' ');
        		Scanner ts = new Scanner(time);
        		int ti=0;
        		ti+=ts.nextInt()*100*100*100;
        		ti+=ts.nextInt()*100*100;
        		int hour = ts.nextInt();
        		ti+=hour*100;
        		ti+=ts.nextInt();
        		
        		int exit=0;
        		if(s.next().compareTo("exit")==0){
        			exit = 1;
        		}
        		int miles = s.nextInt();
        		Integer[] d= new Integer[4];
        		d[0] = exit;
        		d[1] = miles;
        		d[2] = ti;
        		d[3] = hour;
        		if(m.containsKey(plate)){
        			m.get(plate).add(d);
        		}else{
        			ArrayList<Integer[]> orz = new ArrayList<Integer[]>();
        			orz.add(d);
        			m.put(plate,orz);
        		}
        		str = in.nextLine();
        		if(str.length()==0){
        			break;
        		}
        	}
    		String[] key = new String[m.keySet().size()];
    		m.keySet().toArray(key);
    		//time to sort. a PUN. lol
    		sorter st = new sorter();
    		for(int j=0;j<key.length;j++){
    			Collections.sort(m.get(key[j]),st);
    		}
    		Map<String, Integer> m2 = new HashMap<String, Integer>();
    		for(int j=0;j<key.length;j++){
    			int sum = 200;
    			for(int k=0;k<m.get(key[j]).size()-1;k++){
    				if(m.get(key[j]).get(k)[0]==0){
    					if(m.get(key[j]).get(k+1)[0]==1){
    						int hour = m.get(key[j]).get(k)[3];
    						sum += t[hour]*Math.abs((m.get(key[j]).get(k+1)[1]-m.get(key[j]).get(k)[1]));
    						sum += 100;
    					}
    				}
    			}
    			m2.put(key[j],sum);
    		}
    		Arrays.sort(key);
    		for(int j=0;j<key.length;j++){
    			if(m2.get(key[j])!=200){
    				String end = String.valueOf(m2.get(key[j])%100);
    				if(m2.get(key[j])%100<10){
    					end = "0".concat(end);
    				}
    				System.out.println(key[j]+" $"+m2.get(key[j])/100 + "."+ end);
    			}
    		}
        }
    }
}
