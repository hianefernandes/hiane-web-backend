package com.tiaNanda.receitas.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiExternaService {

    // Instância simples de RestTemplate para fazer requisições
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Método mais simples possível para consumir uma API externa.
     * Aqui vamos consultar uma API pública de piadas (exemplo).
     */
    public String buscarPiada() {

        // URL da API externa
        String url = "https://official-joke-api.appspot.com/random_joke";

        // Faz a requisição GET e recebe uma String
        String resposta = restTemplate.getForObject(url, String.class);

        // Devolve para o Controller
        return resposta;
    }
}