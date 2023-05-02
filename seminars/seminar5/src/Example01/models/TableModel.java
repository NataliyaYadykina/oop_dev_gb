package Example01.models;

import Example01.presenters.Model;

import java.util.*;

/**
 * Коллекция столиков
 */
public class TableModel implements Model {

    private Collection<Table> tables;

    /**
     * Список доступных столиков
     * @return коллекцию столиков
     */
    public Collection<Table> loadTables(){
        if (tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     * @return новый номер бронирования столика или -1
     */
    public int reservationTable(Date reservationDate, int tableNo, String name){
        for (Table table: tables) {
            if (table.getNo() == tableNo) {

                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
        // throw new RuntimeException("Некорректный номер столика");
    }

    /**
     * Отменить бронирование столика
     * @param oldReservation номер бронирования
     * @param tableNo номер столика
     * @return отменено (true) или нет (false)
     */
    public boolean removeReservationTable(int oldReservation, int tableNo) {
        boolean flag = false;
        for (Table table: tables) {
            if (table.getNo() == tableNo) {
                for (Reservation reservation: table.getReservations()) {
                    if (reservation.getId() == oldReservation) {
                        table.getReservations().remove(reservation);
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    /**
     * // TODO: Разработать самостоятельно
     * Поменять бронь столика
     * @param oldReservation номер старого резерва (для снятия)
     * @param reservationDate дата резерва столика
     * @param tableNo номер столика
     * @param name Имя
     * @return новый номер бронирования столика или -1
     */
    public int changeReservationTable (int oldReservation, Date reservationDate, int tableNo, String name) {
        int newReservation = -1;
        if (removeReservationTable(oldReservation, tableNo)) {
            newReservation = reservationTable(reservationDate, tableNo, name);
        }
        return newReservation;
    }

}
