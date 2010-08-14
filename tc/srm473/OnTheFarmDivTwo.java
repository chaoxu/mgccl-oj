public class OnTheFarmDivTwo{
	public int[] animals(int heads, int legs){
		int cow = heads;
		int l = 4*heads;
		int[] c = new int[2];
		while(l>=legs&&l>-1){
			if(l!=legs){
				l-=2;
				c[0]++;
			}else{
				break;
			}
		}
		c[1] = heads - c[0];
		if(c[0]*2+c[1]*4!=legs||c[1]<0){
			return new int[0];
		}
		return c;
	}
}
