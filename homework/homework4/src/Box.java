import java.util.ArrayList;

public class Box<T extends Fruit> {

    private int id;
    private ArrayList<T> fruit;

    public int getId() {
        return id;
    }

    public void setFruit(ArrayList<T> fruit) {
        this.fruit = fruit;
    }

    public Box(int id, ArrayList<T> fruit) {
        this.fruit = fruit;
        this.id = id;
        System.out.printf("Создана пустая коробка #%d.\n", id);
    }

    public void addFruit(T fruit, int count){
        for (int i = 0; i < count; i++) {
            this.fruit.add(fruit);
        }
        System.out.printf("В коробку #%d положили %s: %d шт. весом по %.2f\n", id, fruit, count, fruit.getWeight());
    }

    public double getWeight(){
        if (fruit.size() > 0) {
            return fruit.get(0).getWeight() * fruit.size();
        }
        return 0;
    }

    public boolean compare(Box box) {
        if (this.getWeight() == box.getWeight()) {
            return true;
        }
        return false;
    }

    public void pourFromTo(Box<T> boxTo){
        if (getWeight() > 0){
            System.out.printf("%s (%d шт.) пересыпано из коробки #%d в коробку %d\n",
                    fruit.get(0).toString(), fruit.size(), getId(), boxTo.getId());
            boxTo.addFruit(fruit.get(0), fruit.size());
            setFruit(new ArrayList<>());
            System.out.printf("Коробка #%d пуста, а в коробке #%d теперь %d шт. фрукта %s\n",
                    getId(), boxTo.getId(), boxTo.fruit.size(), boxTo.fruit.get(0).toString());
        }
        else {
            System.out.printf("Коробка #%d пуста, из нее пересыпать нечего.", getId());
        }
    }

    @Override
    public String toString() {
       return String.format("%s", fruit);
    }
}
