package ru.sablin.lab5.models;


/**
 * Класс для чартерных рейсов
 */
public class CharterFlights extends Flight {
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

    /**
     * Организатор рейса (например, туроператор)
     */
    private String flightOrganizer;

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

    public String getFlightOrganizer(){
        return this.flightOrganizer;
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

    public void setFlightOrganizer(String flightOrganizer){
        this.flightOrganizer = flightOrganizer;
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
     * @param flightOrganizer String - организатор рейса (например, туроператор)
     */
    public CharterFlights(int flightId,
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
                                String flightOrganizer) {
        String typeOfFlight = "Чартерный";

        super(flightId, pointOfDeparture, destinationPoint, carrierCompany, typeOfFlight,
                approximateFlightTime, departureTime, baseTicketPrice, numberOfSeats,
                bortId, nameOfTheAircraftModel);

        this.baggageAllowance = baggageAllowance;
        this.mealsDuringFlight = mealsDuringFlight;
        this.needVisa = needVisa;
        this.flightOrganizer = flightOrganizer;
    }

    /**
     * Переопределённый метод для получения итоговой стоимости билета
     * с учётом повышаюшего коэффициента и, например, страховок
     * @return double итоговая стоимость билета
     */
    @Override
    public double calculateTicketPrice() {
        return getBaseTicketPrice() * 1.3;
    }

    /**
     * Переопределённый метод для получения строки с особенностями рейса
     * @return String - возвращает особенности рейса
     */
    @Override
    public String getFlightEvent(){
        return "Акция - скидки и бонусы туроператора";
    }

    /**
     * Функция для возврата небольшой аннотации о рейсе
     * @return String - текст аннотации
     */
    @Override
    public String getAnnotationText(){
        return "Чартерный рейс (CharterFlight) — это нерегулярный авиаперелет, который " +
                "организуется по заказу конкретной организации (чаще всего " +
                "туроператора) или группы лиц для выполнения разовой перевозки. " +
                "В отличие от регулярных рейсов, он не входит в стандартное расписание" +
                " авиакомпании.\n" +
                "\n" +
                "Ключевые особенности:\n" +
                "\n" +
                "    Заказной характер: рейс выполняется по индивидуальному графику и " +
                "маршруту, который определяет заказчик (туроператор, спортивная " +
                "команда, корпорация).\n" +
                "\n" +
                "    Выкуп мест: обычно весь самолет или большая часть мест выкупается" +
                " заранее, поэтому билеты на такие рейсы часто продаются в составе " +
                "туристических пакетов, а не отдельно.\n" +
                "\n" +
                "    Возврат билетов: правила возврата строже, чем на регулярных " +
                "рейсах — часто билеты являются невозвратными или возвращаются с " +
                "большими штрафами.\n" +
                "\n" +
                "    Ценообразование: стоимость билета формируется туроператором и " +
                "зависит от сезона, спроса и условий контракта с авиакомпанией (часто" +
                " включает наценку за организацию перелета).";
    }
}
