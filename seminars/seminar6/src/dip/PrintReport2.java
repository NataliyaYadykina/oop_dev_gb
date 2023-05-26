package dip;

import java.util.List;

public class PrintReport2 extends Output {

    @Override
    public void output(List<ReportItem> items) {
        System.out.println("Output to printer2");
        for (ReportItem item : items) {
            System.out.printf("printer %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }

}
