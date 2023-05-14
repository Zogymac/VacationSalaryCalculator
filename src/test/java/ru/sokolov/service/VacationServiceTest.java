package ru.sokolov.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sokolov.util.HolidayUtil;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VacationServiceTest {
    @InjectMocks
    private VacationService vacationService;

    @Mock
    private HolidayUtil holidayUtil;

    @Test
    void calculateVacationPay_noDates() {
        double result = vacationService.calculateVacationPay(30_000.0, 10, Collections.emptyList());

        assertEquals(10_000, result, 0.01);
    }

    @Test
    void calculateVacationPay_withDates_noHolidays() {
        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 1, 2);
        when(holidayUtil.isHoliday(date1)).thenReturn(false);
        when(holidayUtil.isHoliday(date2)).thenReturn(false);

        double result = vacationService.calculateVacationPay(30_000.0, 2, Arrays.asList(date1, date2));

        assertEquals(2_000, result, 0.01);
    }

    @Test
    void calculateVacationPay_withDates_withHolidays() {
        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 1, 2);
        when(holidayUtil.isHoliday(date1)).thenReturn(true);
        when(holidayUtil.isHoliday(date2)).thenReturn(false);

        double result = vacationService.calculateVacationPay(30_000.0, 2, Arrays.asList(date1, date2));

        assertEquals(1_000, result, 0.01);
    }
}
