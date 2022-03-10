package abhi.java.code.java9;

public class PrivateInterfaceMethod implements CustomInterface{
    @Override
    public void abstractMethod() {
        System.out.println("abstract Method implementation");
    }

    public static void main(String[] args) {
        CustomInterface customInterface = new PrivateInterfaceMethod();
        customInterface.defaultMethod();
        customInterface.abstractMethod();
        CustomInterface.staticMethod();
    }
}



interface CustomInterface {

    public abstract void abstractMethod();

    public
    default void defaultMethod() {
//        privateMethod(); //private method inside default method
//        privateStaticMethod(); //static method inside other non-static method
        System.out.println("default method");
    }

    public static void staticMethod() {
//        privateStaticMethod(); //static method inside other static method
        System.out.println("static method");
    }

//    private void privateMethod() {
//        System.out.println("private method");
//    }
//
//    private static void privateStaticMethod() {
//        System.out.println("private static method");
//    }
}