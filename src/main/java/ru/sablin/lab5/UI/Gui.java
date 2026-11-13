package ru.sablin.lab5.UI;

import ru.sablin.lab5.models.*;
import ru.sablin.lab5.services.BookingService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui extends JFrame {
    private JPanel mainPanel;
    private JComboBox<String> flightTypeCombo;
    private JTextField seatsField;
    private JButton bookButton;
    private JButton showInfoButton;
    private JTextArea outputArea;
    private JLabel label;

    private Flight currentFlight;
    private BookingService bookingService = new BookingService();

    public Gui() {
        setContentPane(mainPanel);
        setTitle("Система управления авиалиниями");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        flightTypeCombo.addItem("Внутренний");
        flightTypeCombo.addItem("Международный");
        flightTypeCombo.addItem("Чартерный");

        currentFlight = createTestFlight("Внутренний");

        showInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) flightTypeCombo.getSelectedItem();
                // Если текущего рейса нет или мы выбрали другой тип рейса, создаем новый
                if (currentFlight == null || !currentFlight.getTypeOfFlight().equals(selectedType)) {
                    currentFlight = createTestFlight(selectedType);
                }

                outputArea.setText(""); // Очищаем старое
                outputArea.append("ИНФОРМАЦИЯ О РЕЙСЕ\n");

                // данные абстрактного класса
                outputArea.append("ID рейса: " + currentFlight.getFlightId() + "\n");
                outputArea.append("Перевозчик: " + currentFlight.getCarrierCompany() + "\n");
                outputArea.append("Тип рейса: " + currentFlight.getTypeOfFlight() + "\n");
                outputArea.append("Маршрут: " + currentFlight.getRoute() + "\n");
                outputArea.append("Время вылета: " + currentFlight.getDepartureTime() + "\n");
                outputArea.append("Время прибытия: " + currentFlight.getApproximateArrivalTime() + "\n");
                outputArea.append("Время в пути: " + currentFlight.getApproximateFlightTime() + " ч.\n");
                outputArea.append("Длительность: " + currentFlight.checkIsLongFlight() + "\n");
                outputArea.append("Время суток: " + currentFlight.checkTimeOfDayOfFlight() + "\n");
                outputArea.append("Самолет: " + currentFlight.getNameOfTheAircraftModel() + " (Борт: " + currentFlight.getBortId() + ")\n");
                outputArea.append("Свободных мест: " + currentFlight.getNumberOfSeats() + "\n");
                outputArea.append("Багаж: " + currentFlight.getBaggageAllowance() + "\n");
                outputArea.append("Питание: " + currentFlight.getMealsDuringFlight() + "\n");

                outputArea.append(String.format("Базовая цена: %.2f руб.\n", (double)currentFlight.getBaseTicketPrice()));
                outputArea.append(String.format("Итоговая цена: %.2f руб.\n", currentFlight.calculateTicketPrice()));

                outputArea.append("Особенность (акция): " + currentFlight.getFlightEvent() + "\n");

                // данные наследников
                outputArea.append("\nДАННЫЕ НАСЛЕДНИКОВ\n");

                if (currentFlight instanceof DomesticFlight) {
                    DomesticFlight domestic = (DomesticFlight) currentFlight;
                    outputArea.append("Онлайн-регистрация: " + (domestic.getIsOnlineRegistrationAvailable() ? "Да" : "Нет") + "\n");
                    outputArea.append("Лимит багажа: " + domestic.getBaggageKgLimit() + " кг\n");
                    outputArea.append("Доплата за 5 кг перевеса: " + domestic.calculateExtraBaggageCost(5) + " руб.\n");

                } else if (currentFlight instanceof InternationalFlights) {
                    InternationalFlights international = (InternationalFlights) currentFlight;
                    outputArea.append("Требуется виза: " + (international.getNeedVisa() ? "Да" : "Нет") + "\n");
                    outputArea.append("Обратный билет: " + (international.getHasReturnTicket() ? "Да" : "Нет") + "\n");
                    outputArea.append(international.calculateReturnTicketSavings() + "\n");
                    if (international.getNeedVisa()) {
                        outputArea.append("Внимание: " + international.textWarningMessage() + "\n");
                    }

                } else if (currentFlight instanceof CharterFlights) {
                    CharterFlights charter = (CharterFlights) currentFlight;
                    outputArea.append("Название тура: " + charter.getNameTour() + "\n");
                    outputArea.append("Организатор: " + charter.getFlightOrganizer() + "\n");
                    outputArea.append("Мин. пассажиров: " + charter.getMinimumRequiredPassengers() + "\n");

                    outputArea.append("Статус: " + charter.checkFlightLoadStatus(charter.getNumberOfSeats()) + "\n");
                }

                outputArea.append("\nАННОТАЦИЯ\n");
                outputArea.append(currentFlight.getAnnotationText() + "\n");

                // Сбрасываем прокрутку в самый верх
                outputArea.setCaretPosition(0);
            }
        });

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int seats = Integer.parseInt(seatsField.getText());

                    bookingService.stepThree_UserClickedBookButton(currentFlight, seats);

                    JOptionPane.showMessageDialog(Gui.this,
                            "Операция бронирования завершена успешно!",
                            "Успех", JOptionPane.INFORMATION_MESSAGE);

                    showInfoButton.doClick();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Gui.this,
                            "Ошибка: Введите целое число мест!",
                            "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * Вспомогательный метод, чтобы не заполнять 15 полей вручную в GUI.
     * Он создает объекты с тестовыми данными в зависимости от выбора.
     */
    private Flight createTestFlight(String type) {
        if ("Международный".equals(type)) {
            return new InternationalFlights(1, "Москва", "Париж", "Аэрофлот",
                    8, "10.00", 30000, 100, 777, "Boeing 777",
                    "23кг", "Обед", true, false);
        } else if ("Чартерный".equals(type)) {
            return new CharterFlights(2, "Москва", "Анталья", "Победа",
                    4, "05.30", 15000, 50, 888, "Boeing 737",
                    "10кг", "Нет", "Летний тур", "Пегас", 40);
        } else {
            // По умолчанию Внутренний
            return new DomesticFlight(3, "Москва", "Сочи", "S7",
                    3, "14.30", 5000, 5, 1234, "Airbus A320",
                    "20кг", "Обед", 20.0, true);
        }
    }

    // Точка входа для запуска GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Gui().setVisible(true);
        });
    }
}