/**
 * 
 */
package com.practo.carpool.run;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * @author aditya
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.practo.carpool"})
@EnableJpaRepositories(basePackages = {"com.practo.carpool.repository"})
@EntityScan("com.practo.carpool.data.entity")
public class Application {
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
      SpringApplication.run(Application.class, args);
  }

}
