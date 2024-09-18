package ru.neostudy.vacationcalculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.neostudy.vacationcalculator.dto.RequestDateDto;
import ru.neostudy.vacationcalculator.dto.RequestDto;
import ru.neostudy.vacationcalculator.service.VacationCalculatorService;

@RestController
@RequiredArgsConstructor
public class VacationCalculatorController {
    private final VacationCalculatorService vacationCalculatorService;

    @GetMapping("/calculate")
    public Double getVacationPay(@RequestParam("average_salary") Double averageSalary,
                                 @RequestParam("vacation_days") Long vacationDays) {
        RequestDto requestDto = new RequestDto();
        requestDto.setAvgSalary(averageSalary);
        requestDto.setVacationDays(vacationDays);
        return vacationCalculatorService.calculate(requestDto);
    }

    @PostMapping("/calculate")
    public Double getVacationPayByDays(@RequestBody RequestDateDto requestDateDto) {
        return vacationCalculatorService.calculateWithDate(requestDateDto);
    }

}
