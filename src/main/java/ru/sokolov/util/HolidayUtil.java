package ru.sokolov.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class HolidayUtil {
    public boolean isHoliday(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == dayOfWeek.SATURDAY || dayOfWeek == dayOfWeek.SUNDAY;
    }
}
