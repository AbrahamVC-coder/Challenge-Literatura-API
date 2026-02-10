package com.aluracursos.desafiobooksAPI;


import com.aluracursos.desafiobooksAPI.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DesafiobooksApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafiobooksApiApplication.class, args);
	}

    private final Principal principal;

    public DesafiobooksApiApplication(Principal principal){
        this.principal = principal;
    }

    @Override
    public void run(String... args) throws Exception {

        principal.mostrarMenu();

    }
}
