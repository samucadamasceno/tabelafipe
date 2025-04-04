package br.com.samuel.tabelafibe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    public <T> T obterDados(String json, TypeReference<T> tipo) {
        try {
            return mapper.readValue(json, tipo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter JSON", e);
        }
    }

    public <T> T obterDadosModelo(String json, Class<T> classe){
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter JSON", e);
        }
    }
}
