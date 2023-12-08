package wsb.merito.tbaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class TbawApplication {

	public static void main(String[] args) {
		SpringApplication.run(TbawApplication.class, args);
	}

}
