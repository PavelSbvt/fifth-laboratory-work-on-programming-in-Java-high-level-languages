package ru.sablin.lab5.models;


/**
 * Интерфейс для чартерных рейсов
 */
public interface TourBookable {
    /**
     * Метод для бронирования тура (включая перелет и проживание).
     * @param touristsCount - количество туристов
     * @return String - сообщение об успешном бронировании тура
     */
    String bookTour(int touristsCount);
}
