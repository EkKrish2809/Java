import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

class TestFunctionalInterface {
    public static void main(String[] args) {
        Greeting g = n -> System.out.println("Hello " + n); // Lambda
        g.sayHello("Kishor");

        // sum operation
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> { return a+b;};
        System.out.println("Sum is : "+sum.apply(2, 4));
        
       // even number
        Predicate<Integer> result = n -> (n%2== 0 && n > 0);
        System.out.println("Is Even : "+result.test(35));
        System.out.println("Is Even : "+result.test(76));
       
       // consumer
       Consumer<String> strCat = (s1) -> { System.out.println("Hello "+s1) ;};
       strCat.accept("Kishor");
       
       // Supplier
       Supplier<Double> randNum = () -> Math.random();
       System.out.println(randNum.get());
    }
}