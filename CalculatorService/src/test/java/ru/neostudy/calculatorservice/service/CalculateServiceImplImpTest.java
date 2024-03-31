package ru.neostudy.calculatorservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.neostudy.calculatorservice.dto.RequestDateDto;
import ru.neostudy.calculatorservice.dto.RequestDto;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceImplImpTest {
    private CalculateService calculateService;

    @BeforeEach
    void setUp() {
        calculateService = new CalculateServiceImpl();
    }

    @Test
    void calculate() {
        RequestDto requestDto = new RequestDto();
        requestDto.setAvgSalary(300000.0);
        requestDto.setVacationDays(28L);
        Double result = calculateService.calculate(requestDto);
        assertEquals(23809.52, result);
    }

    @Test
    void calculateWithDate() {
        List<LocalDate> holidayList = List.of(LocalDate.of(2024, 1, 8));

        RequestDateDto requestDateDto = new RequestDateDto();
                requestDateDto.setAvgSalary(300000.0);
                requestDateDto.setBeginVacation(LocalDate.of(2024, 1, 8));
                requestDateDto.setEndVacation(LocalDate.of(2024, 1, 14));

        Double result = calculateService.calculateWithDate(requestDateDto);
        assertEquals(3401.36, result);
    }
}