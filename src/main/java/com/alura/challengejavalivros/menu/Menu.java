package com.alura.challengejavalivros.menu;

import com.alura.challengejavalivros.DTO.DadosAutor;
import com.alura.challengejavalivros.DTO.DadosLivro;
import com.alura.challengejavalivros.DTO.DadosResult;
import com.alura.challengejavalivros.model.*;
import com.alura.challengejavalivros.repository.AutorRepository;
import com.alura.challengejavalivros.repository.LivroRepositoy;
import com.alura.challengejavalivros.services.ConsultaApi;
import com.alura.challengejavalivros.services.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private final String URL_API = "https://gutendex.com/books/?search=";
    private ConsultaApi consulta = new ConsultaApi();
    private Scanner scanner = new Scanner(System.in);
    private ConverteDados conversor = new ConverteDados();

    private final LivroRepositoy repositorio;
    private final AutorRepository autorRepository;

    private boolean mostrarMenu = true;
    public Menu(LivroRepositoy repositorio, AutorRepository autorRepository) {
        this.repositorio = repositorio;
        this.autorRepository = autorRepository;
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

        while (mostrarMenu) {
            System.out.println(menu);
            var opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    this.buscarLivroPeloTitulo();
                    break;
                default:
                    mostrarMenu = false;
                    break;
            }
        }


    }

    public void buscarLivroPeloTitulo() {

        System.out.println("Informe um título: ");
        var titulo = scanner.nextLine().toLowerCase().replace(" ", "%20");
        boolean livroCadastrado =  this.verificaLivroCadastrado(titulo.replace("%20", " "));

        if(!livroCadastrado) {
            String json = consulta.resultadoApi(URL_API + titulo);
            var dadosLivro = conversor.obterDados(json, DadosResult.class);

            this.verificaAutorCadastrado(dadosLivro.livros().getFirst());



//            Livro livro = new Livro(dadosLivro.livros().getFirst());
//            livro.setAutor(autor);
//            repositorio.save(livro);
//
//            System.out.println("LIVRO ENCONTRADO:");
//            System.out.println(livro);
        }

        this.mostrarMenu = false;

    }
    public Boolean verificaLivroCadastrado(String titulo) {
        var tituloJaCadastrado = repositorio.existsByTitulo(titulo);
//
        if(tituloJaCadastrado) {
            var livroDb = repositorio.findByTitulo(titulo);
            System.out.println("LIVRO JÁ CADASTRADO");
            System.out.println(livroDb);
            return true;
        }

        return false;

    }

    public void verificaAutorCadastrado(DadosLivro dadosLivro) {
        System.out.println(dadosLivro.autores().getFirst().nome());
        var autor = autorRepository.findByNome(dadosLivro.autores().getFirst().nome());

        System.out.println("testttttttt");
        System.out.println(autor);
        Livro livro = new Livro(dadosLivro);
        List<Livro> listaLivros = new ArrayList<>();
        listaLivros.add(livro);
        if(autor.isPresent()) {
           Autor autor1 = new Autor();
           autor1.setNome(autor.get().getNome());
           autor1.setAnoNascimento(autor.get().getAnoNascimento());
           autor1.setAnoMorte(autor.get().getAnoMorte());
           autor1.setLivro(listaLivros);

           autorRepository.save(autor1);
        } else {
            
            repositorio.save(livro);
        }

    }

}
