package br.com.digisystem.secondtestdigisystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SecondTestDigisystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondTestDigisystemApplication.class, args);
	}

}
