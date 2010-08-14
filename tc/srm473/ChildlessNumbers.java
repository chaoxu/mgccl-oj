public class ChildlessNumbers{
	public static void main(String[] args){
		System.out.println(howMany(966660000, 966670000));
	}
	public static int howMany(int x, int y){
		long a = x;
		long b = y;
		int c =y-x+1;
		for(long i=x;i<y+1;i++){
			for(long j=1;j<100;j++){
				int t = digit_sum(i*j);
				if(t==j){
					c--;
					break;
				}
			}
		}
		return c;
	}

	public static int digit_sum(long n){
		int s = 0;
		while(n!=0){
			s+=n%10;
			n/=10;
		}
		return s;
	}
}

