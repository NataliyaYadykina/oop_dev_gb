package Example01.presenters;

import Example01.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;
    private Collection<Table> tables;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Загрузить список всех столиков
     */
    public void loadTables(){
        if (tables == null) {
            tables = model.loadTables();
        }
    }

    /**
     * Отобразить список столиков
     */
    public void updateView (){
        this.view.showTables(tables);
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер брони
     */
    private void updateReservationStatusView(int reservationNo) {
        view.showReservationStatus(reservationNo);
    }

    /**
     * Отобразить результат отмены бронирования столика
     * @param oldReservation номер брони
     * @param removeStatus статус попытки удаления брони
     * @param tableNo номер столика
     */
    private void updateRemoveReservationStatusView(int oldReservation, boolean removeStatus, int tableNo) {
        view.showRemoveReservationStatus(oldReservation, removeStatus, tableNo);
    }

    /**
     * Отобразить результат изменения бронирования столика
     * @param oldReservation старый номер брони
     * @param newReservation новый номер брони
     * @param tableNo номер столика
     */
    private void updateChangeReservationStatusView(int oldReservation, int newReservation, int tableNo) {
        view.showChangeReservationStatus(oldReservation, newReservation, tableNo);
    }

    /**
     * Получили уведомление о попытке бронирования столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        int reservationNo = model.reservationTable(orderDate, tableNo, name);
        updateReservationStatusView(reservationNo);
    }

    /**
     * Получили уведомление о попытке удаления брони
     * @param oldReservation номер бронирования
     */
    @Override
    public boolean onRemoveReservationTable(int oldReservation, int tableNo) {
        boolean removeStatus = model.removeReservationTable(oldReservation, tableNo);
        updateRemoveReservationStatusView(oldReservation, removeStatus, tableNo);
        return removeStatus;
    }

    /**
     * Получили уведомления о попытке редактирования брони
     * @param oldReservation номер старой брони
     * @param reservationDate новая дата бронирования
     * @param tableNo номер нового столика
     * @param name имя клиента
     */
    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int newReservation = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
        updateChangeReservationStatusView(oldReservation, newReservation, tableNo);
    }

}
