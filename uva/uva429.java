import java.util.*;
public class uva429{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int o = in.nextInt();
        in.nextLine();
        in.nextLine();
        while(o>0){
            HashSet<String> h = new HashSet<String>();

            // read strings
            while(true){
                String s = in.nextLine();
                if(s.equals("*")){
                    break;
                }
                h.add(s);
            }
            while(true){
            	if(!in.hasNext()){
            		break;
            	}
                String s = in.nextLine();
                if(s.equals("")){
                	if(o>1){
                		System.out.println();
                	}
                    break;
                }
                String[] m = s.split(" ");
                int t = solve(m[0],m[1],h);
                System.out.println(m[0]+" "+m[1]+" "+t);
            }
            o--;
        }
    }
    
    public static int solve(String a, String b, HashSet<String> h){
        Queue<String> q = new LinkedList<String>();
        HashSet<String> seen = new HashSet<String>();
        HashMap<String,Integer> firstseen = new HashMap<String,Integer>();
        q.offer(a);
        seen.add(a);
        firstseen.put(a,0);
        while(!q.isEmpty()){
            String s = q.poll();
            for(int i=0;i<s.length();i++){
                char[] z = s.toCharArray();
                for(int j=0;j<26;j++){
                    z[i] = (char) (j+97);
                    String t = String.valueOf(z);
                    if(h.contains(t)&&!seen.contains(t)){
                        seen.add(t);
                        firstseen.put(t,firstseen.get(s)+1);
                        q.offer(t);
                    }
                    if(s.equals(b)){
                        return firstseen.get(b);
                    }
                }
            }
        }
        return 0;
    }
}
