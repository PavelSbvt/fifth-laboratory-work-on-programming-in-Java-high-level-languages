package ru.sablin.lab5.models;

import ru.sablin.lab5.utils.Rich;


/**
 * Класс для межгосударственных рейсов
 */
public class InternationalFlights extends Flight implements Bookable, Refundable{
    /**
     * Нужен ли загранпаспорт
     */
    private Boolean needVisa;
    /**
     * Наличие обратного билета
     */
    private boolean hasReturnTicket;
    //    Геттеры==============================================
    public Boolean getNeedVisa(){
        return this.needVisa;
    }
    public Boolean getHasReturnTicket(){
        return this.hasReturnTicket;
    }
    //    Сеттеры==============================================
    public void setNeedVisa(Boolean needVisa){
        this.needVisa = needVisa;
    }
    public void setHasReturnTicket(Boolean hasReturnTicket){
        this.hasReturnTicket = hasReturnTicket;
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
     * @param hasReturnTicket Boolean - наличие обратного билета
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
                                Boolean needVisa,
                                Boolean hasReturnTicket) {
        String typeOfFlight = "Международный";

        super(flightId, pointOfDeparture, destinationPoint, carrierCompany, typeOfFlight,
                approximateFlightTime, departureTime, baseTicketPrice, numberOfSeats,
                bortId, nameOfTheAircraftModel, baggageAllowance, mealsDuringFlight);

        this.needVisa = needVisa;
        this.hasReturnTicket = hasReturnTicket;
    }

    /**
     * Функция для вычисления экономии при оформлении рейса с обратным билетом
     * @return String - строка с пометкой "выгода" и суммой, которую сэкономит
     * клиент при оформлении обратного билета
     */
    public String calculateReturnTicketSavings(){
        double savings = (getBaseTicketPrice() * 1.25 * 2) - (getBaseTicketPrice() * 2.1);
        return String.format("Выгода: %.2f руб.", savings);
     }

    /**
     * Функция для получения текста предупреждения для клиентов рейсов,
     * для которых нужна виза.
     * @return String - строка с предупреждением о том, что нудна виза и напоминалка
     */
    public String textWarningMessage(){
        if (needVisa){
            return "Для полёта требуется виза. Не забудьте оформить визу и проверить" +
                    " срок действия загранпаспорта";
        } else {
            return "";
        }
    }

    /**
     * Переопределённый метод вывода специальной информации о международных рейсах
     */
    @Override
    public void CallingSpecialFunctions(){
        if (this.needVisa) {
            Rich.debugLog("Требование загранпаспорта: да");
        } else {
            Rich.debugLog("Требование загранпаспорта: нет");
        }

        if (hasReturnTicket){
            Rich.debugLog("Обратный билет: да");
        } else {
            Rich.debugLog("Обратный билет: нет");
        }
    }

    /**
     * Переопределённый метод для получения итоговой стоимости билета
     * с учётом повышаюшего коэффициента и наличия обратного билета
     * @return double итоговая стоимость билета
     */
    @Override
    public double calculateTicketPrice() {
        if (hasReturnTicket){
            return getBaseTicketPrice() * 2.1;
        } else {
            return getBaseTicketPrice() * 1.25;
        }
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
        return "\n Международный рейс (InternationalFlight) — это авиаперелет, который" +
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

    //    Мультиимплеметация
    // Из интерфейса Bookable
    @Override
    public boolean bookTicket(int seatsCount) {
        if (seatsCount > 0 && seatsCount <= getNumberOfSeats()) {
            setNumberOfSeats(getNumberOfSeats() - seatsCount); // Уменьшаем места
            return true;
        }
        return false; // Не хватило мест
    }
    // Из интерфейса Refundable
    @Override
    public double calculateRefundAmount() {
        // Возвращаем 80% стоимости (20% - штраф за возврат)
        return calculateTicketPrice() * 0.8;
    }

    // Из интерфейса Refundable
    @Override
    public boolean isRefundable() {
        return true; // Внутренние рейсы можно сдавать
    }
}
