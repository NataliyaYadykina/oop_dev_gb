package Example01.models;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Базовый класс Столик
 */
public class Table {

    private static int counter;
    // Список бронирований столика:
    private final Collection<Reservation> reservations = new ArrayList<>();
    private final int no;

    {
        no = ++counter;
    }

    public int getNo() {
        return no;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public String toString() {
        return String.format("Столик #%d (%s)", no, reservations);
    }
}
