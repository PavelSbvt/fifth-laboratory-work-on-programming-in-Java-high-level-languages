package ru.sablin.lab5.models;

import ru.sablin.lab5.exceptions.NoSeatsAvailableException;


/**
 * Интерфейс классов полётов
 */
public interface Bookable {
    /**
     * Метод для бронирования мест.
     * @param seatsCount - сколько мест хочет купить пассажир
     * @return true, если удалось забронировать
     */
    boolean bookTicket(int seatsCount) throws NoSeatsAvailableException;
}
