package br.com.samuel.tabelafibe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelos(@JsonAlias("codigo") Integer codigo,
                      @JsonAlias("nome") String Nome) {
}
