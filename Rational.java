public class Rational {
	long num, den;
	Rational(long n, long d) {
		long t = gcd(n,d);
		num = n/t;
		den = d/t;
	}
	Rational(long n){
		num = n;
		den = 1;
	}
	public Rational add(Rational b){
		long n = num*b.den + den * b.num;
		long d = den*den;
		return new Rational(n,d);
	}
	public Rational sub(Rational b){
		return add(b.negate());
	}
	public Rational mul(Rational b){
		long n = num*b.num;
		long d = den*b.den;
		return new Rational(n,d);
	}
	public Rational div(Rational b){
		return mul(b.recipical());
	}
	public Rational recipical(){
		return new Rational(den,num);
	}
	public Rational negate(){
		return new Rational(-num,den);
	}
	static long gcd(long a, long b){
	   return a%b==0?b:gcd(b,a%b);
	}
	public String toString(){
		return (num+"/"+den);
	}
}
