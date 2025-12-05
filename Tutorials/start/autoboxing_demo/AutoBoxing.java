package start.autoboxing_demo;

public class AutoBoxing {
    
    public static void main(String[] args) {
        int i = 11;

        Integer intObj = Integer.valueOf(i);    // Autoboxing
        // Integer intObj = i;    // Autoboxing
        int ii = intObj;                        // Unboxing
        System.out.println("Autoboxed int : " + intObj);
        System.out.println("Unboxed Integer : " + ii);

        char ch = 'a';
        Character charObj = Character.valueOf(ch);  // Autoboxing
        char cchh = charObj;                        // Unboxing
        System.out.println("Autoboxed char : " + charObj);
        System.out.println("Unboxed Character : " + cchh);

    }
}

/* 
    Autoboxing is the conversion that the java compiler makes between the primitive types and their 
    corresponding object wrapper classes.

    Unboxing / Auto-unboxing is the reverse of the Autoboxing
*/
