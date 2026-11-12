package ru.sablin.lab5.models;

import ru.sablin.lab5.utils.Rich;


/**
 * Класс для внутренних рейсов
 */
public class DomesticFlight extends Flight {
    /**
     * Возможна ли онлайн регистрация на рейс
     */
    private boolean isOnlineRegistrationAvailable;
    /**
     * лимит провоза багажа в кг
     */
    private double baggageKgLimit;

    //    Геттеры==============================================
    public boolean getIsOnlineRegistrationAvailable(){
        return this.isOnlineRegistrationAvailable;
    }
    public double getBaggageKgLimit(){
        return this.baggageKgLimit;
    }
    //    Сеттеры==============================================
    public void setIsOnlineRegistrationAvailable(boolean isOnlineRegistrationAvailable){
        this.isOnlineRegistrationAvailable = isOnlineRegistrationAvailable;
    }
    public void setBaggageKgLimit(double baggageKgLimit){
        this.baggageKgLimit = baggageKgLimit;
    }

    /**
     * Конструктор класса внутренних рейсов.
     * @param flightId int - номер рейса
     * @param pointOfDeparture String - место отправления
     * @param destinationPoint String - пункт назначения
     * @param carrierCompany String - компания-перевозчик
     * @param approximateFlightTime int - рассчётная длительность перелёта
     * @param departureTime String - время отпраления
     * @param baseTicketPrice int - базовая стоимость билета
     * @param numberOfSeats int - число мест
     * @param bortId int - номер борта
     * @param nameOfTheAircraftModel String - название модели самолёта (борта)
     * @param isOnlineRegistrationAvailable - boolean - разрешена ли онлайн регистрация на рейс
     * @param baggageKgLimit - double - лимит багажа в кг
     */
    public DomesticFlight(int flightId, String pointOfDeparture, String destinationPoint,
                          String carrierCompany, int approximateFlightTime,
                          String departureTime, int baseTicketPrice,
                          int numberOfSeats, int bortId, String nameOfTheAircraftModel,
                          String baggageAllowance, String mealsDuringFlight,
                          double baggageKgLimit, boolean isOnlineRegistrationAvailable) {
        String typeOfFlight = "Внутренний";

        super(flightId, pointOfDeparture, destinationPoint, carrierCompany, typeOfFlight,
                approximateFlightTime, departureTime, baseTicketPrice, numberOfSeats,
                bortId, nameOfTheAircraftModel, baggageAllowance, mealsDuringFlight);

        this.baggageKgLimit = baggageKgLimit;
        this.isOnlineRegistrationAvailable = isOnlineRegistrationAvailable;
    }

    /**
     * Функция для вычисления доплаты за перевес багажа
     * @param extraKg - double - перевес в кг
     * @return double - стоимость певеса в рублях
     */
    public double calculateExtraBaggageCost(double extraKg){
        return 500.0 * extraKg;
    }

    /**
     * Функция для проверки допустимого веса багажа
     * @param currentWeight double - принимает текущий вес багажа в кг
     * @return String - возвращает строку с соотбщением о перевесе, если превышен лимит
     */
    public String checkBaggageExtraAllowance(double currentWeight){
        if (currentWeight > this.baggageKgLimit){
            double extraKg = currentWeight - this.baggageKgLimit;
            return "Превышен лимит веса багажа. Перевес: " + extraKg;
        } else {
            return "Вес багажа не превысил лимит.";
        }
     }

    /**
     * Переопределённый метод вывода специальной информации о внутренних рейсах
     */
    @Override
    public void CallingSpecialFunctions(){
        if (this.isOnlineRegistrationAvailable) {
            Rich.debugLog("Онлайн регистрация: Разрешена");
        } else {
            Rich.debugLog("Онлайн регистрация: Запрещена");
        }

    }

    /**
     * Переопределённый метод для получения итоговой стоимости билета
     * с учётом повышаюшего коэффициента и, например, страховок
     * @return double итоговая стоимость билета
     */
    @Override
    public double calculateTicketPrice() {
        return getBaseTicketPrice() * 1.02;
    }

    /**
     * Переопределённый метод для получения строки с особенностями рейса
     * @return String - возвращает особенности рейса
     */
    @Override
    public String getFlightEvent(){
        return "Акция - для получения скидки можно использовать Ozon-мили";
    }

    /**
     * Функция для возврата небольшой аннотации о рейсе
     * @return String - текст аннотации
     */
    @Override
    public String getAnnotationText(){
        return "Внутренний рейс (DomesticFlight) — это авиаперелет, который выполняется " +
                "исключительно в пределах территории одной страны (без пересечения " +
                "государственных границ).\n" +
                "\n" +
                "Ключевые особенности:\n" +
                "\n" +
                "    Безвизовый режим: для пассажиров не требуются визы, загранпаспорта " +
                "или прохождение таможенного контроля (достаточно внутреннего паспорта).\n" +
                "\n" +
                "    Упрощенная регистрация: обычно доступна онлайн-регистрация и " +
                "упрощенные процедуры досмотра.\n" +
                "\n" +
                "    Багаж: нормы провоза багажа регулируются внутренними правилами " +
                "авиакомпании и законодательством страны (часто более лояльны, чем на " +
                "международных рейсах).\n" +
                "\n" +
                "    Ценообразование: стоимость билета, как правило, ниже, так как не " +
                "включает международные аэропортовые сборы и пошлины.";
    }
}
