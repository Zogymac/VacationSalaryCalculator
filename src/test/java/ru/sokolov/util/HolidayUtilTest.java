package ru.sokolov.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HolidayUtilTest {
    private HolidayUtil holidayUtil = new HolidayUtil();

    @Test
    void isHoliday_saturday() {
        boolean result = holidayUtil.isHoliday(LocalDate.of(2023, 5, 6));

        assertTrue(result);
    }

    @Test
    void isHoliday_sunday() {
        boolean result = holidayUtil.isHoliday(LocalDate.of(2023, 5, 7));

        assertTrue(result);
    }

    @Test
    void isHoliday_weekday() {
        boolean result = holidayUtil.isHoliday(LocalDate.of(2023, 5, 8));

        assertFalse(result);
    }
}
