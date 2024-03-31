package ru.neostudy.vacationcalculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.neostudy.vacationcalculator.dto.RequestDateDto;
import ru.neostudy.vacationcalculator.dto.RequestDto;

@Service
@RequiredArgsConstructor
public class VacationCalculatorServiceImpl implements VacationCalculatorService{
    private final WebClient webClient;

    @Override
    public Double calculate(RequestDto requestDto) {
        return webClient.post()
                .uri("http://localhost:8082/calculate")
                .bodyValue(requestDto)
                .retrieve()
                .bodyToMono(Double.class)
                .block();
    }

    @Override
    public Double calculateWithDate(RequestDateDto requestDateDto) {
        return webClient.post()
                .uri("http://localhost:8082/calculate-days")
                .bodyValue(requestDateDto)
                .retrieve()
                .bodyToMono(Double.class)
                .block();
    }
}