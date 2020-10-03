package kz.iitu.pharm.drugservice.drugservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DrugServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugServiceApplication.class, args);
	}

}
