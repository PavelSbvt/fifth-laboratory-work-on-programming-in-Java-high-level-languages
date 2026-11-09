package ru.sablin.lab5.models;

import ru.sablin.lab5.utils.Rich;


/**
 * Класс для межгосударственных рейсов
 */
public class InternationalFlights extends Flight{
    /**
     * Норма провоза багажа
     */
    private String baggageAllowance;
    /**
     * Питание на борту (есть ли и, если есть, то какое)
     */
    private String mealsDuringFlight;
    /**
     * Нужен ли загранпаспорт
     */
    private Boolean needVisa;

    //    Геттеры==============================================
    public String getBaggageAllowance(){
        return this.baggageAllowance;
    }

    public String getMealsDuringFlight(){
        return this.mealsDuringFlight;
    }

    public Boolean getNeedVisa(){
        return this.needVisa;
    }
    //    Сеттеры==============================================
    public void setBaggageAllowance(String baggageAllowance){
        this.baggageAllowance = baggageAllowance;
    }

    public void setMealsDuringFlight(String mealsDuringFlight){
        this.mealsDuringFlight = mealsDuringFlight;
    }

    public void setNeedVisa(Boolean needVisa){
        this.needVisa = needVisa;
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
     * @param needVisa Boolean - Требование загранпаспорта
     */
    public InternationalFlights(int flightId,
                                String pointOfDeparture,
                                String destinationPoint,
                                String carrierCompany,
                                int approximateFlightTime,
                                String departureTime,
                                int baseTicketPrice,
                                int numberOfSeats,
                                int bortId,
                                String nameOfTheAircraftModel,
                                String baggageAllowance,
                                String mealsDuringFlight,
                                Boolean needVisa) {
        String typeOfFlight = "Международный";

        super(flightId, pointOfDeparture, destinationPoint, carrierCompany, typeOfFlight,
                approximateFlightTime, departureTime, baseTicketPrice, numberOfSeats,
                bortId, nameOfTheAircraftModel);

        this.baggageAllowance = baggageAllowance;
        this.mealsDuringFlight = mealsDuringFlight;
        this.needVisa = needVisa;
    }

    /**
     * Переопределённый метод для получения итоговой стоимости билета
     * с учётом повышаюшего коэффициента и, например, страховок
     * @return double итоговая стоимость билета
     */
    @Override
    public double calculateTicketPrice() {
        return getBaseTicketPrice() * 1.1;
    }

    /**
     * Переопределённый метод для получения строки с особенностями рейса
     * @return String - возвращает особенности рейса
     */
    @Override
    public String getFlightEvent(){
        return "Акция - для получения скидки можно использовать Ozon-мили" +
                " или баллы компании";
    }

    /**
     * Функция для возврата небольшой аннотации о рейсе
     * @return String - текст аннотации
     */
    @Override
    public String getAnnotationText(){
        return "Международный рейс (InternationalFlight) — это авиаперелет, который" +
                " выполняется между двумя или более государствами и обязательно " +
                "предполагает пересечение государственных границ.\n" +
                "\n" +
                "Ключевые особенности:\n" +
                "\n" +
                "    Паспортный и таможенный контроль: для совершения перелета " +
                "пассажирам требуются действующие загранпаспорта, а в ряде случаев" +
                " — визы и соблюдение миграционных правил страны прибытия.\n" +
                "\n" +
                "    Дополнительные сборы: стоимость билета включает международные " +
                "аэропортовые сборы, топливные надбавки и страховки, из-за чего цена," +
                " как правило, выше, чем на внутренних рейсах.\n" +
                "\n" +
                "    Временные пояса: рейс может выполняться со сменой часовых поясов," +
                " что важно учитывать при расчете времени в пути и стыковок.\n" +
                "\n" +
                "    Багаж: нормы провоза багажа регулируются международными " +
                "конвенциями и правилами конкретных стран (часто действуют более " +
                "строгие ограничения).";
    }
}
