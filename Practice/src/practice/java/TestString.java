package practice.java;

import java.util.*;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 List<String> nameList = Arrays.asList(
	                "Kishor", "Abhishek", "Aman", "Suraj");
		 
		 nameList.sort((s1, s2) -> {
			 if (s1.length() < 2 || s2.length() < 2)
			 {
				 return Integer.compare(s1.length(), s2.length());
			 }
			 char ch1 = s1.charAt(1);
			 char ch2 = s2.charAt(1);
			 return Character.compare(ch1, ch2);
		 });
		 
		//  nameList.sort(Comparator.comparing(n -> n.charAt(1)));
		 
		 System.out.println(nameList);
	}

}
