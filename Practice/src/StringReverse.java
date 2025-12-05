
public class StringReverse {

	private static String reverse(String str) {
		char rev[] = new char[str.length()];
		for (int i= str.length()-1; i >= 0 ; i--) {
			rev[(str.length()-1) - i] = str.charAt(i);
		}
		
		return new String(rev);
		
	}
	
	private static String reverse2(String str) {
		if (str == null)
			return null;
		
		return new StringBuilder(str).reverse().toString();
	}
	
	private static String reverse3(String str) {
		if (str == null)
			return null;
		
		int front = 0;
		int back = str.length() - 1;
		
		char rev[] = new char[str.length()];
		
		while (front <= back) {
			char tmp = str.charAt(front);
			rev[front] = str.charAt(back);
			rev[back] = tmp;
			front++;
			back--;
			
		}
		
		return new String(rev);
	}
	
	public static void main(String[] args) {

		String str1 = "Application";
		String strRev = reverse(str1);
//		String strRev = reverse2(str1);
//		String strRev = reverse3(str1);
		System.out.println(strRev.toLowerCase());
	}

}
