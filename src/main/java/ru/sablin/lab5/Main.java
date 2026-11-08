package ru.sablin.lab5;

import ru.sablin.lab5.utils.Rich;
import ru.sablin.lab5.models.Flight;

public class Main {

    /**
     * точка входа. вариант 4 - система управления авиалиниями:
     * рейсы (внутренние, международные, чартерные)
     */
    static void main() {
        Rich.spacerPoints();
        Rich.simpleLog("Запуск программы");
        Rich.spacerPoints();

        Flight firstFlight = new Flight(
                1,
                "Москва",
                "Владивосток",
                "Авиасейлс",
                "Чартерный");

        firstFlight.showInfoAboutFlight();
    }
}
