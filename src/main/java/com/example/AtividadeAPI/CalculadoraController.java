package com.example.AtividadeAPI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping(value = "/dividir", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> dividir(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            Map<String, String> response = new HashMap<>();
            response.put("mensagem", "Divisor não pode ser zero");
            return ResponseEntity
                    .badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        }
        return ResponseEntity.ok(a / b);
    }

    @RequestMapping(value = "/**", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> handleInvalidPath() {
        Map<String, String> response = new HashMap<>();
        response.put("erro", "Endpoint não encontrado");
        return ResponseEntity
                .status(404)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}