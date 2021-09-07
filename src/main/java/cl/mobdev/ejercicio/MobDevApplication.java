package cl.mobdev.ejercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackages = "cl.mobdev")
public class MobDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobDevApplication.class, args);
	}

}
