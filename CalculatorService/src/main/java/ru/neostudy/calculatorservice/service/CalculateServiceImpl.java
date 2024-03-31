package ru.neostudy.calculatorservice.service;

import org.springframework.stereotype.Service;
import ru.neostudy.calculatorservice.dto.RequestDateDto;
import ru.neostudy.calculatorservice.dto.RequestDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class CalculateServiceImpl implements CalculateService{
    private final List<LocalDate> holidayList = List.of(
            LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 1, 2),
            LocalDate.of(2024, 1, 3),
            LocalDate.of(2024, 1, 4),
            LocalDate.of(2024, 1, 5),
            LocalDate.of(2024, 1, 6),  // Новый год
            LocalDate.of(2024, 1, 8),  // Рождество
            LocalDate.of(2024, 2, 23), // День защитника Отечества
            LocalDate.of(2024, 3, 8),  // Международный женский день
            LocalDate.of(2024, 5, 1),
            LocalDate.of(2024, 5, 2),
            LocalDate.of(2024, 5, 3),  // Праздник Весны и Труда
            LocalDate.of(2024, 5, 9),  // День Победы
            LocalDate.of(2024, 6, 12), // День России
            LocalDate.of(2024, 11, 4)  // День народного единства
    );

    @Override
    public Double calculate(RequestDto requestDto) {
        Double daysInMonth = 29.4;
        Double avgMonthSalary = requestDto.getAvgSalary() / 12;
        Double avgDaysSalary = avgMonthSalary / daysInMonth;
        BigDecimal result = new BigDecimal(avgDaysSalary * requestDto.getVacationDays());
        return Double.valueOf(result.setScale(2, RoundingMode.DOWN).toString());
    }

    @Override
    public Double calculateWithDate(RequestDateDto requestDateDto) {
        long vacationDays = calculateDate(requestDateDto.getBeginVacation(), requestDateDto.getEndVacation());
        Double daysInMonth = 29.4;
        Double avgMonthSalary = requestDateDto.getAvgSalary() / 12;
        double avgDaysSalary = avgMonthSalary / daysInMonth;
        BigDecimal result = new BigDecimal(avgDaysSalary * vacationDays);
        return Double.valueOf(result.setScale(2, RoundingMode.DOWN).toString());
    }

    private Long calculateDate(LocalDate beginVacation, LocalDate endVacation) {
        long daysBetween = ChronoUnit.DAYS.between(beginVacation, endVacation) + 1; //не учитывается 1 день
        LocalDate currentDate = beginVacation;

        while (!currentDate.isAfter(endVacation)) {

            if (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    currentDate.getDayOfWeek() == DayOfWeek.SUNDAY ||
                    holidayList.contains(currentDate)) {
                daysBetween--;
            }

            currentDate = currentDate.plusDays(1);
        }
        return daysBetween;
    }

}
