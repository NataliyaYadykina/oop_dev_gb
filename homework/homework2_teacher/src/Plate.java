/**
 * Тарелка с едой
 */
public class Plate {

    private int food;

    /**
     * Добавление еды в тарелку
     * @param amount  - кол-во еды (в условных единицах)
     */
    public void putFood(int amount) {
        this.food += amount;
        System.out.printf("Добавлено %d еды в тарелку, теперь в тарелке %d еды\n", amount, food);
    }

    /**
     * Удаление еды из тарелки
     * @param amount - кол-во еды (в условных единицах)
     * @return - если в тарелке, после удаления, остается достаточно еды, возвращаем результат операции true,
     * в противном случае, не удаляем еду, возвращаем результат операции false
     */
    public boolean decreaseFood(int amount) {
        if (this.food < amount) {
            System.out.println("Недостаточно еды для ее удаления");
            return false;
        }
        this.food -= amount;
        System.out.printf("Удалено %d еды из тарелки, теперь в тарелке %d еды\n", amount, food);
        return true;
    }

}