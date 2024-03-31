package ru.neostudy.vacationcalculator.dto;

import lombok.Data;

@Data
public class RequestDto {
    private Double avgSalary;
    private Long vacationDays;
}
