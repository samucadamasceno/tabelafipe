package br.com.samuel.tabelafibe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Ano(@JsonAlias("codigo") String codigo,
                  @JsonAlias("nome") String nome) {
}
