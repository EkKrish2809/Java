package start.generics_demo;

public class SingleGenericHolder<T> {

    T obj;

    SingleGenericHolder(T obj) {
        this.obj = obj;
    }

    public T getObject() {
        return this.obj;
    }

    public static void main(String[] args) {
        
        SingleGenericHolder<Integer> intObj = new SingleGenericHolder<Integer>(111);
        System.out.println("Generics Integer : " + intObj.getObject());

        SingleGenericHolder<String> stringObj = new SingleGenericHolder<String>("Generics");
        System.out.println("Generics String : " + stringObj.getObject());
    }
    
}
