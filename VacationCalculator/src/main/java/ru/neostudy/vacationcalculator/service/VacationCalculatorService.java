package ru.neostudy.vacationcalculator.service;

import ru.neostudy.vacationcalculator.dto.RequestDateDto;
import ru.neostudy.vacationcalculator.dto.RequestDto;

public interface VacationCalculatorService {
    Double calculate(RequestDto requestDto);

    Double calculateWithDate(RequestDateDto requestDateDto);
}
