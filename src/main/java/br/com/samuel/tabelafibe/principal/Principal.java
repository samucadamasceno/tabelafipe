package br.com.samuel.tabelafibe.principal;

import br.com.samuel.tabelafibe.model.*;
import br.com.samuel.tabelafibe.service.ConsumoApi;
import br.com.samuel.tabelafibe.service.ConverteDados;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();

    public void exibeMenu() {
        System.out.println("Digite o tipo de veiculo(carros, motos, caminhoes):");
        var tipoVeiculo = leitura.nextLine().toLowerCase();
        var enderecoBase = "https://parallelum.com.br/fipe/api/v1/";
        var json = consumo.obterDados(enderecoBase + tipoVeiculo + "/marcas/");
        List<Marcas> marcas = converteDados.obterDados(json, new TypeReference<List<Marcas>>() {
        });
        marcas.forEach(System.out::println);

        System.out.println("Escolha uma marca acima pelo código:");
        var codigoMarca = leitura.nextLine();
        json = consumo.obterDados(enderecoBase + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/");
        ModelosResponse modelosResponse = converteDados.obterDadosModelo(json, ModelosResponse.class);
        List<Modelos> modelos = modelosResponse.getModelos();
        modelos.forEach(System.out::println);

        System.out.println("Digite o nome do veiculo");
        var nomeVeiculo = leitura.nextLine().trim().toLowerCase();
        List<Modelos> modelosFiltrados = modelos.stream().filter(e -> e.Nome().trim().toLowerCase().split(" ")[0].equals(nomeVeiculo)).collect(Collectors.toList());
        if (modelosFiltrados.isEmpty()) {
            System.out.println("Nenhum modelo encontrado com esse nome.");
        } else {
            modelosFiltrados.forEach(System.out::println);
        }

        System.out.println("Digite o código do modelo de seu veiculo:");
        var codigoModelo = leitura.nextLine();
        json = consumo.obterDados(enderecoBase + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos/");
        List<Ano> anos = converteDados.obterDados(json, new TypeReference<List<Ano>>() {
        });
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = enderecoBase + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            Veiculo veiculo = converteDados.obterDados(json, new TypeReference<Veiculo>() {
            });
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veículos filtrados com avaliações por ano: ");
        veiculos.forEach(System.out::println);
    }
}
