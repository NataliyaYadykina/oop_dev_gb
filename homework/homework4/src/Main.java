import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Box<Apple> box1 = new Box<>(1, new ArrayList<>());
        box1.addFruit(new Apple(), 5);
        System.out.printf("Вес коробки #%d: %.2f\n", box1.getId(), box1.getWeight());

        Box<Orange> box2 = new Box<>(2, new ArrayList<>());
        box2.addFruit(new Orange(), 7);
        System.out.printf("Вес коробки #%d: %.2f\n", box2.getId(), box2.getWeight());

        System.out.println("Сравним коробки по весу:");
        System.out.println(box1.compare(box2));

        Box<Apple> box3 = new Box<>(3, new ArrayList<>());
        box3.addFruit(new Apple(), 6);
        System.out.printf("Вес коробки #%d: %.2f\n", box3.getId(), box3.getWeight());

        Box<Orange> box4 = new Box<>(4, new ArrayList<>());
        box4.addFruit(new Orange(), 4);
        System.out.printf("Вес коробки #%d: %.2f\n", box4.getId(), box4.getWeight());

        System.out.println("Сравним коробки по весу:");
        System.out.println(box3.compare(box4));

        box1.pourFromTo(box3);
        System.out.println(box1);
        System.out.println(box3);

    }

}