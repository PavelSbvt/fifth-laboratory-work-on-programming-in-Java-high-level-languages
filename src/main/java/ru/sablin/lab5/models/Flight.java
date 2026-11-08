package ru.sablin.lab5.models;


import ru.sablin.lab5.utils.Rich;

/**
 * Для рейса
 */
public class Flight {
    /**
     * Номер рейса (id)
     */
    int FlightId;
    /**
     * Место отправления
     */
    String PointOfDeparture;
    /**
     * Место назначения
     */
    String DestinationPoint;
    /**
     * Перевозчик (компания-компания)
     */
    String CarrierCompany;
    /**
     * Самолёт - название модели
     */
    String NameOfTheAircraftModel;
    /**
     * Идентификационный номер борта (самолёта)
     */
    int BortId;
    /**
     * Количество мест
     */
    int NumberOfSeats;
    /**
     * Тип рейса (внутренние, международные, чартерные)
     */
    String TypeOfFlight;
    /**
     * Стоимость билета
     */
    int TicketPrice;
    /**
     * Время отправления (0-24 часа)
     */
    String DepartureTime;
    /**
     * Приблизительное время в пути
     */
    int ApproximateFlightTime;

    public Flight(int FlightId, String PointOfDeparture, String DestinationPoint,
                  String CarrierCompany, String TypeOfFlight, int ApproximateFlightTime,
                  String DepartureTime, int TicketPrice, int NumberOfSeats, int BortId,
                  String NameOfTheAircraftModel){
        this.FlightId = FlightId;
        this.PointOfDeparture = PointOfDeparture;
        this.DestinationPoint = DestinationPoint;
        this.CarrierCompany = CarrierCompany;
        this.TypeOfFlight = TypeOfFlight;
        this.ApproximateFlightTime = ApproximateFlightTime;
        this.DepartureTime = DepartureTime;
        this.TicketPrice = TicketPrice;
        this.NumberOfSeats = NumberOfSeats;
        this.BortId = BortId;
        this.NameOfTheAircraftModel = NameOfTheAircraftModel;

        Rich.debugLog("Создан рейс " + FlightId + ", " + CarrierCompany);

        Rich.spacerPoints();
    }

    public void showInfoAboutFlight(){
        Rich.simpleLog("Информация о рейсе id=" + this.FlightId);
        Rich.debugLog("Компания-перевозчик: " + this.CarrierCompany);
        Rich.debugLog("Тип рейса: " + this.TypeOfFlight);
        Rich.debugLog("Пункт отправления: " + this.PointOfDeparture);
        Rich.debugLog("Пункт назначения: " + this.DestinationPoint);
        Rich.debugLog("Время отправления: " + this.DepartureTime);
        Rich.debugLog("Стоимость билета: " + this.TicketPrice);
        Rich.debugLog("Мест: " + this.NumberOfSeats);
        Rich.debugLog("Модель самолёта: " + this.NameOfTheAircraftModel);
        Rich.debugLog("id борта: " + this.BortId);

        Rich.spacerPoints();
    }
}
