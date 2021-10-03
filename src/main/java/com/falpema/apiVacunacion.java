package com.falpema;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class apiVacunacion extends SpringBootServletInitializer implements CommandLineRunner {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(apiVacunacion.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(apiVacunacion.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// aquie se puede inicializar cualquier accion
	}

}
