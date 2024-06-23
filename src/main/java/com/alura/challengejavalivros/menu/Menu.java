package com.alura.challengejavalivros.menu;

import com.alura.challengejavalivros.model.Autor;
import com.alura.challengejavalivros.model.AutorDb;
import com.alura.challengejavalivros.model.Livro;
import com.alura.challengejavalivros.model.Results;
import com.alura.challengejavalivros.repository.AutorRepositoy;
import com.alura.challengejavalivros.services.ConsultaApi;
import com.alura.challengejavalivros.services.ConverteDados;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final String URL_API = "https://gutendex.com/books/?search=dom+casmurro";
    private ConsultaApi consulta = new ConsultaApi();
    private Scanner scanner = new Scanner(System.in);
    private ConverteDados conversor = new ConverteDados();

    private final AutorRepositoy repositorio;

    public Menu(AutorRepositoy repositorio) {
        this.repositorio = repositorio;
    }

    public void menu() {

        var menu = """
                ---EXIBIR LIVRO ? ---
                1 - SIM
                2 - NÃO
                """;
        boolean mostrarMenu = true;
        while (mostrarMenu) {
            System.out.println(menu);
            var opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    var json = consulta.resultadoApi(URL_API);
                    System.out.println(json);
                    Livro results = conversor.obterDados(json, Livro.class);
                    var autor = results.result().getFirst().autores().getFirst();
                    AutorDb autorDb = new AutorDb(autor);
                    System.out.println(results.result());
                    repositorio.save(autorDb);
                    mostrarMenu = false;
                    break;
                default:
                    mostrarMenu = false;
                    break;
            }
        }


    }

}
