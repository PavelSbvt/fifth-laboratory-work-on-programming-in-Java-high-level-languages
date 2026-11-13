package ru.sablin.lab5.models;


import ru.sablin.lab5.utils.Rich;

/**
 * Класс для чартерных рейсов (для туров. чартерные рейсы могут быть
 * не только от органищаторов туров, но я захотел ограничиться только
 * чартерными рейсами от турагенств)
 */
public class CharterFlights extends Flight implements TourBookable{
    /**
     * Название тура
     */
    private String nameTour;

    /**
     * Организатор рейса (например, туроператор)
     */
    private String flightOrganizer;
    /**
     * Минимальное число пассажиров
     */
    private int minimumRequiredPassengers;

    //    Геттеры==============================================
    public String getNameTour(){
        return this.nameTour;
    }

    public String getFlightOrganizer(){
        return this.flightOrganizer;
    }
    public int getMinimumRequiredPassengers(){
        return this.minimumRequiredPassengers;
    }


    //    Сеттеры==============================================
    public void setNameTour(String nameTour){
        this.nameTour = nameTour;
    }

    public void setFlightOrganizer(String flightOrganizer){
        this.flightOrganizer = flightOrganizer;
    }
    public void setMinimumRequiredPassengers(int minimumRequiredPassengers){
        this.minimumRequiredPassengers = minimumRequiredPassengers;
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
     * @param nameTour String - название тура от агенстрва
     * @param flightOrganizer String - организатор рейса (например, туроператор)
     * @param minimumRequiredPassengers int - минимальное число пассажиров на рейс
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
                                String nameTour,
                                String flightOrganizer,
                                int minimumRequiredPassengers) {
        String typeOfFlight = "Чартерный";

        super(flightId, pointOfDeparture, destinationPoint, carrierCompany, typeOfFlight,
                approximateFlightTime, departureTime, baseTicketPrice, numberOfSeats,
                bortId, nameOfTheAircraftModel, baggageAllowance, mealsDuringFlight);

        this.nameTour = nameTour;
        this.flightOrganizer = flightOrganizer;
        this.minimumRequiredPassengers = minimumRequiredPassengers;
    }

    /**
     * Функция для проверки набора минимального числа пассажиров на рейс
     * @param currentPassengers int - минимальное число пассажиров
     * @return String - строка-сообщение о статусе рейса
     */
    public String checkFlightLoadStatus(int currentPassengers){
        if (currentPassengers < this.minimumRequiredPassengers){
            return "Вероятно, рейс отменят. Не набрано минимально количество" +
                    " пассажиров (" + currentPassengers + "/" +
                    this.minimumRequiredPassengers + ")";
        } else {
            return "Рейс состоится. Набрано пассажиров: " + currentPassengers
                    + "/" + this.minimumRequiredPassengers;
        }
    }
    /**
     * Переопределённый метод вывода специальной информации о международных рейсах
     */
    @Override
    public void CallingSpecialFunctions(){
        Rich.debugLog("Название тура: " + this.nameTour);
        Rich.debugLog("Организатор: " + this.flightOrganizer);
        Rich.debugLog("Минимальное число пассажиров: " + this.minimumRequiredPassengers);
//        Rich.debugLog("Статус рейса: " + this.checkFlightLoadStatus());
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

//  Интерфейс
    /**
     * Функция для брони тура
     * @param touristsCount - количество туристов
     * @return String - возвращает строку с состоянием операции
     */
    @Override
    public String bookTour(int touristsCount) {
        if (touristsCount > 0) {
            if (touristsCount > getNumberOfSeats()) {
                return "Ошибка: недостаточно мест на чартере! Свободно: " + getNumberOfSeats();
            }

            setNumberOfSeats(getNumberOfSeats() - touristsCount);

            return "Тур успешно забронирован на " + touristsCount + " чел. " +
                    "Организатор: " + getFlightOrganizer();
        } else {
            return "Введены некоррекстные данные";
        }
    }
}
