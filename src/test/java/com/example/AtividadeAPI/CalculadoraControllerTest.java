package com.example.AtividadeAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculadoraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSomar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/calculadora/somar")
                        .param("a", "5")
                        .param("b", "3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("8.0"));
    }

    @Test
    public void testSubtrair() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/calculadora/subtrair")
                        .param("a", "10")
                        .param("b", "4"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("6.0"));
    }

    @Test
    public void testMultiplicar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/calculadora/multiplicar")
                        .param("a", "7")
                        .param("b", "3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("21.0"));
    }

    @Test
    public void testDividir() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/calculadora/dividir")
                        .param("a", "15")
                        .param("b", "3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("5.0"));
    }

    @Test
    public void testDividirPorZero() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/calculadora/dividir")
                        .param("a", "10")
                        .param("b", "0"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensagem").value("Divisor não pode ser zero"));
    }

    @Test
    public void testDividirComValoresDecimais() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/calculadora/dividir")
                        .param("a", "10.5")
                        .param("b", "2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("5.25"));
    }

    @Test
    public void testOperacaoInvalida() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/calculadora/operacao-invalida"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.erro").value("Endpoint não encontrado"));
    }
}