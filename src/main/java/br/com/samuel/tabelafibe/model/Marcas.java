package br.com.samuel.tabelafibe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Marcas(@JsonAlias("codigo") Integer codigo,
                     @JsonAlias("nome") String nome) {

}
