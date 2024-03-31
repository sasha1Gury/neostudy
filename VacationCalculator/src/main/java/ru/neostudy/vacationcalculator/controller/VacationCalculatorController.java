package ru.neostudy.vacationcalculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.neostudy.vacationcalculator.dto.RequestDto;
import ru.neostudy.vacationcalculator.service.VacationCalculatorService;

@RestController
//@RequiredArgsConstructor
public class VacationCalculatorController {
    private final VacationCalculatorService vacationCalculatorService;
    public VacationCalculatorController(VacationCalculatorService vacationCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
    }

    @PostMapping("/calculacte")
    public Double test(@RequestBody RequestDto requestDto) {
        return vacationCalculatorService.calculate(requestDto);
    }

}
