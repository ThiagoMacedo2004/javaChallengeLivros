package com.alura.challengejavalivros;

import com.alura.challengejavalivros.menu.Menu;
import com.alura.challengejavalivros.repository.AutorRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private AutorRepositoy repositorio;


    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu(repositorio);
		menu.menu();
	}
}
