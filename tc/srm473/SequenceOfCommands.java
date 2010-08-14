public class SequenceOfCommands{
	public String whatHappens(String[] commands){
		String r = new String();
		for(int i=0;i<commands.length;i++){
			r = r+commands[i];
		}
		char[] c = r.toCharArray();
		//2 stacks
		int[] s  = new int[2];
		int d = 0;//direction
		for(int j=0;j<4;j++){
		for(int i=0;i<c.length;i++){
			if(c[i]=='L'){
				d = (d+1)%4;
			}
			if(c[i]=='R'){
				d = (d+3)%4;
			}
			if(c[i]=='S'){
				int t = 1;
				if(d==1||d==0){
					t = -1;
				}
				s[d%2]+=t;
			}
		}
			if(s[0]==0&&s[1]==0){
				return "bounded";
			}
		}
		return "unbounded";
	}
}
