package start.generics_demo;

public class DualGenericHolder<P, Q> {
    
    P obj1;
    Q obj2;

    DualGenericHolder(P obj1, Q obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void display() {
        System.out.println(obj1);
        System.out.println(obj2);
    }

    public static void main(String[] args) {
        
        DualGenericHolder<String, Integer> objDual = new DualGenericHolder<String,Integer>("Dual Generic", 111);
        objDual.display();
    }
}
