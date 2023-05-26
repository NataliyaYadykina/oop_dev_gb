package dip;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PrintReport3 extends Output {

    @Override
    public void output(List<ReportItem> items) {
        String fileReport = "src/dip/report.txt";
        try(FileWriter writer = new FileWriter(fileReport, false)){
            for (ReportItem item : items) {
                writer.write("printer " + item.getDescription() + " - " + item.getAmount() + ";\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
