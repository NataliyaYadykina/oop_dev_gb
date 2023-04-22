public class Main {

    public static void main(String[] args) {

        // Создаем котов
        Cat[] cats = {
                new Cat("Барсик", 10),
                new Cat("Мурзик", 15),
                new Cat("Персик", 12),
                new Cat("Борис", 14)
        };

        // Создаем тарелку и наполняем ее едой
        Plate plate = new Plate();
        plate.putFood(35);

        System.out.println("***");

        // Кормим котов
        for (Cat c : cats) {
            c.eat(plate);
        }

        System.out.println("***");

        // Результаты кормления
        for (Cat c : cats) {
            System.out.println("Кот " + c.getName() + " сытость: " + c.isSatiety());
        }
    }
}