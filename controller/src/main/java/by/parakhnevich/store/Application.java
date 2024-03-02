package by.parakhnevich.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EntityScan("by.parakhnevich.store")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
