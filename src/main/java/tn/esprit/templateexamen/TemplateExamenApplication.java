package tn.esprit.templateexamen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TemplateExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateExamenApplication.class, args);
	}

}
