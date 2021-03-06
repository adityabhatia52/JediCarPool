/**
 * 
 */
package com.practo.carpool.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author aditya
 *
 */
@SpringBootApplication
@ImportResource("classpath:hibernate.xml")
@ComponentScan(basePackages = {"com.practo.carpool"})
@EnableJpaRepositories(basePackages = {"com.practo.carpool.repository"})
@EntityScan("com.practo.carpool.data.entity")
public class Application extends SpringBootServletInitializer
{

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
