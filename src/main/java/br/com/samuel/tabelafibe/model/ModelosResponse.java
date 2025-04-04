package br.com.samuel.tabelafibe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelosResponse {
    private List<Modelos> modelos;

    public List<Modelos> getModelos() {
        return modelos;
    }
}
