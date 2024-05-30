package engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class WebQuizEngine {
    private static final Logger logger = LoggerFactory.getLogger(WebQuizEngine.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(WebQuizEngine.class, args);
        logger.info("The application runs at: http://localhost:{}", applicationContext.getEnvironment().getProperty("local.server.port"));
    }
}
