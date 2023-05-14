package ru.sokolov.controller;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sokolov.model.Vacation;
import ru.sokolov.service.VacationService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VacationController {
    @Autowired
    private VacationService vacationService;

    @GetMapping("/calculate")
    public ResponseEntity<Vacation> calculateVacationPay(
            @RequestParam double averageSalary,
            @RequestParam int vacationDays,
            @RequestParam(required = false) List<LocalDate> vacationDates) {
        double vacationPay = vacationService.calculateVacationPay(averageSalary, vacationDays, vacationDates);
        Vacation vacation = new Vacation(vacationPay);
        return ResponseEntity.ok(vacation);
    }
}
