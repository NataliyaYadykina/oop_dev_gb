package dip;

import java.util.List;

public class PrintReport extends Output {

    @Override
    public void output(List<ReportItem> items) {
        System.out.println("Output to printer");
        for (ReportItem item : items) {
            System.out.printf("printer %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }

}
