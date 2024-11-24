package ru.mdm.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MdmRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdmRegistryServiceApplication.class, args);
	}

}
