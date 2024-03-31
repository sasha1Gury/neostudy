package ru.neostudy.vacationcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationCalculatorController {

    @GetMapping("/calculacte")
    public String test() {
        return "sdhalksdjhfl";
    }

}
