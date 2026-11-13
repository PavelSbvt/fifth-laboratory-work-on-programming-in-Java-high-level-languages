package ru.sablin.lab5;

import ru.sablin.lab5.utils.Rich;
import ru.sablin.lab5.models.Flight;
import ru.sablin.lab5.models.InternationalFlights;
import ru.sablin.lab5.models.DomesticFlight;
import ru.sablin.lab5.models.CharterFlights;
import ru.sablin.lab5.services.BookingService;
import ru.sablin.lab5.UI.Gui;

public class Main {

    /**
     * точка входа. вариант 4 - система управления авиалиниями:
     * рейсы (внутренние, международные, чартерные)
     */
    static void main() {
        Rich.spacerPoints();
        Rich.simpleLog("Запуск программы");
        Rich.spacerPoints();

        Gui window = new Gui();
        window.setVisible(true);

//        Flight firstFlight = new InternationalFlights(
//                1,
//                "Москва",
//                "Владивосток",
//                "Авиасейлс",
//                5,
//                "16.30",
//                24300,
//                140,
//                1301,
//                "Аирбас 701",
//                "1-2 единицы багажа",
//                "Дополнительно (платно)",
//                true,
//                true);
//
//        firstFlight.showInfoAboutFlight();
////        ======
//        DomesticFlight flight = new DomesticFlight(101, "Москва", "Сочи", "Аэрофлот",
//                3, "14.30", 5000, 5, 1234, "Boeing 737", "20кг", "Обед", 20.0, true);
//
//        BookingService service = new BookingService();
//
//        Rich.debugLog("ТЕСТ 1: Пытаемся купить 10 мест (а есть только 5) ===");
//        service.stepThree_UserClickedBookButton(flight, 10);
//
//        Rich.debugLog("ТЕСТ 2: Пытаемся купить 2 места ===");
//        service.stepThree_UserClickedBookButton(flight, 2);
    }
}
