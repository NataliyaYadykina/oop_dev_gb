package Example01;

import Example01.models.TableModel;
import Example01.presenters.BookingPresenter;
import Example01.views.BookingView;

import java.util.Date;

public class Program {



    public static void main(String[] args) {

        TableModel tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tableModel, bookingView);
        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        bookingView.reservationTable(new Date(), 3, "Наталья");
        bookingView.reservationTable(new Date(), 3, "Владимир");
        bookingPresenter.updateView();

        /**
         * TODO: метод должен заработать
         */
        bookingView.changeReservationTable(1005, new Date(), 3, "Наталья");
        bookingView.changeReservationTable(1001, new Date(), 3, "Наталья");
        bookingPresenter.updateView();

        bookingView.removeReservationTable(1002, 3);
        bookingView.removeReservationTable(1004, 3);
        bookingPresenter.updateView();

    }

}