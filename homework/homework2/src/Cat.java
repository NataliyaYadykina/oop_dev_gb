public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(int food) {
        if (food >= appetite) {
            satiety = true;
            System.out.printf("%s наелся и теперь доволен :)\n", name);
        } else {
            System.out.printf("%s остался голодным :(\n", name);
        }
    }

}
