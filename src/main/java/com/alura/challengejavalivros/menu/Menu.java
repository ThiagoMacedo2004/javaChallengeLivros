package com.alura.challengejavalivros.menu;

import com.alura.challengejavalivros.model.*;
import com.alura.challengejavalivros.repository.AutorRepositoy;
import com.alura.challengejavalivros.services.ConsultaApi;
import com.alura.challengejavalivros.services.ConverteDados;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final String URL_API = "https://gutendex.com/books/?search=";
    private ConsultaApi consulta = new ConsultaApi();
    private Scanner scanner = new Scanner(System.in);
    private ConverteDados conversor = new ConverteDados();

    private final AutorRepositoy repositorio;

    public Menu(AutorRepositoy repositorio) {
        this.repositorio = repositorio;
    }

    public void menu() {

        var menu = """
                \nSELECIONE UM NUMERO DE SUA OPÇÃO:
                
                1) Buscar livro pelo seu título
                2) Listar livros registrados
                3) Listar autores registrados
                4) Listar autores vivos em um determinado ano
                5) Listar livro em um determinado idioma
                0) Sair
                """;
        boolean mostrarMenu = true;
        while (mostrarMenu) {
            System.out.println(menu);
            var opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Informe o um título: ");
                    var titulo = scanner.nextLine().toLowerCase().replace(" ", "%20");
                    this.salvarAutor(titulo);
                    mostrarMenu = false;
                    break;
                default:
                    mostrarMenu = false;
                    break;
            }
        }


    }

    public void salvarAutor(String titulo) {
        var json = consulta.resultadoApi(URL_API + titulo);
        Livro results = conversor.obterDados(json, Livro.class);

        var livro = results.result().getFirst();

        LivroDb livroDb = new LivroDb(livro);
        AutorDb autorDb = new AutorDb(livro.autores().getFirst());

        repositorio.save(livroDb.getAutor());
        repositorio.save(livroDb.getAutor());
    }

}
