package spr2;

public class Program {

    public static void main(String[] args) {
        // TODO: Сохранить заказ в XML документ

        System.out.println("Введите заказ:");
        Order order = new Order("", "", 0, 0);
        order.inputFromConsole();
        SaveToJSON saveToJSON = new SaveToJSON(order);
        SaveToXML saveToXML = new SaveToXML(order);
        saveToJSON.saveToJson();
        saveToXML.saveToXML();

    }

}
