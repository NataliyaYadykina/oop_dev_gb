package dip;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private List<ReportItem> items; // Отчетные данные

    // расчет отчетных данных
    public void calculate(){
        items = new ArrayList<ReportItem>();
        items.add(new ReportItem("First", (float)5));
        items.add(new ReportItem("Second", (float)6));
    }

    public void print() {
        Output output = new PrintReport();
        output.output(items);
    }

    public void printAll() {
        Output output = new PrintReport2();
        output.output(items);
    }

    public void saveToFile() {
        Output output = new PrintReport3();
        output.output(items);
    }

}
