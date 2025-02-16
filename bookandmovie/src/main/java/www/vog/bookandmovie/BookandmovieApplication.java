package www.vog.bookandmovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "www.vog")
@EnableJpaRepositories("www.vog.repository")
@EntityScan("www.vog.models")
public class BookandmovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookandmovieApplication.class, args);
    }
}
