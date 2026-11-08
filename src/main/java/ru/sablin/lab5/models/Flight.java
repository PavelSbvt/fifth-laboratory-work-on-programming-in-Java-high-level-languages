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
//    /**
//     * Самолёт
//     */
//    Flyer Fly;
    /**
     * Тип рейса (внутренние, международные, чартерные)
     */
    String TypeOfFlight;
//    /**
//     * Прайс-лист цен на рейс
//     */
//    PriceList List;

    public Flight(int FlightId, String PointOfDeparture, String DestinationPoint,
                  String CarrierCompany, String TypeOfFlight){
        this.FlightId = FlightId;
        this.PointOfDeparture = PointOfDeparture;
        this.DestinationPoint = DestinationPoint;
        this.CarrierCompany = CarrierCompany;
        this.TypeOfFlight = TypeOfFlight;

        Rich.debugLog("Создан рейс " + FlightId + ", " + CarrierCompany);

        Rich.spacerPoints();
    }

    public void showInfoAboutFlight(){
        Rich.simpleLog("Информация о рейсе id=" + FlightId);
        Rich.debugLog("Компания-перевозчик: " + CarrierCompany);
        Rich.debugLog("Тип рейса: " + TypeOfFlight);
        Rich.debugLog("Пункт отправления: " + PointOfDeparture);
        Rich.debugLog("Пункт назначения: " + DestinationPoint);

        Rich.spacerPoints();
    }
}
