package cotuba.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("cotuba")
@SpringBootApplication
public class Boot {
	
	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
	}

}
