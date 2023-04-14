public class Chocolate extends Product {
    private int weight;

    public Chocolate(String name, double price, int weight){
        super(name, price);
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    @Override
    String displayInfo() {
        return String.format("%s - %s - %f - вес - %d", brand, name, price, weight);
    }
}
