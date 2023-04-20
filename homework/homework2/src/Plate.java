public class Plate {

    private int food;

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        if (food < 0) {
            this.food = 0;
        } else {
            this.food = food;
        }
    }

    public Plate(int food) {
        this.food = food;
    }

    public void addFood(int food){
        this.setFood(getFood() + food);
    }

    public void info() {
        System.out.println("plate: " + food);
    }

}
