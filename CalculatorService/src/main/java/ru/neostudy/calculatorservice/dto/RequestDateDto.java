package ru.neostudy.calculatorservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestDateDto {
    private LocalDate beginVacation;
    private LocalDate endVacation;
    private Double avgSalary;
}
