package ru.sokolov.model;

import java.util.Objects;

public class Vacation {
    private double vacationPay;

    public Vacation() {
    }

    public Vacation(double vacationPay) {
        this.vacationPay = vacationPay;
    }

    public double getVacationPay() {
        return vacationPay;
    }

    public void setVacationPay(double vacationPay) {
        this.vacationPay = vacationPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacation vacation = (Vacation) o;
        return Double.compare(vacation.vacationPay, vacationPay) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vacationPay);
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "vacationPay=" + vacationPay +
                '}';
    }
}
