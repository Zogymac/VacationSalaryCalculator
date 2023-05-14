package ru.sokolov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sokolov.util.HolidayUtil;

import java.time.LocalDate;
import java.util.List;

@Service
public class VacationService {
    public HolidayUtil holidayUtil;
    public double calculateVacationPay(double averageSalary, int vacationDays, List<LocalDate> vacationDates) {
        if (vacationDates == null || vacationDates.isEmpty()) {
            return averageSalary / 30 * vacationDays;
        } else {
            int actualVacationDays = 0;
            for (LocalDate date : vacationDates) {
                if (!holidayUtil.isHoliday(date)) {
                    actualVacationDays++;
                }
            }
            return averageSalary / 30 * actualVacationDays;
        }
    }
}
