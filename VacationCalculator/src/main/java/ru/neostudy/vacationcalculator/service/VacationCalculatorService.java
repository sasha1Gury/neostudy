package ru.neostudy.vacationcalculator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.neostudy.vacationcalculator.dto.RequestDto;

@Service
//@RequiredArgsConstructor
public class VacationCalculatorService {
    private final WebClient webClient;

    public VacationCalculatorService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Double calculate(RequestDto requestDto) {
        return webClient.post()
                .uri("http://localhost:8082/calculate")
                .bodyValue(requestDto) // Передача объекта RequestDto в теле запроса
                .retrieve()
                .bodyToMono(Double.class)
                .block();
    }
}