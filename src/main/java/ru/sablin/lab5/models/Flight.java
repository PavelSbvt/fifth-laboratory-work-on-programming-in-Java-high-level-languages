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
    /**
     * Норма провоза багажа
     */
    private String baggageAllowance;
    /**
     * Питание на борту (есть ли и, если есть, то какое)
     */
    private String mealsDuringFlight;

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

    public String getBaggageAllowance(){
        return this.baggageAllowance;
    }

    public String getMealsDuringFlight(){
        return this.mealsDuringFlight;
    }
//    Сеттеры==================================================================
    public void setFlightId(int flightId){this.FlightId = flightId;}

    public void setBaggageAllowance(String baggageAllowance){
    this.baggageAllowance = baggageAllowance;
}

    public void setMealsDuringFlight(String mealsDuringFlight){
        this.mealsDuringFlight = mealsDuringFlight;
    }

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
     * @param baggageAllowance String - нормы багажа
     * @param mealsDuringFlight String - информация о питании во время полёта
     */
    public Flight(int FlightId, String PointOfDeparture, String DestinationPoint,
                  String CarrierCompany, String TypeOfFlight, int ApproximateFlightTime,
                  String DepartureTime, int BaseTicketPrice, int NumberOfSeats, int BortId,
                  String NameOfTheAircraftModel, String baggageAllowance,
                  String mealsDuringFlight){
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
        this.baggageAllowance = baggageAllowance;
        this.mealsDuringFlight = mealsDuringFlight;

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
        Rich.debugLog("Приблилизительное время в полёте: " + this.ApproximateFlightTime);
        Rich.debugLog("Время отправления: " + this.DepartureTime);
        Rich.debugLog("Расчётное время прибытия: " + this.getApproximateArrivalTime());
        Rich.debugLog(String.format("Стоимость билета: %.2f", this.calculateTicketPrice()));
        Rich.debugLog("Мест: " + this.NumberOfSeats);
        Rich.debugLog("Модель самолёта: " + this.NameOfTheAircraftModel);
        Rich.debugLog("id борта: " + this.BortId);
        Rich.debugLog("Особенность рейса: " + this.getFlightEvent());
        Rich.debugLog("Аннотация: " + this.getAnnotationText());

        this.CallingSpecialFunctions();

        Rich.spacerPoints();
    }

    /**
     * Функция для получения маршрута рейса
     * @return String - строка с описанием маршрута - откуда и куда следует рейс
     */
    public String getRoute(){
        return this.PointOfDeparture + " -> " +  this.DestinationPoint;
    }

    /**
     * Функция для проверки - является ли полёт длительным
     * @return String - вернёт строку с описанием (лейблом или тегом) - краткой
     * пометкой по рейсу
     */
    public String checkIsLongFlight(){
        if (this.ApproximateFlightTime <= 4 && this.ApproximateFlightTime > 0){
            return "короткий рейс";
        } else if (this.ApproximateFlightTime > 4 && this.ApproximateFlightTime <= 8){
            return "среднедлительный рейс";
        } else if (this.ApproximateFlightTime > 8){
            return "дальний рейс";
        } else {
            return "ошибка проверки длительности рейса";
        }
    }

    /**
     * Функция для проверки является ли рейс ночным - вернёт лейб
     * @return String - возвращает текст для лейбла (клашки) с краткой
     * припиской о времени рейса
     */
    public String checkTimeOfDayOfFlight(){
        int dotIndex = this.DepartureTime.indexOf('.');
        int departureHour = Integer.parseInt(this.DepartureTime.substring(0, dotIndex));

        if (departureHour >= 0 && departureHour < 24){
            if (departureHour <= 3 || departureHour >= 21){
                return "ночной";
            } else if (departureHour > 3 && departureHour < 10){
                return "утренний";
            } else if (departureHour >= 10 && departureHour <= 17){
                return "дневной";
            } else {
                return "вечерний";
            }
        } else {
            return "Введено неправильное время отправления";
        }
     }

    /**
     * Функция для вычисления приблизительного времени прибытия
     * @return String - строку со временим прибытия час.минуты.
     */
    public String getApproximateArrivalTime(){
         int dotIndex = this.DepartureTime.indexOf('.');
         int departureHour = Integer.parseInt(this.DepartureTime.substring(0, dotIndex));
         int arrivalHour = (departureHour + this.ApproximateFlightTime) % 24;
         String minutesString = this.DepartureTime.substring(dotIndex + 1);

         return String.format("%02d",arrivalHour) + "." + minutesString;
     }

    /**
     * Абстрактный метод для вызова уникальных функций вывода данных о дочерних классах
     */
    public abstract void CallingSpecialFunctions();

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
