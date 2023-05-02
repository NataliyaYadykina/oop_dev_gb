package Example01.views;

import Example01.models.Table;
import Example01.presenters.View;
import Example01.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    /**
     * Отобразить список столиков
     * @param tables список столиков
     */
    public void showTables(Collection<Table> tables){

        for (Table table: tables) {
            System.out.println(table);
        }

    }

    /**
     * Отобразить результат бронирования
     * @param reservationNo номер брони
     */
    @Override
    public void showReservationStatus(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик успешно забронирован. Номер брони: %d\n", reservationNo);
        }
        else {
            System.out.println("Ошибка бронирования столика.");
        }
    }

    /**
     * Отобразить результат удаления брони
     * @param oldReservation номер бронирования
     * @param removeStatus удален или нет
     * @param tableNo номер столика
     */
    @Override
    public void showRemoveReservationStatus(int oldReservation, boolean removeStatus, int tableNo) {
        if (removeStatus) {
            System.out.printf("Бронирование #%d столика #%d успешно отменено.\n", oldReservation, tableNo);
        }
        else {
            System.out.printf("Ошибка отмены бронирования #%d столика #%d.\n", oldReservation, tableNo);
        }
    }

    /**
     * Отобразить результат изменения бронирования столика
     * @param oldReservation старый номер бронирования столика
     * @param newReservation новый номер бронирования столика
     * @param tableNo номер столика
     */
    @Override
    public void showChangeReservationStatus(int oldReservation, int newReservation, int tableNo) {
        if (newReservation > 0) {
            System.out.printf("Бронирование #%d отменено. Новый номер брони: #%d\n", oldReservation, newReservation);
        }
        else {
            System.out.printf("Ошибка редактирования брони #%d столика #%d.\n", oldReservation, tableNo);
        }
    }

    /**
     * Установить наблюдателя
     * @param observer наблюдатель (презентер)
     */
    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Действие клиента (пользователь нажал на кнопку Бронирование столика)
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    public void reservationTable(Date orderDate, int tableNo, String name){

        observer.onReservationTable(orderDate, tableNo, name);

    }

    /**
     * Действие клиента (пользователь нажал на кнопку Удалить Бронирование столика)
     * @param oldReservation номер бронирования
     */
    public void removeReservationTable(int oldReservation, int tableNo) {
        observer.onRemoveReservationTable(oldReservation, tableNo);
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param oldReservation идентификатор бронирования
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        // TODO: обратиться к наблюдателю, указать на процедуру бронирования столика,
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }

}
