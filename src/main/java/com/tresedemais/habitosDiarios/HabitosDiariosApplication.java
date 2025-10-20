package com.tresedemais.habitosDiarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = "com.tresedemais.habitosDiarios"
)
@EnableJpaRepositories(basePackages = "com.tresedemais.habitosDiarios.repositories")
@EntityScan(basePackages = "com.tresedemais.habitosDiarios.models")


public class HabitosDiariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabitosDiariosApplication.class, args);
	}

}
