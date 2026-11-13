package ru.sablin.lab5.models;


/**
 * Интерфейс с методами возврата билетов и денег за них.
 */
public interface Refundable {
    /**
     * Метод для расчета суммы возврата (с учетом штрафов).
     * @return сумма, которую вернут пассажиру
     */
    double calculateRefundAmount();

    /**
     * Метод проверки, можно ли вообще сдать билет.
     * @return true, если возврат разрешен
     */
    boolean isRefundable();
}
