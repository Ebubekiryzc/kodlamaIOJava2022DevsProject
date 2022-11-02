package kodlama.io.devs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DevsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevsApplication.class, args);
    }

}
