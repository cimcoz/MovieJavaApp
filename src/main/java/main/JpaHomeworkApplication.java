package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "db")
public class JpaHomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHomeworkApplication.class, args);
	}

}
