package ru.sablin.lab5.models;

import ru.sablin.lab5.utils.Rich;


/**
 * Класс для внутренних рейсов
 */
public class DomesticFlight extends Flight {
    /**
     * Норма провоза багажа
     */
    private String baggageAllowance;
    /**
     * Питание на борту (есть ли и, если есть, то какое)
     */
    private String mealsDuringFlight;

//    Геттеры==============================================
    public String getBaggageAllowance(){
        return this.baggageAllowance;
    }

    public String getMealsDuringFlight(){
        return this.mealsDuringFlight;
    }
//    Сеттеры==============================================
    public void setBaggageAllowance(String baggageAllowance){
        this.baggageAllowance = baggageAllowance;
    }

    public void setMealsDuringFlight(String mealsDuringFlight){
        this.mealsDuringFlight = mealsDuringFlight;
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
     * @param baggageAllowance String - нормы багажа
     * @param mealsDuringFlight String - информация о питании во время полёта
     */
    public DomesticFlight(int flightId, String pointOfDeparture, String destinationPoint,
                          String carrierCompany, int approximateFlightTime,
                          String departureTime, int baseTicketPrice, int numberOfSeats, int bortId,
                          String nameOfTheAircraftModel, String baggageAllowance, String mealsDuringFlight) {
        String typeOfFlight = "Внутренний";

        super(flightId, pointOfDeparture, destinationPoint, carrierCompany, typeOfFlight,
                approximateFlightTime, departureTime, baseTicketPrice, numberOfSeats, bortId, nameOfTheAircraftModel);

        this.baggageAllowance = baggageAllowance;
        this.mealsDuringFlight = mealsDuringFlight;
    }

    /**
     * Переопределённый метод для получения итоговой стоимости билета
     * с учётом повышаюшего коэффициента и, например, страховок
     * @return double итоговая стоимость билета
     */
    @Override
    public double calculateTicketPrice() {
        // Для внутреннего рейса базовая цена + 5% сервисный сбор (просто пример)
        return getBaseTicketPrice() * 1.05;
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
