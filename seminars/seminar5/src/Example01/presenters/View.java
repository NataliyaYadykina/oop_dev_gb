package Example01.presenters;

import Example01.models.Table;

import java.util.Collection;
import java.util.Date;

/**
 * Интерфейс как связующее звено между Презентером и Представлением
 */
public interface View {

    /**
     * Отобразить список всех столиков
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Отобразить результат бронирования
     * @param reservationNo номер брони
     */
    void showReservationStatus(int reservationNo);

    /**
     * Отобразить результат удаления брони
     * @param oldReservation номер бронирования
     * @param removeStatus удален или нет
     * @param tableNo номер столика
     */
    void showRemoveReservationStatus(int oldReservation, boolean removeStatus, int tableNo);

    /**
     * Отобразить результат изменения бронирования столика
     * @param oldReservation старый номер бронирования столика
     * @param newReservation новый номер бронирования столика
     * @param tableNo номер столика
     */
    void showChangeReservationStatus(int oldReservation, int newReservation, int tableNo);

    /**
     * Установить нового наблюдателя
     * @param observer наблюдатель (презентер)
     */
    void setObserver(ViewObserver observer);

}
