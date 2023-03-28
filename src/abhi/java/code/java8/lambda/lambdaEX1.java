package abhi.java.code.java8.lambda;

@FunctionalInterface
interface Drawable{
    void draw();
}

/*

class DrawableImp implements Drawable{

    @Override
    public void draw() {
        System.out.println("Drawing ...");
    }
}

*/

public class lambdaEX1 {
    public static void main(String[] args) {

        /*
        Drawable draw=new DrawableImp();
        draw.draw();
        */

      /*  Drawable drawable=new Drawable() {
            @Override
            public void draw() {
                System.out.println("Drawing...");
            }
        };
          drawable.draw();
        */

        // java 8 implementations

        Drawable drawable= ()-> System.out.println("Drawing...");
        drawable.draw();
    }
}
