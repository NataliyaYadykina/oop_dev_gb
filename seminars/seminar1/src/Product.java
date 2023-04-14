/**
 * Продукт
 */
public class Product {

    protected String name;
    protected String brand;
    protected double price;

    int param1;
    String param2;
    boolean param3;
    String param4;

    public double getPrice(){
        return price;
    }

    public void setPrice(double price) {
        // if (price <= 0){
        //     throw new RuntimeException("Цена указана неверно.");
        // }
        if (price <= 0)
            this.price = 1;
        else
            this.price = price;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3)
            this.name = "Noname";
        else
            this.name = name;
    }

    {
//        System.out.println("Initializer");
        param1 = 100;
        param2 = "..";
        param3 = true;
        param4 = "***";
    }

    public Product(){
        this("Продукт");
    }

    public Product(String name){
        this(name, 1);
    }

    public Product(String name, double price){
        this("Noname", name, price);
    }

    public Product(String brand, String name, double price){
//        System.out.println("Constructor");
        if (brand.length() < 3)
            this.brand = "Brand";
        else
            this.brand = brand;
        if (name.length() < 3)
            this.name = "Noname";
        else
            this.name = name;
        if (price <= 0)
            this.price = 1;
        else
            this.price = price;
    }

    /**
     * Получить информацию по продукту
     * @return Информация по продукту
     */
    String displayInfo(){
        return String.format("%s - %s - %f", brand, name, price);
    }
}