import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product bottleOfWater1 = new BottleOfWater("Water1", 100, 200);
        Product bottleOfWater2 = new BottleOfWater("Water2", 130, 250);
        Product BottleOfMilk1 = new BottleOfMilk("Milk1", 100, 900, 3);
        Product BottleOfMilk2 = new BottleOfMilk("Milk2", 90, 800, 2);
        Product chocolate1 = new Chocolate("Snikers1", 100, 140);
        Product chocolate2 = new Chocolate("Snikers2", 60, 70);
        System.out.println(chocolate2.displayInfo());
        System.out.println("----------------------");

        List<Product> products = new ArrayList<>();
        products.add(bottleOfWater1);
        products.add(bottleOfWater2);
        products.add(BottleOfMilk1);
        products.add(BottleOfMilk2);
        products.add(chocolate1);
        products.add(chocolate2);

        BottleOfWaterVendingMachine machine = new BottleOfWaterVendingMachine(products);

        Product bottleOfWaterRes = machine.getBottleOfWater("Water1", 200);
        if (bottleOfWaterRes != null) {
            System.out.println("Вы купили:");
            System.out.println(bottleOfWaterRes.displayInfo());
        } else {
            System.out.println("Такого товара нет.");
        }

        Product bottleOfMilkRes = machine.getBottleOfMilk("Milk2", 800, 2);
        if (bottleOfMilkRes != null) {
            System.out.println("Вы купили:");
            System.out.println(bottleOfMilkRes.displayInfo());
        } else {
            System.out.println("Такого товара нет.");
        }

        Product chocolateRes = machine.getChocolate("Snikers1", 140);
        if (chocolateRes != null) {
            System.out.println("Вы купили:");
            System.out.println(chocolateRes.displayInfo());
        } else {
            System.out.println("Такого товара нет.");
        }
    }

}
