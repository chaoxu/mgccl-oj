import java.io.*;
import java.text.*;
import java.util.*;
public class timus1001{
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		Stack<Double> a = new Stack<Double>();
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(4);
		nf.setMinimumFractionDigits(4);
		nf.setGroupingUsed(false);
		while(in.hasNext()){
			a.push(Math.sqrt(in.nextLong()));
		}
		while(!a.empty()){
			System.out.println(nf.format(a.pop()));
		}
	}
}
