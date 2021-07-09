package com.example.potato2teambackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableJpaAuditing
@SpringBootApplication
public class Potato2teamBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(Potato2teamBackendApplication.class, args);
    }

}
