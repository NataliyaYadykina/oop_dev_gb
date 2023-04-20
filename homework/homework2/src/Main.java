import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Barsik", 5);
        Plate plate = new Plate(10);
        plate.info();
        cat1.eat(plate.getFood());
        if (cat1.isSatiety()) {
            plate.setFood(plate.getFood() - cat1.getAppetite());
        }
        plate.info();

        Cat[] cats = new Cat[] {
                new Cat("Persik", 8),
                new Cat("Pushok", 7),
                new Cat("Snezhok", 9),
                new Cat("Lord", 10),
                new Cat("Drakula", 8)
        };

        Plate plate1 = new Plate(20);
        System.out.printf("Новая тарелка для котиков: %d\n", plate1.getFood());

        Random random = new Random();
        for (Cat cat: cats) {
            cat.eat(plate1.getFood());
            if (cat.isSatiety()) {
                plate1.setFood(plate1.getFood() - cat.getAppetite());
            }
            plate1.info();
            int food = random.nextInt(5);
            plate1.addFood(food);
            System.out.printf("В тарелку добавлено %d еды. Теперь в тарелке %d корма.\n", food, plate1.getFood());
        }

    }

}