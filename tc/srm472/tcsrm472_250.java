public class tcsrm472_250{
	public int theMin(String room){
		char[] c = room.toCharArray();
		int count = 0;
		for(int i=1;i<c.length;i++){
			if(c[i-1]==c[i]){
				count++;
				i=i+1;
			}
		}
		return count;
	}
}
