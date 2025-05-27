package com.example.AtividadeAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

    @GetMapping("/somar")
    public ResponseEntity<Double> somar(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(a + b);
    }

    @GetMapping("/subtrair")
    public ResponseEntity<Double> subtrair(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(a - b);
    }

    @GetMapping("/multiplicar")
    public ResponseEntity<Double> multiplicar(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(a * b);
    }

    @GetMapping("/dividir")
    public ResponseEntity<?> dividir(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            return ResponseEntity.badRequest().body("Divisor não pode ser zero");
        }
        return ResponseEntity.ok(a / b);
    }
}