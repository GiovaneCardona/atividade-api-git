package com.example.AtividadeAPI;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    @GetMapping("/somar")
    public double somar(@RequestParam double a, @RequestParam double b) {
        return a + b;
    }

    @GetMapping("/subtrair")
    public double subtrair(@RequestParam double a, @RequestParam double b) {
        return a - b;
    }

    @GetMapping("/multiplicar")
    public double multiplicar(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }

    @GetMapping("/dividir")
    public double dividir(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor não pode ser zero");
        }
        return a / b;
    }
}
