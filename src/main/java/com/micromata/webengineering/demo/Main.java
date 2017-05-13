package com.micromata.webengineering.demo;

import com.micromata.webengineering.demo.user.User;
import com.micromata.webengineering.demo.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main entry point and configuration base of the application.
 */
@EnableSwagger2
@SpringBootApplication
public class Main implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    /**
     * Configuration for Swagger.
     *
     * @return a docket.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    // Temporary ---------------------------------------------------------------------------------------------------

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // We use this approach to insert a user into the database until signup works.
        User user = userRepository.findByEmail("mlesniak@micromata.de");
        if (user != null) {
            LOG.info("User mlesniak@micromata.de exists.");
            return;
        }

        user = new User();
        user.setEmail("mlesniak@micromata.de");
        user.setPassword("foo");
        userRepository.save(user);
        LOG.info("User mlesniak@micromata.de created");
    }
}
