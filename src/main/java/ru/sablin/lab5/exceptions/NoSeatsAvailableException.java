package ru.sablin.lab5.exceptions;

/**
 * Собственное исключение для обработки ошибки нехватки мест на рейсе.
 */
public class NoSeatsAvailableException extends Exception {
    public NoSeatsAvailableException(String message) {
        super(message);
    }
    public NoSeatsAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
