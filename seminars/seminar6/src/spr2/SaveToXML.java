package spr2;

import java.io.FileWriter;
import java.io.IOException;

public class SaveToXML {

    Order order;

    public SaveToXML(Order order) {
        this.order = order;
    }

    public void saveToXML() {
        String fileName = "src/spr2/order.xml";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\""+ order.getClientName() + "\",\n");
            writer.write("\"product\":\""+ order.getProduct() +"\",\n");
            writer.write("\"qnt\":"+ order.getQnt() +",\n");
            writer.write("\"price\":"+ order.getPrice() +"\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
