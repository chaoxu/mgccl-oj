//incomplete
public class SubAnagrams{
	
	public static int maximumParts(String[] suppliedWord){
		String s = "";
		table[i]
		for(int i=0;i<suppliedWord.length;i++){
			s = s + suppliedWord[i];
		}
		char[] c = s.toCharArray();
		


		int count = 0;
		char[] p = new char[0];
		//char[] n = ;
		while(true){
			if(ArrayCopyOf(c)

		}

	}

	public static boolean subanagram(char[] a, char[] b){
		int[] ca = new int[256];
		int[] cb = new int[256];
		for(int i=0;i<a.length;i++){
			ca[(int) a[i]]++;
		}
		for(int i=0;i<b.length;i++){
			cb[(int) b[i]]++;
		}
		for(int i=0;i<256;i++){
			if(cb[i]<ca[i]){
				return false;
			}
		}
		return true;
	}
}
