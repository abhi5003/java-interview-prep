package abhi.java.code.java8.streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterEX {
    public static void main(String[] args) {

        List<Product> list=new ArrayList<>();
//        for (Product product:getProducts()){
//            if (product.getPrice()<70000f){
//                list.add(product);
//            }
//        }
//        System.out.println(list);

        getProducts().stream().filter(i->i.getPrice()<70000f)
                .collect(Collectors.toList()).forEach(System.out::println);

    }

    private static List<Product> getProducts(){
        ArrayList<Product> list=new ArrayList<>();
        list.add(new Product(1234, "HP", 50000.05f));
        list.add(new Product(1234, "Apple", 70000.05f));
        list.add(new Product(1234, "Lenovo", 50590.05f));
        list.add(new Product(1234, "Dell", 59494.05f));

        return list;

    }
}

class Product{

    private int serialID;
    private String name;
    private float price;

    public Product(int serialID, String name, float price) {
        this.serialID = serialID;
        this.name = name;
        this.price = price;
    }

    public int getSerialID() {
        return serialID;
    }

    public void setSerialID(int serialID) {
        this.serialID = serialID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "serialID=" + serialID +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
