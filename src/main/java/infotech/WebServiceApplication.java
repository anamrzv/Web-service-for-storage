package infotech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WebServiceApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(WebServiceApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
