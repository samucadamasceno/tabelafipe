package br.com.samuel.tabelafibe;

import br.com.samuel.tabelafibe.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelafibeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TabelafibeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}

}
