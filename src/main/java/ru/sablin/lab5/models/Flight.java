package ru.sablin.lab5.models;


import ru.sablin.lab5.utils.Rich;

/**
 * Абстрактный класс для рейса
 */
public abstract class Flight {
    /**
     * Номер рейса (id)
     */
    private int FlightId;
    /**
     * Место отправления
     */
    private String PointOfDeparture;
    /**
     * Место назначения
     */
    private String DestinationPoint;
    /**
     * Перевозчик (компания-компания)
     */
    private String CarrierCompany;
    /**
     * Самолёт - название модели
     */
    private String NameOfTheAircraftModel;
    /**
     * Идентификационный номер борта (самолёта)
     */
    private int BortId;
    /**
     * Количество мест
     */
    private int NumberOfSeats;
    /**
     * Тип рейса (внутренние, международные, чартерные)
     */
    private String TypeOfFlight;
    /**
     * Стоимость билета
     */
    private int BaseTicketPrice;
    /**
     * Время отправления (0-24 часа)
     */
    private String DepartureTime;
    /**
     * Приблизительное время в пути
     */
    private int ApproximateFlightTime;

//    Геттеры==================================================================
    public int getFlightId() {
        return FlightId;
    }

    public String getPointOfDeparture() {
        return PointOfDeparture;
    }

    public String getDestinationPoint() {
        return DestinationPoint;
    }

    public String getCarrierCompany() {
        return CarrierCompany;
    }

    public String getNameOfTheAircraftModel() {
        return NameOfTheAircraftModel;
    }

    public int getBortId() {
        return BortId;
    }

    public int getNumberOfSeats() {
        return NumberOfSeats;
    }

    public String getTypeOfFlight() {
        return TypeOfFlight;
    }

    public int getBaseTicketPrice() {
        return BaseTicketPrice;
    }

    public String getDepartureTime() {
        return DepartureTime;
    }

    public int getApproximateFlightTime() {
        return ApproximateFlightTime;
    }
//    Сеттеры==================================================================
    public void setPointOfDeparture(String pointOfDeparture) {
        this.PointOfDeparture = pointOfDeparture;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.DestinationPoint = destinationPoint;
    }

    public void setCarrierCompany(String carrierCompany) {
        this.CarrierCompany = carrierCompany;
    }

    public void setNameOfTheAircraftModel(String nameOfTheAircraftModel) {
        this.NameOfTheAircraftModel = nameOfTheAircraftModel;
    }

    public void setBortId(int bortId) {
        this.BortId = bortId;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.NumberOfSeats = numberOfSeats;
    }

    public void setTypeOfFlight(String typeOfFlight) {
        this.TypeOfFlight = typeOfFlight;
    }

    public void setBaseTicketPrice(int baseTicketPrice) {
        this.BaseTicketPrice = baseTicketPrice;
    }

    public void setDepartureTime(String departureTime) {
        this.DepartureTime = departureTime;
    }

    public void setApproximateFlightTime(int approximateFlightTime) {
        this.ApproximateFlightTime = approximateFlightTime;
    }

    /**
     * Конструктор сбоки рейса
     *
     * @param FlightId: id рейса
     * @param PointOfDeparture: место отправления
     * @param DestinationPoint: место назначения
     * @param CarrierCompany: компания-перевозчик
     * @param TypeOfFlight: тип рейса
     * @param ApproximateFlightTime: приблизительное время в пути
     * @param DepartureTime: время отпраления
     * @param BaseTicketPrice: стоимость билета
     * @param NumberOfSeats: количество мест
     * @param BortId: id борта
     * @param NameOfTheAircraftModel: модель самолёта
     */
    public Flight(int FlightId, String PointOfDeparture, String DestinationPoint,
                  String CarrierCompany, String TypeOfFlight, int ApproximateFlightTime,
                  String DepartureTime, int BaseTicketPrice, int NumberOfSeats, int BortId,
                  String NameOfTheAircraftModel){
        this.FlightId = FlightId;
        this.PointOfDeparture = PointOfDeparture;
        this.DestinationPoint = DestinationPoint;
        this.CarrierCompany = CarrierCompany;
        this.TypeOfFlight = TypeOfFlight;
        this.ApproximateFlightTime = ApproximateFlightTime;
        this.DepartureTime = DepartureTime;
        this.BaseTicketPrice = BaseTicketPrice;
        this.NumberOfSeats = NumberOfSeats;
        this.BortId = BortId;
        this.NameOfTheAircraftModel = NameOfTheAircraftModel;

        Rich.debugLog("Создан рейс " + FlightId + ", " + CarrierCompany);

        Rich.spacerPoints();
    }

    /**
     * Функция для вывода сведений о рейсе
     */
    public void showInfoAboutFlight(){
        Rich.simpleLog("Информация о рейсе №" + this.FlightId);
        Rich.debugLog("Компания-перевозчик: " + this.CarrierCompany);
        Rich.debugLog("Тип рейса: " + this.TypeOfFlight);
        Rich.debugLog("Пункт отправления: " + this.PointOfDeparture);
        Rich.debugLog("Пункт назначения: " + this.DestinationPoint);
        Rich.debugLog("Время отправления: " + this.DepartureTime);
        Rich.debugLog("Стоимость билета: " + this.calculateTicketPrice());
        Rich.debugLog("Мест: " + this.NumberOfSeats);
        Rich.debugLog("Модель самолёта: " + this.NameOfTheAircraftModel);
        Rich.debugLog("id борта: " + this.BortId);
        Rich.debugLog("Приблилизительное время в полёте: " + this.ApproximateFlightTime);
        Rich.debugLog("Особенность рейса: " + this.getFlightEvent());
        Rich.debugLog("Аннотация: " + this.getAnnotationText());

        Rich.spacerPoints();
    }

    /**
     * Абстрактный метод для вычисления итоговой стоимости билета (в зависимости от рейса
     * существуют коэффициенты, повышаюшие стоимость билетов)
     * @return Double - цена билета
     */
    public abstract double calculateTicketPrice();

    /**
     * Абстрактный метод для получения особенности рейса (в зависимости от типа
     * особенностью может быть, например, ограничение на багаж)
     * @return String - строка с уникальной особенностью
     */
    public abstract String getFlightEvent();

    /**
     * Абстрактный метод для получения аннотации о рейсе
     * @return String возвращает текст аннотации рейса
     */
    public abstract String getAnnotationText();
}
