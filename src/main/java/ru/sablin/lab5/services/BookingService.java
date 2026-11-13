package ru.sablin.lab5.services;

import ru.sablin.lab5.exceptions.NoSeatsAvailableException;
import ru.sablin.lab5.models.Bookable;
import ru.sablin.lab5.models.Flight;

import ru.sablin.lab5.utils.Rich;


/**
 * Класс с функциями для переброса исключений. Собственный класс для обработки исключений
 */
public class BookingService {
    // Ф 1: Самая нижняя. Выбрасывает исключение, но не ловит его.
    public void stepOne_CheckAvailableSeats(Flight flight, int seats) throws NoSeatsAvailableException {
        Rich.debugLog("-> [1] Проверяем наличие мест...");

        if (seats > flight.getNumberOfSeats()) {
            throw new NoSeatsAvailableException("На рейсе " + flight.getFlightId() +
                    " недостаточно мест. Запрошено: " + seats + ", свободно: "
                    + flight.getNumberOfSeats());
        }
    }

    // Ф 2: Вызывает Ф 1. Тоже не ловит, передает дальше через throws.
    public void stepTwo_ProcessBooking(Flight flight, int seats) throws NoSeatsAvailableException {
        Rich.debugLog("-> [2] Запускаем процесс бронирования...");

        // Проверяем, умеет ли этот рейс бронировать билеты
        if (flight instanceof Bookable) {
            Bookable bookableFlight = (Bookable) flight;

            boolean success = bookableFlight.bookTicket(seats);
            if (!success) {
                throw new NoSeatsAvailableException("Не удалось забронировать.");
            }
        } else {
            throw new NoSeatsAvailableException("Этот тип рейса не поддерживает бронирование билетов.");
        }
    }

    // Ф 3: Самая верхняя. Вызывает Ф 2. ловит исключения
    public void stepThree_UserClickedBookButton(Flight flight, int seats) {
        Rich.debugLog("-> [3] Пользователь нажал кнопку 'Забронировать'");

        try {
            // вторую функцию
            stepTwo_ProcessBooking(flight, seats);
            Rich.simpleLog("Успех! Билеты забронированы.");

        } catch (NoSeatsAvailableException e) {
            // Цепочка прервана. Дальше исключение не идет.
            Rich.warningLog("ошибка. обработано в ф 3: " + e.getMessage());

        } finally {
            Rich.debugLog("-> [3] Блок finally: записываем факт " +
                    "попытки бронирования в лог.");
        }
    }
}