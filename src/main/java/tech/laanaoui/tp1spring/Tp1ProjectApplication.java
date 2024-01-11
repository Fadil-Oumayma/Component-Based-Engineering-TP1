package tech.laanaoui.tp1spring;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.laanaoui.tp1spring.service.IEmailer;

@SpringBootApplication
@RequiredArgsConstructor
public class Tp1ProjectApplication {
    private final IEmailer emailer;


    public static void main(String[] args) {
        SpringApplication.run(Tp1ProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            System.out.println(emailer.send());
        };
    }

}
