package ru.neostudy.calculatorservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.neostudy.calculatorservice.dto.RequestDateDto;
import ru.neostudy.calculatorservice.dto.RequestDto;
import ru.neostudy.calculatorservice.service.CalculateService;
import ru.neostudy.calculatorservice.service.CalculateServiceImpl;

@RestController
@RequiredArgsConstructor
public class CalculateController {
    private final CalculateService calculateService;

    @PostMapping("/calculate")
    public Double calculate(@RequestBody RequestDto requestDto) {
        return calculateService.calculate(requestDto);
    }

    @PostMapping("/calculate-days")
    public Double calculateWithDate(@RequestBody RequestDateDto requestDateDto) {
        return calculateService.calculateWithDate(requestDateDto);
    }
}
