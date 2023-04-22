/**
 * Кот
 */
public class Cat {

    //#region Fields

    /**
     * Кличка
     */
    private String name;

    /**
     * Аппетит
     */
    private int appetite;

    /**
     * Сытость
     */
    private boolean satiety;

    //#endregion

    //#region Constructors

    /**
     *
     * @param name - кличка кота
     */
    public Cat(String name) {
        this.name = name;
        this.satiety = false;
    }

    /**
     *
     * @param name - кличка кота
     * @param appetite - сытость
     */
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    //#endregion


    /**
     * Покормить кота
     * @param plate - тарелка с едой
     */
    public void eat(Plate plate) {
        // Удаляем еду из миски в соответствии с аппетитом кота
        if (plate.decreaseFood(this.appetite)) { // Еды оказалось достаточно
            System.out.println(this.name + " покушал в соответствии со своим аппетитом " + this.appetite);
            // Кот насытился
            this.satiety = true;
        } else { // Еды оказалось недостаточно
            // п.4 Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
            // то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
            System.out.println(this.name + " не будет есть эти крошки. Еды не хватило.");
        }
    }

    /**
     * Вернуть кличку кота
     * @return - кличка кота
     */
    public String getName() {
        return name;
    }

    /**
     * Установить кличку кота
     * @param name - кличка кота
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Вернуть признак сытости кота
     * @return - сытость
     */
    public boolean isSatiety() {
        return satiety;
    }
}