package ru.neostudy.calculatorservice.service;

import org.springframework.stereotype.Service;
import ru.neostudy.calculatorservice.dto.RequestDto;

@Service
public class CalculateService {
    public Double calculate(RequestDto requestDto) {
        Double daysInMonth = 29.4;
        Double avgMonthSalary = requestDto.getAvgSalary() / 12;
        return avgMonthSalary / daysInMonth;
    }
}
