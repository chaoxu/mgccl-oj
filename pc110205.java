import java.util.*;
import java.io.*;
public class pc110205 {
	static String ReadLn(int maxLength) throws IOException{  // utility function to read from stdin,
        // Provided by Programming-challenges, edit for style only
		byte line[] = new byte [maxLength];
		int length = 0;
		int input = -1;
		try{
			while (length < maxLength){//Read untill maxlength
			input = System.in.read();
			if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
			line [length++] += input;
			}
		
			if ((input < 0) && (length == 0)) return null;  // eof
			return new String(line, 0, length);
		}catch (IOException e){
			return null;
		}
	}
	
	public static void main (String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String input = new String();
		try{
			while(input.concat(ReadLn(3000)) != null){
				
			}
		}catch (IOException e){
		}
		
		System.out.println(input);
		for(int i=0;i<n;i++){
			int[] d = new int[52];
			for(int j=0;j<52;j++){
				d[j] = j;
			}
			int m = in.nextInt();
			int[][] s = new int[m][52];
			for(int j=0;j<m;j++){
				for(int k=0;k<52;k++){
					s[j][k] = in.nextInt()-1;
				}
			}
			in.nextLine();
			String str = in.nextLine();
			Scanner strin = new Scanner(str);
			if(i!=n-1){
				while(strin.hasNextInt()){
					int t = strin.nextInt()-1;
					int[] d2 = new int[52];
					for(int j=0;j<52;j++){
						d2[j] = d[s[t][j]];
					}
					d = d2;
					str = in.nextLine();
					strin = new Scanner(str);
				}
			}else{
				while(str.length()!=0){
					int t = Integer.parseInt(str)-1;
					int[] d2 = new int[52];
					for(int j=0;j<52;j++){
						d2[j] = d[s[t][j]];
					}
					d = d2;
					str = in.nextLine();
				}
			}
			for(int j=0;j<52;j++){
				System.out.println(int2name(d[j]));
			}
			if(i!=n-1){
				System.out.println();
			}
		}
	}
	
	static String int2name(int i){
		String name;
		String suit;
		if(i % 13<9){
			name = String.valueOf((i%13)+2);
		}else if(i% 13== 9){
			name = "Jack";
		}else if(i%13 == 10){
			name = "Queen";
		}else if(i%13 == 11){
			name = "King";
		}else{
			name = "Ace";
		}
		
		if(i/13==0){
			suit = "Clubs";
		}else if(i/13 == 1){
			suit = "Diamonds";
		}else if(i/13 == 2){
			suit = "Hearts";
		}else{
			suit = "Spades";
		}
		
		return name.concat(" of ").concat(suit);
	}
}
