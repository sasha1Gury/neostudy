package ru.neostudy.calculatorservice.service;

import ru.neostudy.calculatorservice.dto.RequestDateDto;
import ru.neostudy.calculatorservice.dto.RequestDto;

public interface CalculateService {
    Double calculate(RequestDto requestDto);

    Double calculateWithDate(RequestDateDto requestDateDto);
}
